package com.example.filmnet.util

sealed class ErrorEntity(val code: Int,val message: String) {
    class AccessDenied(_code: Int, _message: String) : ErrorEntity(_code, _message)
    class Connection(_code: Int, _message: String): ErrorEntity(_code, _message)
    class Unknown(_code: Int, _message: String): ErrorEntity(_code, _message)
}
