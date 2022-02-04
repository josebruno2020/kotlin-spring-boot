package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Resposta
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class RespostaService(
    private var respostas: List<Resposta>
) {

    init {
        val curso = Curso(
            id = 1,
            nome = "Curso de JAVA",
            categoria = "Programação"
        )

        val usuario = Usuario(
            id = 1,
            nome = "José Bruno",
            email = "jb@teste.com"
        )

        val topico = Topico(
            id = 1,
            titulo = "TOPICO 1",
            mensagem = "DUVIDO SOBRE JAVA",
            curso = curso,
            autor = usuario
        )

        val resposta1 = Resposta(
            id = 1,
            mensagem = "RESPOSTA 1",
            autor = usuario,
            topico = topico
        )

        val resposta2 = Resposta(
            id = 2,
            mensagem = "RESPOSTA 2",
            autor = usuario,
            topico = topico,
            solucao = true
        )

        this.respostas = listOf(resposta1, resposta2)
    }


    fun showResposta(idTopico: Long): List<Resposta> {
        return this.respostas.filter { resposta ->
            resposta.topico.id == idTopico
        }
    }
}