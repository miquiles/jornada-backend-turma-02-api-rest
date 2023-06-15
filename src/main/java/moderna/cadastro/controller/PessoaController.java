package moderna.cadastro.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import moderna.cadastro.model.Pessoa;
import moderna.cadastro.repository.PessoaRepository;
import moderna.cadastro.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/pessoas")
@AllArgsConstructor
public class PessoaController {

    private PessoaRepository pessoaRepository;
    private PessoaService pessoaService;

    @PostMapping("/salvar")
    public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa){
        try{
            log.info("salvando uma pessoa", pessoa.getNome());
            return new ResponseEntity<>(pessoaService.salvarPessoa(pessoa), HttpStatus.CREATED);

        }catch(Exception exception){
            exception.printStackTrace();
            log.info("deu um erro ao salvar uma pessoa");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("listar-todos")
    public List<Pessoa> listarTodos(){
        return pessoaRepository.findAll();
    }

    @GetMapping("buscar/{id}")
    public ResponseEntity<Optional<Pessoa>> buscarPorId(@PathVariable Long id){
       try {
           return new ResponseEntity<>(pessoaService.buscarPorId(id), HttpStatus.OK);
       }catch(Exception exception){
           exception.printStackTrace();
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }

    }

    @DeleteMapping("deletar-todos")
    public void deletarTodos(){
        pessoaRepository.deleteAll();
    }

    @DeleteMapping("deletar/{id}")
    public void deletarPorId(@PathVariable Long id) throws Exception {
        pessoaService.deletarPorId(id);
    }

}
