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
}

public class SerializarPessoa {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("João", 30);

        String nomeArquivo = "pessoa.dat";

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo));

            outputStream.writeObject(pessoa);

            outputStream.close();

            System.out.println("Objeto Pessoa serializado e salvo em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao serializar o objeto: " + e.getMessage());
        }
    }
}
