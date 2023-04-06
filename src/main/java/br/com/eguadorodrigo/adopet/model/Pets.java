package br.com.eguadorodrigo.adopet.model;

import br.com.eguadorodrigo.adopet.model.enums.CidadeEnum;
import br.com.eguadorodrigo.adopet.model.enums.PorteEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;

@Entity(name = "Pets")
@Table(name = "tb_pets", schema = "CB6")
public class Pets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", table = "tb_pets")
    private Long id;
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "descricao", length = 150, nullable = false)
    private String descricao;

    @Column(name = "adotado")
    private Boolean adotado;

    @Column(name = "idade", length = 3)
    private Integer idade;

    @Enumerated(EnumType.STRING)
    private CidadeEnum cidade;

    @Enumerated(EnumType.STRING)
    private PorteEnum porte;

    @Column(name = "imagem", length = 200, nullable = true)
    private String imagem;

    @ManyToOne
    private Abrigo abrigo;

    public Pets() {
    }

    public Pets(Long id, String nome, String descricao, Boolean adotado, Integer idade, CidadeEnum cidade, PorteEnum porte, String imagem) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.adotado = adotado;
        this.idade = idade;
        this.cidade = cidade;
        this.porte = porte;
        this.imagem = imagem;
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAdotado() {
        return adotado;
    }

    public void setAdotado(Boolean adotado) {
        this.adotado = adotado;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public CidadeEnum getCidade() {
        return cidade;
    }

    public void setCidade(CidadeEnum cidade) {
        this.cidade = cidade;
    }

    public PorteEnum getPorte() {
        return porte;
    }

    public void setPorte(PorteEnum porte) {
        this.porte = porte;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
