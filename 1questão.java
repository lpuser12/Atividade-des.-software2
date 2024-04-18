import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CriarArquivoTexto {
    public static void main(String[] args) {
     
        String nomeArquivo = "meuarquivo.txt";

        try {
         
            FileWriter arquivoEscrita = new FileWriter(nomeArquivo);

        
            PrintWriter escrever = new PrintWriter(arquivoEscrita);

       
            escrever.println("Olá, mundo!");

      
            escrever.close();
            arquivoEscrita.close();

            System.out.println("Arquivo criado com sucesso: " + nomeArquivo);
        } catch (IOException e) {
        
            System.out.println("Erro ao criar o arquivo: " + e.getMessage());
        }
    }
}
