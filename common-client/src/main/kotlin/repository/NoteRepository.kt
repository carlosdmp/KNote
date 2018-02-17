package repository

import data.Note
import common.Provider

interface NoteRepository {
    suspend fun getNotes(): List<Note>

    companion object : Provider<NoteRepository>() {
        override fun create(): NoteRepository = RepositoryProvider.getNewsRepository()
    }
}