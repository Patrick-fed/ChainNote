import Conteudo.ConteudoTexto;
import Conteudo.ConteudoTransacao;
import Hash.MD5Hash;
import Hash.SHA256Hash;
import Validacao.ValidacaoCadeia;
import interfaces.CalculadoraHash;
import model.Bloco;
import model.Cadeia;
import View.BlocoExibicao;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //CalculadoraHash md5 = new MD5Hash();
        //Cadeia chainNote = new Cadeia(md5);
        //ValidacaoCadeia validador = new ValidacaoCadeia(md5);

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
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o texto da nota: ");
                    String texto = scanner.nextLine();
                    chainNote.adicionarBloco(new ConteudoTexto(texto));
                    System.out.println("Bloco adicionado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n[ Cadeia de Blocos ]");
                    for (Bloco b : chainNote.getBlocos()) {
                        System.out.println(BlocoExibicao.formatarParaConsole(b));
                    }
                    break;

                case 3:
                    if (validador.isValida(chainNote)) {
                        System.out.println("\n SUCESSO: A cadeia está perfeitamente íntegra!");
                    } else {
                        System.out.println("\n ALERTA: A cadeia foi comprometida!");
                    }
                    break;

                case 4:
                    if (chainNote.getBlocos().size() > 1) {
                        System.out.println("\n[Ataque] Adulterando o Bloco escolhido...");
                        Bloco alvo = chainNote.getBlocos().get(1);
                        alvo.setConteudo(new ConteudoTransacao("Alice", "Hacker", 9999.0));
                        System.out.println("Dado alterado na memória! Execute a opção 3 para validar.");
                    } else {
                        System.out.println("Adicione mais blocos antes de simular o ataque.");
                    }
                    break;

                case 5:
                    System.out.println("Encerrando aplicação...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}