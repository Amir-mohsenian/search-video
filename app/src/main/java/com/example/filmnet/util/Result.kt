package com.example.filmnet.util

sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val errorEntity: ErrorEntity) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=${errorEntity.toString()}]"
        }
    }
}

val Result<*>.succeeded
    get() = this is Result.Success && data != null


fun <T> Result<T>.successOr(fallback: T): T {
    return (this as? Result.Success<T>)?.data ?: fallback
}