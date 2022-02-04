package br.com.alura.forum.service

import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class AutorService(
    var autores: MutableList<Usuario>
) {

    init {
        this.autores.add(
            Usuario(
                id = 1,
                nome = "USUARIO 1",
                email = "bruno@teste.com"
            )
        )
    }

    fun searchById(id: Long): Usuario {
        return this.autores.find { it.id == id }!!
    }


}
