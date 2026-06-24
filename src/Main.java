import Conteudo.ConteudoTexto;
import Conteudo.ConteudoTransacao;
import Hash.SHA256Hash;
import Validacao.ValidacaoCadeia;
import interfaces.CalculadoraHash;
import model.Bloco;
import model.Cadeia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        CalculadoraHash sha256 = new SHA256Hash();
        Cadeia chainNote = new Cadeia(sha256);
        ValidacaoCadeia validador = new ValidacaoCadeia(sha256);

        chainNote.adicionarBloco(new ConteudoTexto("Bloco Genesis"));
        chainNote.adicionarBloco(new ConteudoTransacao("Alice", "Bob", 50.0));

        int opcao = 0;
        while (opcao != 5) {
            System.out.println("\n--- CHAIN NOTE ---");
            System.out.println("1 - Adicionar Nova Nota (Texto)");
            System.out.println("2 - Listar Cadeia");
            System.out.println("3 - Validar Integridade");
            System.out.println("4 - [HACKER] Adulterar Bloco 1");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome o enter

            switch (opcao) {
                case 1:
                    System.out.print("Digite o texto da nota: ");
                    String texto = scanner.nextLine();
                    chainNote.adicionarBloco(new ConteudoTexto(texto));
                    System.out.println("Bloco adicionado!");
                    break;
                case 2:
                    System.out.println("\n[ Cadeia de Blocos ]");
                    for (Bloco b : chainNote.getBlocos()) {
                        System.out.println(b);
                    }
                    break;
                case 3:
                    boolean valida = validador.isValida(chainNote);
                    if (valida) {
                        System.out.println("\n✅ SUCESSO: A cadeia esta perfeitamente integra!");
                    } else {
                        System.out.println("\n❌ ALERTA: A cadeia foi corrompida!");
                    }
                    break;
                case 4:
                    if (chainNote.getBlocos().size() > 1) {
                        System.out.println("\nAdulterando o Bloco 1...");
                        // Substitui a transação Alice -> Bob por uma maliciosa
                        Bloco alvo = chainNote.getBlocos().get(1);
                        alvo.setConteudo(new ConteudoTransacao("Alice", "Hacker", 9999.0));
                        System.out.println("Dado adulterado! Execute a opção 3 para ver o validador em ação.");
                    } else {
                        System.out.println("Adicione mais blocos primeiro.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}