import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Funcionario implements Serializable {
    private String nome;
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + cargo);
        System.out.println("Salário: " + salario);
    }
}

class GerenciadorFuncionarios {
    private List<Funcionario> funcionarios;
    private String nomeArquivo;

    public GerenciadorFuncionarios(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        this.funcionarios = new ArrayList<>();
    }

    public void carregarFuncionarios() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo));
            funcionarios = (List<Funcionario>) inputStream.readObject();
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar funcionários: " + e.getMessage());
        }
    }

    public void salvarFuncionarios() {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
            outputStream.writeObject(funcionarios);
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar funcionários: " + e.getMessage());
        }
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void atualizarFuncionario(String nome, Funcionario novoFuncionario) {
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario funcionario = funcionarios.get(i);
            if (funcionario.getNome().equals(nome)) {
                funcionarios.set(i, novoFuncionario);
                break;
            }
        }
    }

    public void removerFuncionario(String nome) {
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals(nome));
    }

    public void exibirFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            funcionario.exibirDetalhes();
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {

        GerenciadorFuncionarios gerenciador = new GerenciadorFuncionarios("funcionarios.bin");
        gerenciador.carregarFuncionarios();

        gerenciador.adicionarFuncionario(new Funcionario("João", "Analista", 3000));
        gerenciador.adicionarFuncionario(new Funcionario("Maria", "Gerente", 5000));

        System.out.println("Funcionários antes das operações:");
        gerenciador.exibirFuncionarios();
        System.out.println();

        gerenciador.atualizarFuncionario("João", new Funcionario("João", "Analista", 3500));

        gerenciador.removerFuncionario("Maria");

        System.out.println("Funcionários após as operações:");
        gerenciador.exibirFuncionarios();

        gerenciador.salvarFuncionarios();
    }
}
