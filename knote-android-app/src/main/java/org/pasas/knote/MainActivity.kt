package org.pasas.knote

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import data.Note
import dataflow.toJson
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    val notes = listOf<NoteBindModel>(Note("Hola").getBindModel(),Note("Kotlin").getBindModel())
    val editListener = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            padding = dip(30)
            editText {
                hint = "Name"
                textSize = 24f
                addTextChangedListener(editListener)

            }
            editText {
                hint = "Password"
                textSize = 24f
            }
            button("Login") {
                textSize = 26f
                onClick {
                    notes[0].note = Note("Adios")
                    notes[1].note = Note("Java")
                }
            }
            notes.forEach{
                textView {
                    observe(it,  { text = it.note.toJson() })
                }
            }


        }
    }
}

