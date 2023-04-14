package br.com.eguadorodrigo.adopet.model.request;

import br.com.eguadorodrigo.adopet.model.enums.PorteEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class PetRequest {

    private Long id;

    @NotEmpty(message = "Campo nome é obrigatório")
    private String nome;

    @NotEmpty(message = "Necessária breve descrição")
    private String descricao;

    private Boolean adotado;

    @NotNull(message = "Campo idade é obrigatório")
    private Integer idade;

    @NotNull(message = "Campo cidade é obrigatório")
    private Long cidadeId;

    private PorteEnum porte;

    private String imagem;

    @NotNull(message = "Campo abrigo é obrigatório")
    private Long abrigoId;

    @NotNull(message = "Campo tutor é obrigatório")
    private Long tutorId;

    public PetRequest(Long id, String nome, String descricao, Boolean adotado, Integer idade, Long cidadeId, PorteEnum porte, String imagem, Long abrigoId, Long tutorId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.adotado = adotado;
        this.idade = idade;
        this.cidadeId = cidadeId;
        this.porte = porte;
        this.imagem = imagem;
        this.abrigoId = abrigoId;
        this.tutorId = tutorId;
    }

    public PetRequest() {
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

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
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

    public Long getAbrigoId() {
        return abrigoId;
    }

    public void setAbrigoId(Long abrigoId) {
        this.abrigoId = abrigoId;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }
}
