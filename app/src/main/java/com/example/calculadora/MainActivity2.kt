package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.textView
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    private var numero1: Long = 0
    private var numero2: Long = 0
    private var operacion: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Log.v("F","Holaggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg")

        boton0b.setOnClickListener{presionar("0")}
        boton1b.setOnClickListener{presionar("1")}

        botonSumarB.setOnClickListener{
            operar(MainActivity2.SUMA)
        }

        botonRestarB.setOnClickListener{
            operar(MainActivity2.RESTA)
        }

        botonMultiplicaB.setOnClickListener{
            operar(MainActivity2.MULTIPLICACION)
        }

        botonDivideB.setOnClickListener{
            operar(MainActivity2.DIVIDIR)
        }

        botonBorrarB.setOnClickListener {
            numero1 = 0
            numero2 = 0
            textView2.text = ""
            operacion = MainActivity2.NO_OPERAR
        }

        botonIgualB.setOnClickListener{
            var numeroDec1 = convertirBinarioDecimal(numero1)
            var numeroDec2 = convertirBinarioDecimal(numero2)
            var resultado = when (operacion){
                MainActivity.SUMA -> numeroDec1 + numeroDec2
                MainActivity.RESTA -> numeroDec1 - numeroDec2
                MainActivity.MULTIPLICACION -> numeroDec1 * numeroDec2
                MainActivity.DIVIDIR -> numeroDec1 / numeroDec2
                else -> 0
            }
            var resultadoBinario = Integer.toBinaryString(resultado)
            Log.v("F",Integer.toBinaryString(resultado))
            textView2.text = resultadoBinario.toString()
        }

    }

    private fun presionar(numero: String){
        textView2.text = "${textView2.text}$numero"

        if(operacion == MainActivity2.NO_OPERAR){
            numero1 = textView2.text.toString().toLong()
        }
        else{
            numero2 = textView2.text.toString().toLong()
        }
    }

    private fun operar(operacion: Int){
        this.operacion=operacion
        numero1 = textView2.text.toString().toLong()

        textView2.text = ""
    }

    private fun convertirBinarioDecimal(num: Long): Int {
        var numero = num
        var numeroDecimal = 0
        var contador = 0
        var auxiliarnum: Long

        while (numero.toInt() != 0) {
            auxiliarnum = num % 10
            numero /= 10
            numeroDecimal += (auxiliarnum * Math.pow(2.0, contador.toDouble())).toInt()
            ++contador
        }
        return numeroDecimal
    }

    companion object{
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVIDIR = 4
        const val NO_OPERAR = 0
    }

}