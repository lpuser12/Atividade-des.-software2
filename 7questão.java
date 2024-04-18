import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class OrdenarLinhas {
    public static void main(String[] args) {
        String arquivoEntrada = "meuarquivo.txt";
        String arquivoSaida = "meuarquivo_ordenado.txt";

        try {
            FileReader arquivoLeitura = new FileReader(arquivoEntrada);
            FileWriter arquivoEscrita = new FileWriter(arquivoSaida);

            BufferedReader leitor = new BufferedReader(arquivoLeitura);
            BufferedWriter escritor = new BufferedWriter(arquivoEscrita);

            ArrayList<String> linhas = new ArrayList<>();

            String linha;

            while ((linha = leitor.readLine()) != null) {
                linhas.add(linha);
            }

            Collections.sort(linhas);

            for (String linhaOrdenada : linhas) {
                escritor.write(linhaOrdenada);
                escritor.newLine(); 
            }

            leitor.close();
            escritor.close();
            arquivoLeitura.close();
            arquivoEscrita.close();

            System.out.println("Linhas ordenadas e salvas em " + arquivoSaida);
        } catch (IOException e) {

            System.out.println("Erro ao ler/escrever o arquivo: " + e.getMessage());
        }
    }
}
