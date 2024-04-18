import java.io.*;

public class CopiarArquivoGrande {
    public static void main(String[] args) {
        String arquivoOrigem = "arquivo_grande.bin";
        String arquivoDestino = "copia_arquivo_grande.bin";

        int tamanhoBuffer = 4096;

        try {
            FileInputStream entrada = new FileInputStream(arquivoOrigem);
            FileOutputStream saida = new FileOutputStream(arquivoDestino);

            byte[] buffer = new byte[tamanhoBuffer];

            int bytesLidos;
            while ((bytesLidos = entrada.read(buffer)) != -1) {
                saida.write(buffer, 0, bytesLidos);
            }

            entrada.close();
            saida.close();

            System.out.println("Arquivo copiado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao copiar o arquivo: " + e.getMessage());
        }
    }
}
