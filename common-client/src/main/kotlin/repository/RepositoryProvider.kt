package repository


expect object RepositoryProvider {
    actual fun getNewsRepository(): NoteRepository
}