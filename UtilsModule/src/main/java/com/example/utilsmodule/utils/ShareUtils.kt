package com.example.utilsmodule.utils

import android.content.Context
import android.content.Intent

class ShareUtils {
    fun shareByEmailToAddress(context: Context, address: String) {
        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf<String>(address))
        emailIntent.type = "message/rfc822"
        if (emailIntent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(emailIntent);
        }
    }
}
