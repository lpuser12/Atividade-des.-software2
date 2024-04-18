import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
 
            CSVReader csvReader = new CSVReader(new FileReader("produtos.csv"));
            String[] header = csvReader.readNext();

            FileWriter fileWriter = new FileWriter("produtos.csv", true);

            CSVWriter csvWriter = new CSVWriter(fileWriter);

            System.out.println("Digite o nome do produto que deseja excluir:");
            String produtoPesquisado = scanner.nextLine();

            String[] produtoExcluido = null;

            String[] linha;
            while ((linha = csvReader.readNext()) != null) {
                if (linha[0].equalsIgnoreCase(produtoPesquisado)) {
                    produtoExcluido = linha;
                    break;
                }
            }

            if (produtoExcluido != null) {
 
                csvReader.close();
                FileWriter fileWriter2 = new FileWriter("produtos.csv");
                CSVWriter csvWriter2 = new CSVWriter(fileWriter2);
                csvWriter2.writeNext(header); 
                String[] proximaLinha;
                while ((proximaLinha = csvReader.readNext()) != null) {
                    if (!proximaLinha[0].equalsIgnoreCase(produtoPesquisado)) {
                        csvWriter2.writeNext(proximaLinha);
                    }
                }
                csvReader.close();
                csvWriter2.close();

                System.out.println("Produto excluído com sucesso!");
            } else {
                System.out.println("Produto não encontrado.");
            }

            csvWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler/escrever no arquivo CSV: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
