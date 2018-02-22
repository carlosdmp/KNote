package org.pasas.backend.repositories

import org.pasas.backend.entities.Note
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class NoteRepository(private val template: ReactiveMongoTemplate){
    fun findAll() = template.findAll(Note::class.java)
    fun findById(id : String) = template.findById(id, Note::class.java)
    fun save(note: Note) = template.save(note)
    fun deleteAll() = template.remove(Query(), Note::class.java)
    fun deleteById(id: String) = template.remove(Query().addCriteria(Criteria.where("id").`is`(id)), Note::class.java)
}