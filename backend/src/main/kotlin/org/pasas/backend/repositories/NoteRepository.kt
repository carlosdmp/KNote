package org.pasas.backend.repositories

import org.pasas.backend.entities.Note
import org.springframework.data.mongodb.core.ReactiveMongoTemplate

class NoteRepository(private val template: ReactiveMongoTemplate){
    fun findAll() = template.findAll(Note::class.java)
    fun findById(id : Long) = template.findById(id, Note::class.java)
}