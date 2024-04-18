import java.io.*;

class ContaBancaria implements Serializable {
    private String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void exibirDetalhes() {
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: " + saldo);
    }
}

public class AtualizarContaBancaria {
    public static void main(String[] args) {
        String nomeArquivo = "conta.dat";

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo));
            ContaBancaria conta = (ContaBancaria) inputStream.readObject();
            inputStream.close();

            conta.setSaldo(conta.getSaldo() + 100);

            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
            outputStream.writeObject(conta);
            outputStream.close();

            System.out.println("Conta bancária atualizada e salva em " + nomeArquivo);

            System.out.println("Detalhes da conta bancária atualizada:");
            conta.exibirDetalhes();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar/atualizar a conta bancária: " + e.getMessage());
        }
    }
}
