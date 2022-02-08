package br.com.alura.forum.controller

import br.com.alura.forum.dto.NewTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.dto.UpdateTopicoForm
import br.com.alura.forum.model.Topico
import br.com.alura.forum.service.TopicoService
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(
    private val topicoService: TopicoService
) {

    @GetMapping
    fun index(): List<TopicoView> {
        return topicoService.criarTopicos()
    }

    @GetMapping("/{id}")
    fun show(@PathVariable id: Long): TopicoView? {
        return topicoService.showTopico(id)
    }

    @PostMapping
    fun create(
        @RequestBody @Valid form: NewTopicoForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<Topico> {
        val result = this.topicoService.createTopico(form)
        val uri = uriBuilder.path("/topicos/${result.id}").build().toUri()
        return ResponseEntity.created(uri).body(result)

    }

    @PutMapping
    fun update(@RequestBody @Valid form: UpdateTopicoForm): TopicoView {
        return this.topicoService.updateTopico(form)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long): Boolean {
        return this.topicoService.deleteTopico(id)
    }
}