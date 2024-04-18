import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContarPalavraJava {
    public static void main(String[] args) {
        String nomeArquivo = "meuarquivo.txt";

        String palavraAlvo = "Java";

        int contador = 0;

        try {
            FileReader arquivoLeitura = new FileReader(nomeArquivo);

            BufferedReader leitor = new BufferedReader(arquivoLeitura);

            String linha;

            while ((linha = leitor.readLine()) != null) {
                String[] palavras = linha.split(" ");
                for (String palavra : palavras) {
                    if (palavra.equals(palavraAlvo)) {
                        contador++;
                    }
                }
            }

            leitor.close();
            arquivoLeitura.close();

            System.out.println("A palavra 'Java' aparece " + contador + " vezes no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
