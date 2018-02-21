package org.pasas.backend.entities

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.mongodb.core.mapping.Document
import reactor.util.annotation.NonNull
import java.time.LocalDateTime

@Document
data class Note(
        @Id var id: String? = null,
        @NonNull var title: String? = null,
        var body: String? = null,
        @CreatedDate var createdDate: LocalDateTime = LocalDateTime.now()
)