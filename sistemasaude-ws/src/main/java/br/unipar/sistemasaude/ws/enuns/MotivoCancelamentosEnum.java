package br.unipar.sistemasaude.ws.enuns;

public enum MotivoCancelamentosEnum {
    PACIENTE_DESISTIU,
    MEDICO_CANCELADO,
    OUTROS;

    // Exemplo de uso para obter uma descrição do motivo
    public String getDescricao() {
        switch (this) {
            case PACIENTE_DESISTIU:
                return "Paciente desistiu";
            case MEDICO_CANCELADO:
                return "Médico cancelou";
            case OUTROS:
                return "Outros motivos";
            default:
                throw new IllegalArgumentException("Motivo de cancelamento não reconhecido");
        }
    }
}