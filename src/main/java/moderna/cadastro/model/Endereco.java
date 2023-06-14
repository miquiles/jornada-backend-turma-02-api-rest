package moderna.cadastro.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "db_endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String logradouro;
    private String bairro;
    private String numero;
    private String cep;
    private String uf;
    private String cidade;
    private String complemento;
}
