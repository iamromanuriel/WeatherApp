package com.romanuriel.weatherapp.ui.mainweather

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.romanuriel.weatherapp.R
import com.romanuriel.weatherapp.databinding.FragmentDialogOptionDegreesBinding
import com.romanuriel.weatherapp.ui.BaseFragmentDialogBinding
import com.romanuriel.weatherapp.utils.FARENHEITE
import com.romanuriel.weatherapp.utils.KELVIN

class DialogFragmentOptionDegrees: DialogFragment(), DialogInterface.OnShowListener {
    private var positiveButton: Button? = null
    private var negativeButton: Button? = null
    lateinit var b: FragmentDialogOptionDegreesBinding
    private var type: Double? = null


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        activity?.let{ fragment ->
            b = FragmentDialogOptionDegreesBinding.inflate(LayoutInflater.from(context))
            b.let {
                val builder = AlertDialog.Builder(fragment)
                    .setTitle("Seleccion el tipo de temperatura")
                    .setItems(R.array.string_array_type,
                        DialogInterface.OnClickListener { dialogInterface, i ->

                        })
                    .setPositiveButton(android.R.string.ok,null)
                    .setNegativeButton(android.R.string.cancel,null)
                    .setView(it.root)

                val dialog = builder.create()
                dialog.setOnShowListener(this)
                return dialog
            }
        }
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onShow(dialogInterface: DialogInterface?) {
        val dialog = dialog as? AlertDialog
        dialog?.let {
            selectOptionDegrees()
            positiveButton = it.getButton(Dialog.BUTTON_POSITIVE)
            negativeButton = it.getButton(Dialog.BUTTON_NEGATIVE)

            positiveButton?.setOnClickListener{
                
            }
            negativeButton?.setOnClickListener {
                dismiss()
            }
        }
    }

    private fun selectOptionDegrees(){
        b.buttonDegressCelsius.setOnClickListener {
            type = KELVIN
        }

        b.buttonDegressFahrenheit.setOnClickListener {
            type = FARENHEITE
        }
    }

}