package br.com.eguadorodrigo.adopet.model;

import br.com.eguadorodrigo.adopet.model.enums.CidadeEnum;
import br.com.eguadorodrigo.adopet.model.enums.PorteEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class PetsRequest {

    @NotEmpty(message = "Campo nome é obrigatório")
    private String nome;

    @NotEmpty(message = "Necessária breve descrição")
    private String descricao;

    private Boolean adotado;

    @NotNull(message = "Campo idade é obrigatório")
    private Integer idade;

    private CidadeEnum cidade;

    private PorteEnum porte;

    private String imagem;

    private AbrigoRequest abrigo;

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

    public AbrigoRequest getAbrigo() {
        return abrigo;
    }

    public void setAbrigo(AbrigoRequest abrigo) {
        this.abrigo = abrigo;
    }
}
