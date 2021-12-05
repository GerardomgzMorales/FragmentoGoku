package com.geradev.mx.fragmentogoku

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class FragmentFreezer : Fragment() { //Toda clase hereda de un frgment

    private lateinit var imagenFreezer: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? { //onCreateView creamos para mostrar vista
        val vista = inflater.inflate(R.layout.fragment_freezer, container, false)
        imagenFreezer = vista.findViewById(R.id.IdFreezer1) // Obtenemos el Layoy
        return vista
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) { //Se reciben parametros
        super.onActivityCreated(savedInstanceState)
        setUpFragment()
    }

    private fun setUpFragment() {
        var fase = arguments?.getInt("fase") ?: 0
        if (fase <= 6) {
            showFase(fase)
            imagenFreezer.setOnClickListener {
                val nextFase = fase + 1
                val mainActi = requireActivity() as MainActivity
                mainActi.cargarFases(nextFase)
            }
        } else {
            fase = 0

            showFase(fase)
            imagenFreezer.setOnClickListener {
                val nextFase = fase + 1
                val mainActi = requireActivity() as MainActivity
                mainActi.cargarFases(nextFase)
            }
        }
    }

    private fun showFase(fase: Int) {
        when (fase) {
            1 -> {
                imagenFreezer.setImageResource(R.drawable.img_freezer_f1)
            }
            2 -> {
                imagenFreezer.setImageResource(R.drawable.img_freezer_f2)
            }
            3 -> {
                imagenFreezer.setImageResource(R.drawable.img_freezer_f3)
            }
            4 -> {
                imagenFreezer.setImageResource(R.drawable.img_freezer_f4)
            }
            5 -> {
                imagenFreezer.setImageResource(R.drawable.img_freezer_f5)
            }
            6 -> {
                imagenFreezer.setImageResource(R.drawable.img_freezer_f6)
            }
        }
    }
}