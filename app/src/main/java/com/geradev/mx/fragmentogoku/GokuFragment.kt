package com.geradev.mx.fragmentogoku

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class GokuFragment : Fragment() {

    private lateinit var imgenGoku: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_goku, container, false)
        imgenGoku = vista.findViewById(R.id.IdImageGoku)
        return vista
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpFragment()
    }


    private fun setUpFragment() {
        var fase = arguments?.getInt("fase") ?: 0
        if (fase <= 7) {
            showFase(fase)

            imgenGoku.setOnClickListener {
                val next = fase + 1
                val mainAct = requireActivity() as MainActivity
                mainAct.cargaFaseGoku(next)

            }

        } else {
            fase = 0
            showFase(fase)
            imgenGoku.setOnClickListener {
                val next = fase + 1
                val mainAct = requireActivity() as MainActivity
                mainAct.cargaFaseGoku(next)

            }
        }
    }

    private fun showFase(fase: Int) {
        when (fase) {
            0 -> {
                imgenGoku.setImageResource(R.drawable.img_goku)
            }
            1 -> {
                imgenGoku.setImageResource(R.drawable.img_goku_ss1)
            }
            2 -> {
                imgenGoku.setImageResource(R.drawable.img_goku_ss2)
            }
            3 -> {
                imgenGoku.setImageResource(R.drawable.img_goku_ss3)
            }
            4 -> {
                imgenGoku.setImageResource(R.drawable.img_goku_ss4)
            }
            5 -> {
                imgenGoku.setImageResource(R.drawable.img_goku_ss5)
            }
            6 -> {
                imgenGoku.setImageResource(R.drawable.img_goku_ss6)
            }
        }
    }

}