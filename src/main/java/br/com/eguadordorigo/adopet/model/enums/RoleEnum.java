package br.com.eguadordorigo.adopet.model.enums;

public enum RoleEnum {
    USER(1),
    ADMIN(2);
    private Integer code;
    RoleEnum(int code) {
        this.code = code;
    }
}
