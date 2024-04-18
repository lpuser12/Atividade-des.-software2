import java.io.*;

public class SubstituirPalavra {
    public static void main(String[] args) {
        String arquivoEntrada = "meuarquivo.txt";
        String arquivoSaida = "meuarquivo_python.txt";

        try {
            FileReader arquivoLeitura = new FileReader(arquivoEntrada);
            FileWriter arquivoEscrita = new FileWriter(arquivoSaida);

            BufferedReader leitor = new BufferedReader(arquivoLeitura);
            BufferedWriter escritor = new BufferedWriter(arquivoEscrita);

            String linha;

            while ((linha = leitor.readLine()) != null) {
                linha = linha.replaceAll("Java", "Python");
                escritor.write(linha);
                escritor.newLine(); 
            }

            leitor.close();
            escritor.close();
            arquivoLeitura.close();
            arquivoEscrita.close();

            System.out.println("Substituição concluída. Arquivo salvo como " + arquivoSaida);
        } catch (IOException e) {
            System.out.println("Erro ao ler/escrever o arquivo: " + e.getMessage());
        }
    }
}
