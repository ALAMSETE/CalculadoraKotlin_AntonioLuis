package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {

    private var numero1: Long = 0
    private var numero2: Long = 0
    private var operacion : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        boton0H.setOnClickListener{presionar("0")}
        boton1H.setOnClickListener{presionar("1")}
        boton2H.setOnClickListener{presionar("2")}
        boton3H.setOnClickListener{presionar("3")}
        boton4H.setOnClickListener{presionar("4")}
        boton5H.setOnClickListener{presionar("5")}
        boton6H.setOnClickListener{presionar("6")}
        boton7H.setOnClickListener{presionar("7")}
        boton8H.setOnClickListener{presionar("8")}
        boton9H.setOnClickListener{presionar("9")}
        botonAH.setOnClickListener{presionar("A")}
        botonBH.setOnClickListener{presionar("B")}
        botonCH.setOnClickListener{presionar("C")}
        botonDH.setOnClickListener{presionar("D")}
        botonEH.setOnClickListener{presionar("E")}
        botonFH.setOnClickListener{presionar("F")}

        botonSumaH.setOnClickListener{
            operar(MainActivity3.SUMA)
        }

        botonRestaH.setOnClickListener{
            operar(MainActivity3.RESTA)
        }

        botonMultiplicaH.setOnClickListener{
            operar(MainActivity3.MULTIPLICACION)
        }

        botondDivideH.setOnClickListener{
            operar(MainActivity3.DIVIDIR)
        }

        botonBorrarH.setOnClickListener {
            numero1 = 0
            numero2 = 0
            textView3.text = ""
            operacion = MainActivity3.NO_OPERAR
        }

        botonIgualH.setOnClickListener{
            var resultado = when (operacion){
                MainActivity3.SUMA -> numero1 + numero2
                MainActivity3.RESTA -> numero1 - numero2
                MainActivity3.MULTIPLICACION -> numero1 * numero2
                MainActivity3.DIVIDIR -> numero1 / numero2
                else -> 0
            }

            textView3.text = resultado.toString()
        }

    }

    private fun presionar(numero: String){
        textView3.text = "${textView3.text}$numero"

        if(operacion == MainActivity3.NO_OPERAR){
            numero1 = textView3.text.toString().toLong(radix = 16)
        }
        else{
            numero2 = textView3.text.toString().toLong(radix = 16)
        }
    }

    private fun operar(operacion: Int){
        this.operacion=operacion
        numero1 = textView3.text.toString().toLong(radix = 16)

        textView3.text = ""
    }

    companion object{
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVIDIR = 4
        const val NO_OPERAR = 0
    }

}