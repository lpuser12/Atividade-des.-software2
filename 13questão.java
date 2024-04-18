import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Produto implements Serializable {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: " + preco);
    }
}

public class SerializarDeserializarProdutos {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Produto A", 10.99));
        produtos.add(new Produto("Produto B", 20.50));
        produtos.add(new Produto("Produto C", 15.75));

        String nomeArquivo = "produtos.dat";

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
            outputStream.writeObject(produtos);
            outputStream.close();

            System.out.println("Lista de produtos serializada e salva em " + nomeArquivo);

            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo));
            List<Produto> produtosDeserializados = (List<Produto>) inputStream.readObject();
            inputStream.close();

            System.out.println("Produtos deserializados:");
            for (Produto produto : produtosDeserializados) {
                produto.exibirDetalhes();
                System.out.println();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao serializar/deserializar a lista de produtos: " + e.getMessage());
        }
    }
}
