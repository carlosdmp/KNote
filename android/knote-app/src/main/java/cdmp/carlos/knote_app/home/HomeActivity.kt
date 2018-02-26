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

    val adapter = SimpleRecyclerViewAdapter<Note>(viewHolderLayout = R.layout.holder_note,
            holderInitializer = { item, view ->
                view.findViewById<TextView>(R.id.text_view).text = item.title
            },
            itemDiffer = object : ListDiffer.ItemDiffer<Note> {
                override fun areItemsTheSame(first: Note, second: Note) = first.title == second.title
                override fun areContentsTheSame(first: Note, second: Note) = first == second
            })

    override fun showNoteList(notes: List<Note>) {
        notes.forEach { print(it) }
        adapter.update(notes.toMutableList())
    }

    private val noteListPresenter by presenter { NoteListPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home);

        my_recycler_view.layoutManager = LinearLayoutManager(this)
        my_recycler_view.adapter = adapter
        adapter.update(mutableListOf<Note>(Note("Adiosss"), Note("Java")))

    }
}