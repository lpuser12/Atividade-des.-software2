import java.io.*;

public class AdicionarAoArquivoTexto {
    public static void main(String[] args) {
        String nomeArquivo = "meuarquivo.txt";

        try {
            FileWriter arquivoEscrita = new FileWriter(nomeArquivo, true);

            PrintWriter escrever = new PrintWriter(arquivoEscrita);

            escrever.println("Isso é uma adição!");

            escrever.close();
            arquivoEscrita.close();

            System.out.println("Adição feita com sucesso em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao adicionar ao arquivo: " + e.getMessage());
        }
    }
}
