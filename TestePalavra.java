import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.InputMismatchException;

public class TestePalavra {

    // ANDRESSA MARQUES FERNANDES - 31786812 - TURMA 03H

    static final Scanner input = new Scanner(System.in);
    static int opcao = 0;
    static ABB abb = new ABB();
    static int totalOcorrencias = 0;

    public static void main(String[] args) {

        do {
            do {
                try {
                    System.out.println("\nMenu principal \n" +
                            "1- Carregar o texto \n" +
                            "2- Contador de palavras \n" +
                            "3- Busca por palavra \n" +
                            "4- Exibição do texto \n" +
                            "5- Encerrar"
                    );
                    System.out.print("Sua opção: ");
                    opcao = input.nextInt();
                    break;
                }
                catch (InputMismatchException e) {
                    System.out.println("Opcão inválida!");
                }
                input.nextLine();
            } while(opcao <= 0);

            switch (opcao) {
                case 1:
                    carregaArquivo(abb);
                    break;
                case 2:
                    if (abb.getRoot() != null) {
                        System.out.println("\nTotal de palavras: " + contaPalavras(abb.getRoot()));
                    } else {
                        System.out.println("\nCarregue o texto primeiro!");
                    }
                    break;

                case 3:
                    if (abb.getRoot() != null) {
                        buscaPalavra(abb);
                    } else {
                        System.out.println("\nCarregue o texto primeiro!");
                    }
                    break;

                case 4:
                    if (abb.getRoot() != null) {
                        exibeTexto(abb);
                    } else {
                        System.out.println("\nCarregue o texto primeiro!");
                    }
                    break;

                case 5:
                    System.out.println("\nEncerrando...");
                    break;

                default:
                    System.out.println("\nOpção inválida!");
            }
        } while (opcao != 5);
    }

    public static void carregaArquivo(ABB abb) {
        try {
            FileReader file = new FileReader("C:\\Users\\Andressa\\Desktop\\information systems\\estrutura_dados\\Projeto2\\src\\construcao_chico_buarque.txt");
            Scanner reader = new Scanner(file);
            String st;

            while (reader.hasNext()) {
                st = reader.next();
                Palavra palavra = new Palavra(st);
                Node node = new Node(palavra);

                if (abb.busca(node) != null) {
                    abb.busca(node).setOcorrencias();
                } else {
                    abb.insere(node);
                }
            }
            System.out.println("\nTexto carregado.");
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("\nArquivo não encontrado.");
        }
    }

    public static void buscaPalavra(ABB abb) {
        System.out.print("Busque uma palavra: ");
        String palavra = input.next();
        Node node = new Node(new Palavra(palavra));
        if (abb.busca(node) == null) {
            System.out.println("\nNão há nenhuma ocorrência desta palavra.");
        } else {
            System.out.println("\nQuantidade de ocorrências: " + abb.busca(node).getOcorrencias());
        }
    }

    public static void exibeTexto(ABB abb) {
        abb.executaInOrdem(abb.getRoot());
    }

    public static int contaPalavras(Node no) {
        if (no == null) {
            return 0;
        }
        contaPalavras(no.getLeft());
        contaPalavras(no.getRight());

        totalOcorrencias += no.getOcorrencias();
        return totalOcorrencias;
    }
}
