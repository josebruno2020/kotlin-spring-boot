package br.com.alura.forum.exception

import java.time.LocalDateTime

data class ErrorView(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val mensagem: String?,
    val path: String
) {

}
