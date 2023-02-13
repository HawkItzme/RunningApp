package com.example.runningapp.ui.fragments

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.runningapp.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CancellTrackingDialog : DialogFragment(){

    private var yesListner: (() -> Unit)? = null

    fun setYesListener(listener: () -> Unit){
        yesListner = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme)
            .setTitle("Cancel the Run?")
            .setMessage("Are you sure to cancel the current run and delete all its data?")
            .setIcon(R.drawable.ic_delete)
            .setPositiveButton("YES"){_, _ ->
                yesListner?.let {yes ->
                    yes()
                }
            }
            .setNegativeButton("No"){dialogInterface, _, ->
                dialogInterface.cancel()
            }
            .create()
        dialog?.show()
    }
}