package repository


expect object RepositoryProvider {
    fun getNoteRepository(): NoteRepository
}