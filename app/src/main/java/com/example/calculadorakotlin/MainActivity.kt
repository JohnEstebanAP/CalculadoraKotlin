package com.example.calculadorakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0

    val SUMA = 1
    val RESTA = 2
    val MULTIPLICACION = 3
    val DIVISION = 4
    val MOD=5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn0.setOnClickListener{numeroPresionado("0")}
        btn1.setOnClickListener{numeroPresionado("1")}
        btn2.setOnClickListener{numeroPresionado("2")}
        btn3.setOnClickListener{numeroPresionado("3")}
        btn4.setOnClickListener{numeroPresionado("4")}
        btn5.setOnClickListener{numeroPresionado("5")}
        btn6.setOnClickListener{numeroPresionado("6")}
        btn7.setOnClickListener{numeroPresionado("7")}
        btn8.setOnClickListener{numeroPresionado("8")}
        btn9.setOnClickListener{numeroPresionado("9")}
        btnPunto.setOnClickListener{numeroPresionado(".")}

        btnBorrar.setOnClickListener{BorrarTodo()}
        btnSuma.setOnClickListener{ operacionPrecionada(SUMA)}
        btnResta.setOnClickListener{ operacionPrecionada(RESTA)}
        btnMultiplicacion.setOnClickListener{ operacionPrecionada(MULTIPLICACION)}
        btnDivicion.setOnClickListener{ operacionPrecionada(DIVISION)}
        btnPorcentaje.setOnClickListener{ operacionPrecionada(MOD)}

        btnTotal.setOnClickListener{ resultadototal()}

    }


    private fun numeroPresionado(digito: String){
        texViewResultado.text= "${texViewResultado.text}$digito"

        if (operacion == 0){
            num1=texViewResultado.text.toString().toDouble()
        }else{
            num2=texViewResultado.text.toString().toDouble()        }
    }

    private fun BorrarTodo(){
        texViewResultado.text=""
        num1 = 0.0
        num2 = 0.0
        operacion = 0
    }

    private fun operacionPrecionada(operacion: Int){
        this.operacion = operacion
        
        texViewResultado.text=""
    }

    private fun resultadototal(){
        var resultado = when(operacion){
            SUMA -> num1 + num2
            RESTA -> num1 - num2
            MULTIPLICACION -> num1 * num2
            DIVISION -> num1 / num2
            MOD -> num1 % num2
            else -> 0
        }

        texViewResultado.text= resultado.toString()

    }

    companion object{

    }
}