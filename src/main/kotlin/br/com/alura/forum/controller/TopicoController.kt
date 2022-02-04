package br.com.alura.forum.controller

import br.com.alura.forum.dto.NewTopicoDto
import br.com.alura.forum.model.Topico
import br.com.alura.forum.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicoController(
    private val topicoService: TopicoService
) {

    @GetMapping
    fun index(): List<Topico> {
        return topicoService.criarTopicos()
    }

    @GetMapping("/{id}")
    fun show(@PathVariable id: Long): Topico? {

        return topicoService.showTopico(id)
    }

    @PostMapping
    fun create(@RequestBody topicoDto: NewTopicoDto): Topico {
        return this.topicoService.createTopico(topicoDto)

    }


}