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

class DialogFragmentOptionDegrees: DialogFragment(), DialogInterface.OnShowListener {
    private var positiveButton: Button? = null
    private var negativeButton: Button? = null
    lateinit var b: FragmentDialogOptionDegreesBinding


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        activity?.let{ fragment ->
            b = FragmentDialogOptionDegreesBinding.inflate(LayoutInflater.from(context))
            b.let {
                val builder = AlertDialog.Builder(fragment)
                    .setTitle("Seleccion el tipo de temperatura")
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
            positiveButton = it.getButton(Dialog.BUTTON_POSITIVE)
            negativeButton = it.getButton(Dialog.BUTTON_NEGATIVE)

            positiveButton?.setOnClickListener{

            }
            negativeButton?.setOnClickListener {
                dismiss()
            }
        }
    }




}