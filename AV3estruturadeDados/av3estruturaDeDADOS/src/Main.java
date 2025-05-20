import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        TabelaHash tabela = new TabelaHash();
        ArvoreBinariaBusca palavrasChave = new ArvoreBinariaBusca();

        // Passo 1: Ler palavras-chave
        try (BufferedReader br = new BufferedReader(new FileReader("palavras_chave.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String palavra = linha.trim().toLowerCase();
                palavrasChave.inserir(new Palavra(palavra, 0));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Passo 2: Processar o texto
        try (BufferedReader br = new BufferedReader(new FileReader("texto.txt"))) {
            String linha;
            int numLinha = 1;
            while ((linha = br.readLine()) != null) {
                // Alteração na divisão das palavras
                String[] palavras = linha.split("[^a-zA-Z-]+"); 
                for (String p : palavras) {
                    p = p.replaceAll("[^a-zA-Z-]", "") // Remove caracteres inválidos
                         .toLowerCase()
                         .trim();
                    if (!p.isEmpty()) {
                        Palavra existente = tabela.buscar(p);
                        if (existente != null) {
                            existente.adicionarOcorrencia(numLinha);
                        } else {
                            tabela.inserir(new Palavra(p, numLinha));
                        }
                    }
                }
                numLinha++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Passo 3: Gerar índice
        tabela.gerarIndice(palavrasChave);
    }
}