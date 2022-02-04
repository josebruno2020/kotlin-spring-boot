package br.com.alura.forum.service

import br.com.alura.forum.dto.NewTopicoDto
import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private var topicos: List<Topico> = listOf(),
    private val cursoService: CursoService,
    private val autorService: AutorService

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

    fun criarTopicos(): List<Topico> {
        return this.topicos
    }

    fun showTopico(id: Long): Topico? {
        return this.topicos.find { topico ->
            topico.id == id
        }
    }

    fun createTopico(topicoDto: NewTopicoDto): Topico {
        val topico =  Topico(
            id = topicos.size.toLong() + 1,
            titulo = topicoDto.titulo,
            mensagem = topicoDto.mensagem,
            curso = cursoService.searchById(topicoDto.idCurso),
            autor = autorService.searchById(topicoDto.idAutor)
        )
        this.topicos = this.topicos.plus(topico)
        return topico
    }

}