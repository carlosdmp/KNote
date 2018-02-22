package org.pasas.backend.handlers

import constants.api.Endpoints
import org.pasas.backend.entities.Note
import org.pasas.backend.repositories.NoteRepository

import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.*
import reactor.core.publisher.Mono
import java.net.URI

class NoteHandler(private val notes: NoteRepository){

    fun all(req: ServerRequest) : Mono<ServerResponse> {
        return ok().body(this.notes.findAll(), Note::class.java)
    }

    fun get(req: ServerRequest): Mono<ServerResponse> {
        return this.notes.findById(req.pathVariable("id"))
                .flatMap { note -> ok().body(Mono.just(note), Note::class.java) }
                .switchIfEmpty(notFound().build())
    }

    fun create(req: ServerRequest): Mono<ServerResponse>{
        return req.bodyToMono(Note::class.java)
                .flatMap { note -> this.notes.save(note)}
                .flatMap { (id) -> created(URI.create("${Endpoints.noteEndpoint}${Endpoints.getNote(id!!)}")).build()}
    }

    fun update(req: ServerRequest): Mono<ServerResponse>{
        return this.notes.findById(req.pathVariable("id"))
                .zipWith(req.bodyToMono(Note::class.java))
                .map { it.t1.copy(title = it.t2.title, body = it.t2.body) }
                .flatMap { this.notes.save(it) }
                .flatMap { noContent().build() }
    }

    fun delete(req: ServerRequest): Mono<ServerResponse>{
        return this.notes.deleteById(req.pathVariable("id"))
                .flatMap { noContent().build() }
    }

}