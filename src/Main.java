import java.util.Scanner;

public class Main {
    private static Scanner scanner;

    public static void main(String[] args) {
        Scanner myObject = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 0){
            System.out.println("--- MENU ---");
            System.out.println("1 - Inserir");
            System.out.println("2 - Listar");
            System.out.println("3 - Verificar");
            System.out.println("4 - (outra ação)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            myObject = scanner;

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
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

            scanner.close();
        }

    }

}