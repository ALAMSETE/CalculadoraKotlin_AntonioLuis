package com.example.calculadora

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var numero1: Double = 0.0
    private var numero2: Double = 0.0
    private var operacion : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
           PARA TRABAJAR CUANDO LA PANTALLA ESTA VERTICAL.
        }*/
        boton0.setOnClickListener{presionar("0")}
        boton1.setOnClickListener{presionar("1")}
        boton2.setOnClickListener{presionar("2")}
        boton3.setOnClickListener{presionar("3")}
        boton4.setOnClickListener{presionar("4")}
        boton5.setOnClickListener{presionar("5")}
        boton6.setOnClickListener{presionar("6")}
        boton7.setOnClickListener{presionar("7")}
        boton8.setOnClickListener{presionar("8")}
        boton9.setOnClickListener{presionar("9")}
        botonComa.setOnClickListener{presionar(",")}
        botonBinario.setOnClickListener {
            val lanza:Intent = Intent(this, MainActivity2::class.java)
            startActivity(lanza)
        }

        botonSuma.setOnClickListener{
            if(numero1==0.0){
                textView.text = ""
            }
            else{
                operar(SUMA)
            }
        }
        botonResta.setOnClickListener{
            if(numero1==0.0){
                textView.text = ""
            }
            else{
                operar(RESTA)
            }
        }
        botonMultiplica.setOnClickListener{
            if(numero1==0.0){
                textView.text = ""
            }
            else{
                operar(MULTIPLICACION)
            }
        }
        botonDivide.setOnClickListener{
            if(numero1==0.0){
                textView.text = ""
            }
            else{
                operar(DIVIDIR)
            }
        }

        botonBorrar.setOnClickListener {
            numero1 = 0.0
            numero2 = 0.0
            textView.text = ""
            operacion = NO_OPERAR
        }

        botonBinario.setOnClickListener {
            val lanzar:Intent = Intent(this, MainActivity2::class.java)
            startActivity(lanzar)
        }

        botonHexa.setOnClickListener {
            val lanzador:Intent = Intent(this, MainActivity3::class.java)
            startActivity(lanzador)
        }

        botonComa.setOnClickListener {

            if(textView.text.contains(".")||textView.text.isEmpty()){

            }
            else{
                var coma = "."
                textView.text = "${textView.text}$coma"
            }
        }

        botonIgual.setOnClickListener{
            var resultado = when (operacion){
                SUMA -> numero1 + numero2
                RESTA -> numero1 - numero2
                MULTIPLICACION -> numero1 * numero2
                DIVIDIR -> numero1 / numero2
                else -> 0
            }

            textView.text = resultado.toString()
        }
    }

    private fun presionar(numero: String){
        textView.text = "${textView.text}$numero"

        if(operacion == NO_OPERAR){
            numero1 = textView.text.toString().toDouble()
        }
        else{
            numero2 = textView.text.toString().toDouble()
        }
    }

    private fun operar(operacion: Int){
        this.operacion=operacion
        numero1 = textView.text.toString().toDouble()

        textView.text = ""
    }

    /*private fun lanzarLayout (view : View){
        val lanza = Intent(this, MainActivity2).aply{
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(lanza)
    }*/

    companion object{
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVIDIR = 4
        const val NO_OPERAR = 0
    }
}