import java.util.Scanner;

public class Main {
    private static final int RELEASED = 0;
    private static final int WANTED = 1;
    private static final int HELD = 2;

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        Process process = new Process(RELEASED, String.valueOf(i));
        process.start();
        String option = "";
        while (option.equalsIgnoreCase("0")){
            System.out.println("0 - sair");
            System.out.println("O que deseja fazer? ");
            option = scan.nextLine();
        }
    }

    private void addNewProcess(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Nome do processo: ");
        String nome = scan.nextLine();
        Process process = new Process(RELEASED, nome);
        process.start();
    }
}
