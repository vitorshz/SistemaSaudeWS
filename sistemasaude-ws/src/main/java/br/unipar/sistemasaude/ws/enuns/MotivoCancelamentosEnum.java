package br.unipar.sistemasaude.ws.enuns;

public enum MotivoCancelamentosEnum {
    D("PACIENTE_DESISTIU"),
    C("MEDICO_CANCELADO"),
    O("OUTROS"),
    A("ESTAATIVO");
    String codigo;
    private MotivoCancelamentosEnum(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public static MotivoCancelamentosEnum getEnumByCodigo(String codigo) {
        MotivoCancelamentosEnum retorno = null;

        for (MotivoCancelamentosEnum especialidade : MotivoCancelamentosEnum.values()) {
            if (especialidade.getCodigo().equalsIgnoreCase(codigo)) {
                retorno = especialidade;
            }
        }

        return retorno;
    }
}