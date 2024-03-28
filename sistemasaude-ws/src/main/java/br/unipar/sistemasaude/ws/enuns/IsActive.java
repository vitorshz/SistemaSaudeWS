package br.unipar.sistemasaude.ws.enuns;

public enum IsActive {
    ATIVO(1),
    INATIVO(2);

    private final int valor;

    IsActive(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static IsActive fromValor(int valor) {
        for (IsActive estado : IsActive.values()) {
            if (estado.getValor() == valor) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Valor inválido para IsActive: " + valor);
    }
}
