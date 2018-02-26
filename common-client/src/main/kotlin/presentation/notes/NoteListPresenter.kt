package presentation.notes

import common.launchUI
import presentation.CommonPresenter
import presentation.ViewError
import repository.NoteRepository

class NoteListPresenter(view: NoteListView) : CommonPresenter<NoteListView>(view) {

    private val repository by NoteRepository.lazyGet()

    override fun onCreate() {
        super.onCreate()
        onNotesRequested()
    }

    private fun onNotesRequested() {
        jobs += launchUI {
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
}