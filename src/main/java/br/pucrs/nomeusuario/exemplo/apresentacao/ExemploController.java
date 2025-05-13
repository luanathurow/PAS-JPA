package br.pucrs.nomeusuario.exemplo.apresentacao;

import br.pucrs.nomeusuario.exemplo.persistencia.*;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/biblioteca")
public class ExemploController {
    private IEditoraRepository acervo;

    @Autowired
    public ExemploController(IEditoraRepository acervo) {
        this.acervo = acervo;        
    }

    @GetMapping("")
    public String getMensagemInicial() {
        return "Aplicacao Spring-Boot funcionando!";
    }

    @GetMapping("/editora")
    public List<Editora> getLivros() {
        return acervo.getEditoras();
    }

    @GetMapping("/editoraId/{id}")
    public Editora getLivroTitulo(@PathVariable("id") long id) {
        return acervo.getEditoraId(id);
    }

}