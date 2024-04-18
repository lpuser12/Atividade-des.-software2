import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerArquivoCSV {
    public static void main(String[] args) {
        String nomeArquivo = "dados.csv";

        try {
            Scanner scanner = new Scanner(new File(nomeArquivo));

            scanner.useDelimiter(",");

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] campos = linha.split(",");
                for (String campo : campos) {
                    System.out.print(campo + " | ");
                }
                System.out.println(); 
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}
