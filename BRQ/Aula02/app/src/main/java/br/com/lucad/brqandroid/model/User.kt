package br.com.lucad.brqandroid.model

class User(
       var email: String,
       var password: String,
) {

    fun validarEmail(): Boolean{
        return email.isNullOrEmpty()
    }

    fun validarSenha(): Boolean{
        return password.isNullOrEmpty()
    }

}