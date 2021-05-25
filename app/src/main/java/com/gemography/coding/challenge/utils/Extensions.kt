package com.gemography.coding.challenge.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.gemography.coding.challenge.data.network.NetworkConstant
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun Throwable.getError(): String =
        when (this) {
            is HttpException -> NetworkConstant.OFFLINE_MESSAGE
            is SocketTimeoutException -> NetworkConstant.ERROR_MESSAGE
            is IOException -> NetworkConstant.ERROR_MESSAGE
            else -> localizedMessage ?: NetworkConstant.ERROR_MESSAGE
        }