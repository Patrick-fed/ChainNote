import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        System.out.println("--- MENU ---");
        System.out.println("1 - Inserir");
        System.out.println("2 - Listar");
        System.out.println("3 - Verificar");
        System.out.println("4 - (outra ação)");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");

        while (opcao != 5){

            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Inserir");
                    break;
                case 2:
                    System.out.println("Listar");
                    break;
                case 3:
                    System.out.println("Verificar");
                    break;
                case 4:
                    System.out.println("Aqui por via das duvidas.");
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        }
        scanner.close();
    }

}