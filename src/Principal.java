import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        BuscaCep buscaCep = new BuscaCep();

        System.out.println("Digite um CEP para consulta: ");
        var cep = sc.nextLine();
        try {
            Endereco novoEndereco = buscaCep.buscaEndereco(cep);
            System.out.println(novoEndereco);
            GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
            geradorDeArquivo.salvaJson(novoEndereco);
        }catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }
    }
}