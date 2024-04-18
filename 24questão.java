import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            CSVReader csvReader = new CSVReader(new FileReader("funcionarios.csv"));
            String[] header = csvReader.readNext();

            List<String[]> funcionarios = new ArrayList<>();
            String[] linha;
            while ((linha = csvReader.readNext()) != null) {
                funcionarios.add(linha);
            }
            csvReader.close();

            System.out.println("Opções de filtro:");
            System.out.println("1. Filtrar por cargo");
            System.out.println("2. Filtrar por salário mínimo");
            System.out.println("Digite a opção desejada:");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o cargo para filtrar:");
                    String cargoFiltrado = scanner.nextLine();
                    filtrarPorCargo(funcionarios, cargoFiltrado);
                    break;
                case 2:
                    System.out.println("Digite o salário mínimo para filtrar:");
                    double salarioMinimo = scanner.nextDouble();
                    filtrarPorSalarioMinimo(funcionarios, salarioMinimo);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void filtrarPorCargo(List<String[]> funcionarios, String cargoFiltrado) {
        System.out.println("Funcionários com cargo '" + cargoFiltrado + "':");
        for (String[] funcionario : funcionarios) {
            if (funcionario[1].equalsIgnoreCase(cargoFiltrado)) {
                exibirFuncionario(funcionario);
            }
        }
    }

    public static void filtrarPorSalarioMinimo(List<String[]> funcionarios, double salarioMinimo) {
        System.out.println("Funcionários com salário maior ou igual a " + salarioMinimo + ":");
        for (String[] funcionario : funcionarios) {
            double salario = Double.parseDouble(funcionario[2]);
            if (salario >= salarioMinimo) {
                exibirFuncionario(funcionario);
            }
        }
    }

    public static void exibirFuncionario(String[] funcionario) {
        System.out.println("Nome: " + funcionario[0]);
        System.out.println("Cargo: " + funcionario[1]);
        System.out.println("Salário: " + funcionario[2]);
        System.out.println();
    }
}
