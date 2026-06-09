import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FilaAtendimento fila = new FilaAtendimento();
        int opcao;

        do{
            System.out.println("""
                   -= ------------------------------- =-
                   1 - Adicionar Paciente
                   2 - Chamar próximo paciente
                   3 - Mostrar fila de atendimentos
                   0 - Sair do programa
                    """);
            opcao = Integer.parseInt(scanner.nextLine());

            switch(opcao){
                case 1 -> {
                    System.out.println("Nome do paciente:  ");
                    String nome = scanner.nextLine();
                    fila.adicionar(new Paciente(nome));
                    System.out.println("Paciente adicionado com sucesso!");
                }
                case 2 -> {

                    Paciente paciente = fila.remover();
                    if(paciente == null){
                        System.out.println("Fila vazia!: ");
                    } else{
                        System.out.println("""
                                Chamando paciente: """
                        + paciente.getNome());
                    }
                }
                case 3 -> fila.exibir();
                case 0 -> System.out.println("""
                        Sistema encerrado """);
                default -> System.out.println("Opção inválida!");
            }

        } while(opcao !=0);
        scanner.close();
    }
}