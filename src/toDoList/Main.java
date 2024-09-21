package toDoList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // Instâncias do CRUD e ListarTarefa
        CrudTarefa crudTarefa = new CrudTarefa();
        ListarTarefa listarTarefa = new ListarTarefa();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        int opcao = -1;

        // Menu para interação com o usuário
        while (opcao != 0) {
            System.out.println("\n=== Gerenciador de Tarefas ===");
            System.out.println("1. Criar Tarefa");
            System.out.println("2. Editar Tarefa");
            System.out.println("3. Remover Tarefa");
            System.out.println("4. Marcar Tarefa como Concluída");
            System.out.println("5. Listar Todas as Tarefas");
            System.out.println("6. Listar Tarefas Concluídas");
            System.out.println("7. Listar Tarefas Pendentes");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Título da Tarefa: ");
                    String tituloTarefa = scanner.nextLine();
                    System.out.print("Descrição da Tarefa: ");
                    String descricaoTarefa = scanner.nextLine();
                    System.out.print("Data de Entrega (dd/MM/yyyy): ");
                    String dataEntregaStr = scanner.nextLine();
                    LocalDate dataEntrega = LocalDate.parse(dataEntregaStr, formatter);
                    criarTarefa(crudTarefa, tituloTarefa, descricaoTarefa, dataEntrega);
                    break;
                case 2:
                    editarTarefa(crudTarefa, scanner, formatter);
                    break;
                case 3:
                    removerTarefa(crudTarefa, scanner);
                    break;
                case 4:
                    marcarComoConcluida(crudTarefa, scanner);   
                    break;
                case 5:
                    listarTarefa.listarTarefas(crudTarefa.getTarefas());
                    break;
                case 6:
                    listarTarefa.listarTarefasConcluidas(crudTarefa.getTarefas());
                    break;
                case 7:
                    listarTarefa.listarTarefasPendentes(crudTarefa.getTarefas());
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }

    private static void criarTarefa(CrudTarefa crudTarefa, String titulo, String descricao, LocalDate dataEntrega) {
        crudTarefa.criarTarefa(titulo, descricao, dataEntrega);
        System.out.println("Tarefa criada com sucesso!");
    }

    private static void editarTarefa(CrudTarefa crudTarefa, Scanner scanner, DateTimeFormatter formatter) {
        System.out.print("ID da Tarefa a ser editada: ");
        String titulo1 = scanner.nextLine();
        System.out.print("Novo Título da Tarefa: ");
        String novoTitulo = scanner.nextLine();
        System.out.print("Nova Descrição da Tarefa: ");
        String novaDescricao = scanner.nextLine();
        System.out.print("Nova Data de Entrega (dd/MM/yyyy): ");
        String novaDataEntregaStr = scanner.nextLine();
        LocalDate novaDataEntrega = LocalDate.parse(novaDataEntregaStr, formatter);
        crudTarefa.editarTarefa(titulo1, novoTitulo, novaDescricao, novaDataEntrega);
        System.out.println("Tarefa editada com sucesso!");
    }

    private static void removerTarefa(CrudTarefa crudTarefa, Scanner scanner) {
        System.out.print("titulo da Tarefa a ser removida: ");
        String titulo = scanner.nextLine();
        crudTarefa.removerTarefa(titulo);
        System.out.println("Tarefa removida com sucesso!");
    }

    private static void marcarComoConcluida(CrudTarefa crudTarefa, Scanner scanner) {
        System.out.print("Título da Tarefa a ser marcada como concluída: ");
        String titulo2 = scanner.nextLine();
        crudTarefa.marcarComoConcluida(titulo2);
    }
}