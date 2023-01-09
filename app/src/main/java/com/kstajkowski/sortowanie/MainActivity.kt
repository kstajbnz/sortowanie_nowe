package com.kstajkowski.sortowanie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {

    lateinit var startBtn: Button
    lateinit var nrEt: EditText
    lateinit var poczatekLv: ListView
    lateinit var koniecLv:ListView
    lateinit var prgBar: ProgressBar
    var ArraySize = 0
    var Progress1 = 0





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}