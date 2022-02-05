package br.com.alura.forum.service

import br.com.alura.forum.dto.NewTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoviewMapper
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private var topicos: List<Topico> = listOf(),
    private val topicoViewMapper: TopicoviewMapper,
    private val topicoFormMapper: TopicoFormMapper,

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
        }!!

        return this.topicoViewMapper.map(topico)
    }

    fun createTopico(topicoDto: NewTopicoForm): Topico {
        val topico = this.topicoFormMapper.map(topicoDto)
        topico.id = this.topicos.size.toLong() + 1
        this.topicos = this.topicos.plus(topico)
        return topico
    }

}