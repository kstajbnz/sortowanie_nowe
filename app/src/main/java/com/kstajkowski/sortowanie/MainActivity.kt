package com.kstajkowski.sortowanie

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var startBtn: Button
    lateinit var nrEt: EditText
    lateinit var poczatekLv: ListView
    lateinit var koniecLv:ListView
    lateinit var prgBar: ProgressBar
    var ArraySize = 0
    var Progress1 = 0




    fun bubbleSort(arr: IntArray): IntArray {
        var swapped: Boolean
        do {
            swapped = false
            for (i in 0 until arr.size - 1) {
                if (arr[i] > arr[i + 1]) {
                    val temp = arr[i]
                    arr[i] = arr[i + 1]
                    arr[i + 1] = temp
                    swapped = true

                }
            }
        } while (swapped)
        return arr
    }
    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBtn= findViewById(R.id.startBtn)
        nrEt = findViewById(R.id.nrEt)
        poczatekLv = findViewById(R.id.poczatekLv)
        koniecLv = findViewById(R.id.koniecLv)
        prgBar = findViewById(R.id.prgBar)

        startBtn.setOnClickListener {
            if(nrEt.text.isNotEmpty()){
                ArraySize = nrEt.text.toString().toInt()
                Log.d("dane","wielkoć tablicy: "+ArraySize)

                var Tablica = IntArray(ArraySize)

                prgBar.setVisibility(View.VISIBLE);
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }


                for(i in 0..ArraySize-1){
                    Tablica[i]=(0..1000).random()
                    Log.d("dane","Elementy Tablicy"+i+":"+Tablica[i].toString())

                }

                val ListBe = Tablica.toList()
                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ListBe)
                poczatekLv.adapter = adapter



                var PoTablica = IntArray(ArraySize)
                PoTablica = Tablica



                bubbleSort(PoTablica)


                val ListAf = PoTablica.toList()
                val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, ListAf)
                koniecLv.adapter = adapter1



            }else{
                Log.d("dane","Nie zostało kliknięte")
                Toast.makeText(this,"Proszę uzupełnić dane!", Toast.LENGTH_SHORT)

            }

        }
    }

}