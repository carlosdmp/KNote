package repository

import common.Provider
import data.Note
import presentation.Resource
import presentation.notes.NoteListView

abstract class NoteRepository {

    abstract suspend fun requestNotes(uiTask: ((Resource<List<Note>>) -> Unit))

    companion object : Provider<NoteRepository>() {
        override fun create(): NoteRepository = RepositoryProvider.getNoteRepository()
    }
}