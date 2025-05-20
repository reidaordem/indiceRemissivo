import java.util.NoSuchElementException;

public class ListaSimplesmenteEncadeada {
    private static class Nodo { // Classe privada
        private int elemento;
        private Nodo proximo;

        public Nodo(int elemento) {
            this.elemento = elemento;
        }
    }

    private Nodo primeiro;
    private Nodo ultimo;
    private int n_elementos;

    // Insere um inteiro (linha) no final
    public void insereFinal(int elemento) {
        Nodo novo = new Nodo(elemento);
        if (ultimo == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            ultimo = novo;
        }
        n_elementos++;
    }

    // Iterador seguro para acessar elementos sem expor o Nodo
    public Iterador getIterador() {
        return new Iterador(primeiro);
    }

    // Classe interna para iterar
    public class Iterador {
        private Nodo atual;

        public Iterador(Nodo inicio) {
            this.atual = inicio;
        }

        public boolean temProximo() {
            return atual != null;
        }

        public int proximo() {
            if (!temProximo()) throw new NoSuchElementException();
            int elemento = atual.elemento;
            atual = atual.proximo;
            return elemento;
        }
    }
}