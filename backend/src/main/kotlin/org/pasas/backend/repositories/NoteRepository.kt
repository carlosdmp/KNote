package org.pasas.backend.repositories

import data.Note
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository interface NoteRepository : ReactiveMongoRepository<Note, Long>