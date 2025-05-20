public class TabelaHash {
    private ArvoreBinariaBusca[] tabela;
    private static final int TAMANHO = 26;

    public TabelaHash() {
        tabela = new ArvoreBinariaBusca[TAMANHO];
        for (int i = 0; i < TAMANHO; i++) {
            tabela[i] = new ArvoreBinariaBusca();
        }
    }

    private int hash(char letra) {
        return Character.toLowerCase(letra) - 'a';
    }

    public void inserir(Palavra palavra) {
        int indice = hash(palavra.getPalavra().charAt(0));
        tabela[indice].inserir(palavra);
    }

    public Palavra buscar(String palavra) {
        if (palavra.isEmpty()) return null;
        int indice = hash(palavra.charAt(0));
        return tabela[indice].buscar(palavra);
    }

    // Gera o índice remissivo ordenado
    public void gerarIndice(ArvoreBinariaBusca palavrasChave) {
        ListaPalavras todasPalavras = new ListaPalavras();
        for (int i = 0; i < TAMANHO; i++) {
            tabela[i].emOrdem(todasPalavras); // Coleta palavras em ordem
        }

        ListaPalavras.Iterador iterador = todasPalavras.getIterador();
        while (iterador.temProximo()) {
            Palavra p = iterador.proximo();
            if (palavrasChave.buscar(p.getPalavra()) != null) { // Verifica se é palavra-chave
                System.out.print(p.getPalavra() + " ");
                ListaSimplesmenteEncadeada ocorrencias = p.getOcorrencias();
                ListaSimplesmenteEncadeada.Iterador linhaIterador = ocorrencias.getIterador();
                while (linhaIterador.temProximo()) {
                    System.out.print(linhaIterador.proximo() + " ");
                }
                System.out.println();
            }
        }
    }
}