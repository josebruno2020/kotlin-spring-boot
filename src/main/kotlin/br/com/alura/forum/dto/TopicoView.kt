package br.com.alura.forum.dto

import br.com.alura.forum.model.StatusTopicoEnum
import java.time.LocalDateTime

data class TopicoView(
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopicoEnum,
    val dataCriacao: LocalDateTime
)
