package cdmp.carlos.knote_app.home

import android.os.Bundle
import cdmp.carlos.knote_app.BaseActivity
import data.Note
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import presentation.notes.NoteListPresenter
import presentation.notes.NoteListView

class HomeActivity : BaseActivity(), NoteListView{

    override fun showNoteList(notes: List<Note>) {
       notes.forEach{print(it)}
    }

    private val noteListPresenter by presenter { NoteListPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(30)
            editText {
                hint = "Name"
                textSize = 24f
            }
            editText {
                hint = "Password"
                textSize = 24f
            }
            button("Login") {
                textSize = 26f
                onClick {
                    noteListPresenter.onNotesRequested()
                }
            }
        }
    }
}