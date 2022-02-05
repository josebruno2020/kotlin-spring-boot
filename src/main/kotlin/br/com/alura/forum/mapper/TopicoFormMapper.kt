package br.com.alura.forum.mapper

import br.com.alura.forum.dto.NewTopicoForm
import br.com.alura.forum.model.Topico
import br.com.alura.forum.service.AutorService
import br.com.alura.forum.service.CursoService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val autorService: AutorService,
): Mapper<NewTopicoForm, Topico> {
    override fun map(t: NewTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.searchById(t.idCurso),
            autor = autorService.searchById(t.idAutor)
        )
    }
}