package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import org.springframework.stereotype.Service

@Service
class CursoService(
    var cursos: MutableList<Curso>
) {

    init {
        val curso = Curso(
            id = 1,
            nome = "Custo Kotlin",
            categoria = "Programacao"
        )
        this.cursos.add(
            curso
        )
    }

    fun searchById(id: Long): Curso {
        return this.cursos.find { it.id == id }!!
    }

}
