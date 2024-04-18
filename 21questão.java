import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
      
            FileWriter fileWriter = new FileWriter("produtos.csv", true); 

      
            CSVWriter csvWriter = new CSVWriter(fileWriter);

        
            System.out.println("Digite o nome do produto:");
            String nome = scanner.nextLine();

            System.out.println("Digite o preço do produto:");
            double preco = scanner.nextDouble();

            System.out.println("Digite a quantidade do produto:");
            int quantidade = scanner.nextInt();

      
            String[] produto = {nome, String.valueOf(preco), String.valueOf(quantidade)};

     
            csvWriter.writeNext(produto);


            csvWriter.close();
            fileWriter.close();

            System.out.println("Produto adicionado ao arquivo 'produtos.csv' com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
