package moderna.cadastro.controller;

import moderna.cadastro.model.Pessoa;
import moderna.cadastro.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired //spring gerenciar nossas instancias de repositório.
    private PessoaRepository pessoaRepository;


    @GetMapping("/texto1")
    public String mostrarTexto(){
        return "sejam bem-vindos a minha primeira API Rest";
    }

    @PostMapping("/salvar")
    public void salvar(@RequestBody Pessoa pessoa){
        pessoaRepository.save(pessoa);
    }




}
