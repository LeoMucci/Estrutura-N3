package n3;

import javax.swing.DefaultListModel;

class ArvoreBinaria<T extends Comparable<T>> {
    private No<T> raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public void inserir(T dado) {
        raiz = inserirRec(raiz, dado);
    }

    private No<T> inserirRec(No<T> raiz, T dado) {
        if (raiz == null) {
            raiz = new No<>(dado);
            return raiz;
        }

        if (dado.compareTo(raiz.getDado()) < 0)
            raiz.setEsquerda(inserirRec(raiz.getEsquerda(), dado));
        else if (dado.compareTo(raiz.getDado()) > 0)
            raiz.setDireita(inserirRec(raiz.getDireita(), dado));

        return raiz;
    }

    public void listarEmOrdem(DefaultListModel<T> modelo) {
        listarEmOrdem(raiz, modelo);
    }

    private void listarEmOrdem(No<T> raiz, DefaultListModel<T> modelo) {
        if (raiz != null) {
            listarEmOrdem(raiz.getEsquerda(), modelo);
            modelo.addElement(raiz.getDado());
            listarEmOrdem(raiz.getDireita(), modelo);
        }
    }

    public No<T> getRaiz() {
        return raiz;
    }

    public void listarPreOrdem(DefaultListModel<T> modelo) {
        listarPreOrdem(raiz, modelo);
    }

    private void listarPreOrdem(No<T> raiz, DefaultListModel<T> modelo) {
        if (raiz != null) {
            modelo.addElement(raiz.getDado());
            listarPreOrdem(raiz.getEsquerda(), modelo);
            listarPreOrdem(raiz.getDireita(), modelo);
        }
    }

    public void listarPosOrdem(DefaultListModel<T> modelo) {
        listarPosOrdem(raiz, modelo);
    }

    private void listarPosOrdem(No<T> raiz, DefaultListModel<T> modelo) {
        if (raiz != null) {
            listarPosOrdem(raiz.getEsquerda(), modelo);
            listarPosOrdem(raiz.getDireita(), modelo);
            modelo.addElement(raiz.getDado());
        }
    }

    public boolean buscar(T dado) {
        return buscarRec(raiz, dado);
    }

    private boolean buscarRec(No<T> raiz, T dado) {
        if (raiz == null) {
            return false;
        }

        int comp = dado.compareTo(raiz.getDado());
        if (comp == 0) {
            return true;
        } else if (comp < 0) {
            return buscarRec(raiz.getEsquerda(), dado);
        } else {
            return buscarRec(raiz.getDireita(), dado);
        }
    }
}
