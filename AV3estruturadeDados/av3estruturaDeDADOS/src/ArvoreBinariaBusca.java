public class ArvoreBinariaBusca {
    private static class Nodo { // Classe privada
        private Palavra elemento;
        private Nodo esquerdo;
        private Nodo direito;

        public Nodo(Palavra elemento) {
            this.elemento = elemento;
        }
    }

    private Nodo raiz;

    // Insere uma Palavra na ABB
    public void inserir(Palavra palavra) {
        raiz = inserir(raiz, palavra);
    }

    private Nodo inserir(Nodo nodo, Palavra palavra) {
        if (nodo == null) return new Nodo(palavra);
        int cmp = palavra.compareTo(nodo.elemento);
        if (cmp < 0) nodo.esquerdo = inserir(nodo.esquerdo, palavra);
        else if (cmp > 0) nodo.direito = inserir(nodo.direito, palavra);
        return nodo;
    }

    // Busca uma Palavra
    public Palavra buscar(String palavra) {
        return buscar(raiz, palavra.toLowerCase());
    }

    private Palavra buscar(Nodo nodo, String palavra) {
        if (nodo == null) return null;
        int cmp = palavra.compareTo(nodo.elemento.getPalavra());
        if (cmp < 0) return buscar(nodo.esquerdo, palavra);
        else if (cmp > 0) return buscar(nodo.direito, palavra);
        else return nodo.elemento;
    }

    // Coleta palavras em ordem usando ListaPalavras
    public void emOrdem(ListaPalavras lista) {
        emOrdem(raiz, lista);
    }

    private void emOrdem(Nodo nodo, ListaPalavras lista) {
        if (nodo == null) return;
        emOrdem(nodo.esquerdo, lista);
        lista.insereFinal(nodo.elemento);
        emOrdem(nodo.direito, lista);
    }
}