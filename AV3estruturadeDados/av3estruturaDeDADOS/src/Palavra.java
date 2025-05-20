public class Palavra implements Comparable<Palavra> {
    private String palavra;
    private ListaSimplesmenteEncadeada ocorrencias;

    public Palavra(String palavra, int linha) {
        this.palavra = palavra.toLowerCase();
        this.ocorrencias = new ListaSimplesmenteEncadeada();
        this.ocorrencias.insereFinal(linha);
    }

    public void adicionarOcorrencia(int linha) {
        ocorrencias.insereFinal(linha);
    }

    public String getPalavra() {
        return palavra;
    }

    public ListaSimplesmenteEncadeada getOcorrencias() {
        return ocorrencias;
    }

    @Override
    public int compareTo(Palavra outra) {
        return this.palavra.compareTo(outra.palavra);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Palavra) {
            return this.palavra.equals(((Palavra) obj).palavra);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return palavra.hashCode();
    }
}