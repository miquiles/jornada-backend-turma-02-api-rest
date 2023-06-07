package moderna.cadastro.service;

import moderna.cadastro.model.Pessoa;
import moderna.cadastro.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvarPessoa(Pessoa pessoa){
        var pessoaSalva = buscarPessoaPorDocumento(pessoa.getDocumento());

        if(pessoaSalva.isEmpty()){
            return pessoaRepository.save(pessoa);
        }else{
            System.out.println("cliente existente. Nao pode salvar");
        }
        return new Pessoa();
    }

    public void deletarPorId(Long id){
        var pessoaSalva = pessoaRepository.findById(id);

        if(pessoaSalva.isPresent()){
            pessoaRepository.deleteById(id);
        }else{
            System.out.println("cliente nao existe");
        }
    }

    private Optional<Pessoa> buscarPessoaPorDocumento(String documento){
        return pessoaRepository.findByDocumento(documento);
    }
}
