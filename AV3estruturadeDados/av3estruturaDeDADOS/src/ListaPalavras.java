import java.util.NoSuchElementException;

public class ListaPalavras {
    private static class Nodo { // Classe privada
        private Palavra elemento;
        private Nodo proximo;

        public Nodo(Palavra elemento) {
            this.elemento = elemento;
        }
    }

    private Nodo primeiro;
    private Nodo ultimo;

    // Insere uma Palavra no final
    public void insereFinal(Palavra elemento) {
        Nodo novo = new Nodo(elemento);
        if (ultimo == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            ultimo = novo;
        }
    }

    // Iterador seguro
    public Iterador getIterador() {
        return new Iterador(primeiro);
    }

    public class Iterador {
        private Nodo atual;

        public Iterador(Nodo inicio) {
            this.atual = inicio;
        }

        public boolean temProximo() {
            return atual != null;
        }

        public Palavra proximo() {
            if (!temProximo()) throw new NoSuchElementException();
            Palavra elemento = atual.elemento;
            atual = atual.proximo;
            return elemento;
        }
    }
}