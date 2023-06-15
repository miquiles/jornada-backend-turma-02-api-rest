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

    public Pessoa salvarPessoa(Pessoa pessoa) throws Exception {
        var pessoaSalva = buscarPessoaPorDocumento(pessoa.getDocumento());

        if(pessoaSalva.isEmpty()){
            return pessoaRepository.save(pessoa);
        }else{
            throw new Exception("cliente existente");
        }

    }

    public void deletarPorId(Long id) throws Exception {
        var pessoaSalva = pessoaRepository.findById(id);

        if(pessoaSalva.isPresent()){
            pessoaRepository.deleteById(id);
        }else{
            throw new Exception("cliente existente");
        }
    }

//    public Optional<Pessoa> buscarPorId(Long id) throws Exception {
//        var clienteSalvo = pessoaRepository.findById(id);
//        if(clienteSalvo.isEmpty()){
//            throw new Exception("cliente nao existe");
//        }else{
//           return clienteSalvo;
//        }
//    }

    public Optional<Pessoa> buscarPorId(Long id) throws Exception {
        return Optional.ofNullable(pessoaRepository.findById(id)
                .orElseThrow(() -> new Exception("cliente nao existe")));
    }



    private Optional<Pessoa> buscarPessoaPorDocumento(String documento){
        return pessoaRepository.findByDocumento(documento);
    }
}
