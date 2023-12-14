import javax.persistence.*;
import java.util.List;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String modelo;
    private int anoFabricacao;

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL)
    private List<Localizacao> localizacoes;

    // Construtores, getters e setters
}
