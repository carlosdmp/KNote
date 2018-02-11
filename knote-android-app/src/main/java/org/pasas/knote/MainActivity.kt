package org.pasas.knote

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import data.Note
import dataflow.toJson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_view.text = Note("Hola mundito").toJson()
    }
}
