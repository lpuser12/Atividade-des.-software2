import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Venda {
    private String data;
    private double valor;
    private String produto;

    public Venda(String data, double valor, String produto) {
        this.data = data;
        this.valor = valor;
        this.produto = produto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Venda> vendas = new ArrayList<>();
        vendas.add(new Venda("2024-04-23", 150.00, "Produto A"));
        vendas.add(new Venda("2024-04-24", 200.00, "Produto B"));
        vendas.add(new Venda("2024-04-25", 100.00, "Produto C"));

        exportarParaCSV(vendas);
    }

    public static void exportarParaCSV(List<Venda> vendas) {

        String nomeArquivo = "vendas.csv";

        try {

            FileWriter fileWriter = new FileWriter(nomeArquivo);
r
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            String[] cabecalho = {"Data", "Valor", "Produto"};
            csvWriter.writeNext(cabecalho);

            for (Venda venda : vendas) {
                String[] linha = {venda.getData(), String.valueOf(venda.getValor()), venda.getProduto()};
                csvWriter.writeNext(linha);
            }

            csvWriter.close();
            fileWriter.close();

            System.out.println("Vendas exportadas para o arquivo '" + nomeArquivo + "' com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao exportar vendas para o arquivo CSV: " + e.getMessage());
        }
    }
}
