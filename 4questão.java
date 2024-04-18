import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContarLinhasArquivo {
    public static void main(String[] args) {
        String nomeArquivo = "meuarquivo.txt";

        try {
            FileReader arquivoLeitura = new FileReader(nomeArquivo);

            BufferedReader leitor = new BufferedReader(arquivoLeitura);

            int contadorLinhas = 0;

            while (leitor.readLine() != null) {
                contadorLinhas++;
            }

            leitor.close();
            arquivoLeitura.close();

            System.out.println("O arquivo \"" + nomeArquivo + "\" possui " + contadorLinhas + " linhas.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
