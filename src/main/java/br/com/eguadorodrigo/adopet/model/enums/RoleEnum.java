package br.com.eguadorodrigo.adopet.model.enums;

public enum RoleEnum {
    USER(1),
    ADMIN(2);
    private Integer code;
    RoleEnum(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
