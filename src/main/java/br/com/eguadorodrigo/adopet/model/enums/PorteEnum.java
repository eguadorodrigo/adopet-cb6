package br.com.eguadorodrigo.adopet.model.enums;

public enum PorteEnum {
    PEQUENO(1),
    MEDIO(2),
    GRANDE(3);

    private Integer codigo;

    PorteEnum(int codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }
}
