package presentation.notes

import data.Note
import presentation.CommonView

interface NoteListView : CommonView{
    fun showNoteList(notes: List<Note>)

}