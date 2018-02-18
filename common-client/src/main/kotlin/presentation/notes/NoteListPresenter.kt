package presentation.notes

import kotlinx.coroutines.experimental.async
import presentation.CommonPresenter
import presentation.ViewError
import presentation.notes.NoteListView
import repository.NoteRepository

class NoteListPresenter(view: NoteListView) : CommonPresenter<NoteListView>(view) {

    private val repository by NoteRepository.lazyGet()

    override fun onCreate() {
        super.onCreate()
    }

    suspend fun onNotesRequested() {
        repository.requestNotes { notes ->
            doInView {
                notes.handle(
                        onSuccess = {
                            showNoteList(it)
                        },
                        onFailure = {
                            showError(ViewError(it.message))
                        })
            }
        }
    }
}