package moderna.cadastro.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "db-contato")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 40, nullable = false)
    private String email;
    private String ddd;
    private String numero;
    private String descricao;
}
