import java.io.*;

public class ConcatenarArquivos {
    public static void main(String[] args) {
        String conteudoArquivo1 = "Conteúdo do arquivo 1.";
        String conteudoArquivo2 = "Conteúdo do arquivo 2.";

        String nomeArquivo1 = "arquivo1.txt";
        String nomeArquivo2 = "arquivo2.txt";
        String nomeArquivoConcatenado = "arquivo_concatenado.txt";

        try {
            FileWriter arquivo1Escrita = new FileWriter(nomeArquivo1);
            arquivo1Escrita.write(conteudoArquivo1);
            arquivo1Escrita.close();
        
            FileWriter arquivo2Escrita = new FileWriter(nomeArquivo2);
            arquivo2Escrita.write(conteudoArquivo2);
            arquivo2Escrita.close();

            FileWriter arquivoConcatenadoEscrita = new FileWriter(nomeArquivoConcatenado);

            FileReader arquivo1Leitura = new FileReader(nomeArquivo1);
            BufferedReader leitor1 = new BufferedReader(arquivo1Leitura);
            String linha;
            while ((linha = leitor1.readLine()) != null) {
                arquivoConcatenadoEscrita.write(linha);
                arquivoConcatenadoEscrita.write("\n");
            }
            leitor1.close();

            FileReader arquivo2Leitura = new FileReader(nomeArquivo2);
            BufferedReader leitor2 = new BufferedReader(arquivo2Leitura);
            while ((linha = leitor2.readLine()) != null) {
                arquivoConcatenadoEscrita.write(linha);
                arquivoConcatenadoEscrita.write("\n"); 
            }
            leitor2.close();

            arquivoConcatenadoEscrita.close();

            System.out.println("Arquivos concatenados e salvos em " + nomeArquivoConcatenado);
        } catch (IOException e) {
            System.out.println("Erro ao criar ou escrever nos arquivos: " + e.getMessage());
        }
    }
}
