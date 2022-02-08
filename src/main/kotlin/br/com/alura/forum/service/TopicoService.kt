package br.com.alura.forum.service

import br.com.alura.forum.dto.NewTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.dto.UpdateTopicoForm
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoviewMapper
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private var topicos: MutableList<Topico> = mutableListOf(),
    private val topicoViewMapper: TopicoviewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundException: String = "Topico não encontrado"

    ) {

    init {
        println("service de topico")
//        val topico = Topico(
//            id = 1,
//            titulo = "Dúvida kotlin",
//            mensagem = "Variaveis",
//            curso = Curso(
//                id = 1,
//                nome = "Kotlin",
//                categoria = "Programacao"
//            ),
//            autor = Usuario(
//                id = 1,
//                nome = "José Bruno",
//                email = "jose@teste.com"
//            )
//        )
//
//        val topico2 = Topico(
//            id = 2,
//            titulo = "Dúvida kotlin 2",
//            mensagem = "Variaveis",
//            curso = Curso(
//                id = 2,
//                nome = "Kotlin 2",
//                categoria = "Programacao Avançada"
//            ),
//            autor = Usuario(
//                id = 2,
//                nome = "José Bruno",
//                email = "jose@teste.com"
//            )
//        )
//
//        this.topicos = listOf(topico, topico2)
    }

    fun criarTopicos(): List<TopicoView> {
        return this.topicos.map { topico ->
            this.topicoViewMapper.map(topico)
        }
    }

    fun showTopico(id: Long): TopicoView? {
        val topico =  this.topicos.find { topico ->
            topico.id == id
        }

        topico?.let {
            return this.topicoViewMapper.map(it)
        }?:run {
           throw NotFoundException(notFoundException)
        }
    }

    fun createTopico(form: NewTopicoForm): Topico {
        val topico = this.topicoFormMapper.map(form)
        topico.id = this.topicos.size.toLong() + 1
        this.topicos.add(topico)
        return topico
    }

    fun updateTopico(form: UpdateTopicoForm): TopicoView {
        val topico = this.topicos.find { it.id == form.idTitulo }

        topico?.let {
            topicos.remove(topico)
            val novoTopico = Topico(
                id = form.idTitulo,
                titulo = form.titulo,
                mensagem = form.mensagem,
                curso = it.curso,
                autor = it.autor,
                dataCriacao = it.dataCriacao
            )
            topicos.add(novoTopico)
            return this.topicoViewMapper.map(novoTopico)
        } ?: run {
            throw NotFoundException(notFoundException)
        }



    }

    fun deleteTopico(idTopico: Long): Boolean {
        val topico = this.topicos.find { it.id == idTopico }

        return topico?.let {
            this.topicos.remove(it)
        } ?: run {
            throw NotFoundException(message = notFoundException)
        }
    }

}