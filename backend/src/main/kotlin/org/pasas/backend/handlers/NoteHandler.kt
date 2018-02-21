package org.pasas.backend.handlers

import org.pasas.backend.entities.Note
import org.pasas.backend.repositories.NoteRepository

import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.*
import reactor.core.publisher.Mono

class NoteHandler(val notes: NoteRepository){

    fun all(req: ServerRequest) : Mono<ServerResponse> {
        return ok().body(this.notes.findAll(), Note::class.java)
    }

}