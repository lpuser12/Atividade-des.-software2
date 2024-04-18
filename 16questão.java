import java.io.*;

public class LerPrimeirosBytes {
    public static void main(String[] args) {
        String nomeArquivo = "arquivo.bin";

        try {
            FileInputStream inputStream = new FileInputStream(nomeArquivo);

            byte[] buffer = new byte[100];
            int bytesLidos = inputStream.read(buffer);

            System.out.println("Primeiros 100 bytes do arquivo " + nomeArquivo + ":");
            for (int i = 0; i < bytesLidos; i++) {
                System.out.print(buffer[i] + " ");
            }

            inputStream.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
