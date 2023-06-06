package moderna.cadastro.model;
import jakarta.persistence.*;

@Entity
@Table(name = "db-pessoa")
public class Pessoa {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // auto increment
    private Long id;

    //SQL varchar nome 55 not null

    private String nome;
    private String documento;
    private String email;
    private String dataNascimento;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
