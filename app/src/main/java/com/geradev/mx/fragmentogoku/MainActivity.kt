package com.geradev.mx.fragmentogoku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cargarFases(0)

        //Validacion si el Frame existe (Si no se valida la existencia de este frame horizontal tronara la app)
        val existeframe = findViewById<FrameLayout>(R.id.idFrameGoku)
        if (existeframe != null) {
            cargaFaseGoku(0)
        }

    }

    fun cargarFases(fase: Int) {
        //Parametros
        val parametros = Bundle().apply {
            //Paso de parametros entre fragmentos
            putInt("fase", fase)
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.IdFrame2Freezzer, FragmentFreezer().apply {
                //Argumento este manda los valores de los argumentos
                arguments = parametros

            })//controla los gragmentos de la actividad
            commit()//se aplican y aplican los nuevos fragmentos al codigo
        }

    }


    fun cargaFaseGoku(fase: Int) {
        val parametros = Bundle().apply {
            //Paso de parametros entre fragmentos
            putInt("fase", fase)
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.idFrameGoku, GokuFragment().apply {
                //Argumento este manda los valores de los argumentos
                arguments = parametros

            })//controla los gragmentos de la actividad
            commit()//se aplican y aplican los nuevos fragmentos al codigo
        }
    }

}