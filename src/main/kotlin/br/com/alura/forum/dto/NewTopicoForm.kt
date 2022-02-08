package br.com.alura.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NewTopicoForm(
    @field: NotEmpty(message = "Titulo nao pode estar vazia")
    @field: Size(min= 2, message = "Titulo minimo 2 caracteres.")
    val titulo: String,
    @field: NotEmpty(message = "Mensagem não pode estar vazia")
    val mensagem: String,
    @field: NotNull
    val idCurso: Long,
    @field: NotNull
    val idAutor: Long
)
