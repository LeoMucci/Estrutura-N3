package n3;

class No<T> {
    private T dado;
    private No<T> esquerda;
    private No<T> direita;

    public No(T dado) {
        this.dado = dado;
        this.esquerda = null;
        this.direita = null;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public No<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No<T> esquerda) {
        this.esquerda = esquerda;
    }

    public No<T> getDireita() {
        return direita;
    }

    public void setDireita(No<T> direita) {
        this.direita = direita;
    }
}
