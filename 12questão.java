import java.io.*;

class Pessoa implements Serializable {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }
}

public class DeserializarPessoa {
    public static void main(String[] args) {
        String nomeArquivo = "pessoa.dat";

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo));

            Pessoa pessoa = (Pessoa) inputStream.readObject();

            inputStream.close();

            System.out.println("Detalhes da pessoa deserializada:");
            pessoa.exibirDetalhes();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao deserializar o objeto: " + e.getMessage());
        }
    }
}
