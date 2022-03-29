package com.mesq.idgen


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val primeiroTexto: TextView = findViewById(R.id.TextView)
        val botaoPrincipal: Button = findViewById(R.id.button)
        botaoPrincipal.setOnClickListener {


            val alg1: Int = (1..9).random()        // gera os  9 primeiros dígitos do CPF de forma "aleatória"
            val alg2: Int = (1..9).random()
            val alg3: Int = (1..9).random()
            val alg4: Int = (1..9).random()
            val alg5: Int = (1..9).random()
            val alg6: Int = (1..9).random()
            val alg7: Int = (1..9).random()
            val alg8: Int = (1..9).random()
            val alg9: Int = (1..9).random()

            val t1 = alg1.times(10)             // Primeira etapa para determinar o primeiro
            val t2 = alg2.times(9)              // dígito verificador (d1):
            val t3 = alg3.times(8)              // multiplicar os 9 primeiros dígitos por 10,9,8,...,2
            val t4 = alg4.times(7)
            val t5 = alg5.times(6)
            val t6 = alg6.times(5)
            val t7 = alg7.times(4)
            val t8 = alg8.times(3)
            val t9 = alg9.times(2)

            // Segunda etapa para determinar d1: somar o resultado das multiplicações
            // e achar o resto (r) de sua divisão por 11
            val r: Int = (t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9) % 11

            var d1 = 50 // inicializei o dígito verificador com valor arbitrário que será
                        // modificado pela lógica do CPF
                        // olhar a função detD1 na MainActivity para entender

            fun detD1() {
                d1 = when (r) {
                    0 -> 0
                    1 -> 0
                    else -> 11 - r
                }
            }
            detD1()

            val z1 = alg2.times(10)         // Primeira etapa para determinar o segundo
            val z2 = alg3.times(9)          // dígito verificador (d2):
            val z3 = alg4.times(8)          // multiplicar os 9 dígitos a partir do segundo pela sequência
            val z4 = alg5.times(7)          // 10,9,8,...,2, tendo d1, calculado na primeira parte, como
            val z5 = alg6.times(6)          // o último fator da multiplicação
            val z6 = alg7.times(5)
            val z7 = alg8.times(4)
            val z8 = alg9.times(3)
            val z9 = d1.times(2)

            // Segunda etapa para determinar d2 (análoga a de d1): somar o resultado das multiplicações
            // e achar o resto (s) de sua divisão por 11

            val s: Int = (z1 + z2 + z3 + z4 + z5 + z6 + z7 + z8 + z9) % 11

            var d2 = 60 //Assim como fiz com d1, inicializei o segundo dígito verificador
                        // com um valor qualquer que será modificado na função detD2()


            fun detD2() {
                d2 = when (s) {
                    0 -> 0
                    1 -> 0
                    else -> 11 - s

                }
            }

            detD2()
            primeiroTexto.text = "$alg1$alg2$alg3.$alg4$alg5$alg6.$alg7$alg8$alg9-$d1$d2"
        }

    }
}


//TO DO: armazenar números de CPFs gerados
