package com.gemography.coding.challenge.utils



sealed class State<out E, out V> {
    data class Error<out E>(val message: E) : State<E, Nothing>()
    data class Success<out V>(val value: V) : State<Nothing, V>()
    object Loading : State<Nothing, Nothing>()
}
