package moderna.cadastro.controller;

import moderna.cadastro.model.Pessoa;
import moderna.cadastro.repository.PessoaRepository;
import moderna.cadastro.service.PessoaService;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired //spring gerenciar nossas instancias de repositório.
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/texto1")
    public String mostrarTexto(){
        return "sejam bem-vindos a minha primeira API Rest";
    }

    @PostMapping("/salvar")
    public Pessoa salvar(@RequestBody Pessoa pessoa){
        return pessoaService.salvarPessoa(pessoa);
    }

    @GetMapping("listar-todos")
    public List<Pessoa> listarTodos(){
        return pessoaRepository.findAll();
    }

    @GetMapping("buscar/{id}")
    public Optional<Pessoa> buscarPorId(@PathVariable Long id){
        return pessoaRepository.findById(id);
    }

    @DeleteMapping("deletar-todos")
    public void deletarTodos(){
        pessoaRepository.deleteAll();
    }

    @DeleteMapping("deletar/{id}")
    public void deletarPorId(@PathVariable Long id){
        pessoaService.deletarPorId(id);
    }

}
