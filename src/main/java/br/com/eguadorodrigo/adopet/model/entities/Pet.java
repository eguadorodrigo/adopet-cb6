package br.com.eguadorodrigo.adopet.model.entities;

import br.com.eguadorodrigo.adopet.model.enums.PorteEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "PET")
@Table(name = "tb_pet", schema = "CB6")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "descricao", length = 150, nullable = false)
    private String descricao;

    @Column(name = "adotado")
    private Boolean adotado;

    @Column(name = "idade", length = 3)
    private Integer idade;

    @ManyToOne
    @JoinColumn(name = "cidade_id", foreignKey = @ForeignKey(name = "Fk_pet_cidade"))
    private Cidade cidade;

    @Enumerated(EnumType.STRING)
    private PorteEnum porte;

    @Column(name = "imagem", length = 200, nullable = true)
    private String imagem;

    @ManyToOne
    @JoinColumn(name = "abrigo_id",foreignKey = @ForeignKey(name = "Fk_pet_abrigo"))
    private Abrigo abrigo;

    @ManyToOne
    @JoinColumn(name = "adocao_id", foreignKey = @ForeignKey(name = "Fk_pet_adocao"))
    private Adocao adocao;

    @ManyToOne
    @JoinColumn(name = "tutor_id",foreignKey = @ForeignKey(name = "Fk_pet_tutor"))
    private Tutor tutor;

    public Pet() {
    }

    public Pet(Long id, String nome, String descricao, Boolean adotado, Integer idade, Cidade cidade, PorteEnum porte, String imagem, Tutor tutor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.adotado = adotado;
        this.idade = idade;
        this.cidade = cidade;
        this.porte = porte;
        this.imagem = imagem;
        this.tutor = tutor;
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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
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

    public Abrigo getAbrigo() {
        return abrigo;
    }

    public void setAbrigo(Abrigo abrigo) {
        this.abrigo = abrigo;
    }

    public Adocao getAdocao() {
        return adocao;
    }

    public void setAdocao(Adocao adocao) {
        this.adocao = adocao;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
