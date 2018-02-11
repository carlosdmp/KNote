package org.pasas.knote

import android.view.View
import android.widget.TextView
import data.Note
import java.util.*
import kotlin.properties.Delegates
import kotlin.properties.ObservableProperty

fun <T : BindModel> View.observe(bindModel: T, onchange : (T) -> Unit){
    bindModel.addListener { onchange.invoke(bindModel) }
    onchange.invoke(bindModel)
}
fun Note.getBindModel() = NoteBindModel(this)

