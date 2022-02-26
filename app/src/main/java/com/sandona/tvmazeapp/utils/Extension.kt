package com.sandona.tvmazeapp.utils

import android.content.Context
import android.widget.Toast

object Extension {

    fun toastMessage(context: Context, msge: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(context, msge, length).show()
    }
}
