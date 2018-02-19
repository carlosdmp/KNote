package cdmp.carlos.knote_app.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import cdmp.carlos.knote_app.BaseActivity
import cdmp.carlos.knote_app.R
import cdmp.carlos.knote_app.adapter.SimpleRecyclerViewAdapter
import cdmp.carlos.knote_app.adapter.differ.ListDiffer
import data.Note
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.holder_note.*
import presentation.notes.NoteListPresenter
import presentation.notes.NoteListView

class HomeActivity : BaseActivity(), NoteListView {

    override fun showNoteList(notes: List<Note>) {
        notes.forEach { print(it) }
    }

    private val noteListPresenter by presenter { NoteListPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home);
        my_recycler_view.layoutManager = LinearLayoutManager(this)
        val adapter = SimpleRecyclerViewAdapter<Note>(mutableListOf<Note>(Note("Hola"), Note("Kotlin")), R.layout.holder_note,
                { item, view ->
                    view.findViewById<TextView>(R.id.text_view).text = item.title
                },
                itemDiffer = object : ListDiffer.ItemDiffer<Note> {
                    override fun areItemsTheSame(first: Note, second: Note) = first.title == second.title
                    override fun areContentsTheSame(first: Note, second: Note) = first == second
                })

        my_recycler_view.adapter = adapter

        adapter.update(mutableListOf<Note>(Note("Adios"), Note("Java")))
    }
}