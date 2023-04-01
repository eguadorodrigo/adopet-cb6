package br.com.eguadordorigo.adopet.model.dto;

import br.com.eguadordorigo.adopet.model.enums.RoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UsuarioDto {

    private Long id;

    @NotEmpty(message = "O campo de nome é obrigatório")
    private String nome;

    @NotEmpty(message = "O campo de sobrenome é obrigatório")
    private String sobrenome;

    @Email(message = "O campo email é obrigatório")
    private String email;

    @NotEmpty(message = "O campo de senha é obrigatório")
    private String senha;

    private RoleEnum role;

    public UsuarioDto(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public UsuarioDto() {

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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UsuarioDto{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
