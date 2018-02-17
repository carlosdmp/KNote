package repository

actual object RepositoryProvider {
    actual fun getNoteRepository(): NoteRepository {
       return NoteRepositoryImpl()
    }
}