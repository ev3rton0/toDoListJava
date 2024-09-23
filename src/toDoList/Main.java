package toDoList;
import toDoList.AlternarUsuarios.TipoUsuario;
import toDoList.Incrementos.asciiArt;
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
        asciiArt asciiArt = new asciiArt();

        System.out.println(asciiArt.getImprimirTitulo());

        TipoUsuario tipoUsuario = selecionarTipoUsuario(scanner);

        int opcao = -1;

        // Menu para interação com o usuário
        while (opcao != 0) {
            exibirMenu(tipoUsuario);
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (opcao) {
                case 1:
                    if (tipoUsuario == TipoUsuario.ADMINISTRADOR) {
                        System.out.print("\nTítulo da Tarefa: ");
                        String tituloTarefa = scanner.nextLine().trim();
                        System.out.print("Descrição da Tarefa: ");
                        String descricaoTarefa = scanner.nextLine();
                        System.out.print("Data de Entrega (dd/MM/yyyy): ");
                        String dataEntregaStr = scanner.nextLine();
                        LocalDate dataEntrega = LocalDate.parse(dataEntregaStr, formatter);
                        criarTarefa(crudTarefa, tituloTarefa, descricaoTarefa, dataEntrega);
                    } else {
                        System.out.println("Opção inválida para o usuário leitor.");
                    }
                    break;
                case 2:
                    if (tipoUsuario == TipoUsuario.ADMINISTRADOR) {
                        editarTarefa(crudTarefa, scanner, formatter);
                    } else {
                        System.out.println("Opção inválida para o usuário leitor.");
                    }
                    break;
                case 3:
                    if (tipoUsuario == TipoUsuario.ADMINISTRADOR) {
                        removerTarefa(crudTarefa, scanner);
                    } else {
                        System.out.println("Opção inválida para o usuário leitor.");
                    }
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
                case 9:
                    tipoUsuario = selecionarTipoUsuario(scanner);
                    break;
                case 0:
                    System.out.println("Finalizando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }

    private static TipoUsuario selecionarTipoUsuario(Scanner scanner) {
        System.out.println("| 1. Administrador");
        System.out.println("| 2. Leitor");
        System.out.println("\nSelecione o tipo de usuário:");
        int escolha = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        if (escolha == 1) {
            return TipoUsuario.ADMINISTRADOR;
        } else if (escolha == 2) {
            return TipoUsuario.LEITOR;
        } else {
            System.out.println("Opção inválida. Selecionando usuário leitor por padrão.");
            return TipoUsuario.LEITOR;
        }
    }

    private static void exibirMenu(TipoUsuario tipoUsuario) {
        System.out.println("\n------To-Do List------");
        if (tipoUsuario == TipoUsuario.ADMINISTRADOR) {
            System.out.println("| 1. Criar Tarefa");
            System.out.println("| 2. Editar Tarefa");
            System.out.println("| 3. Remover Tarefa");
        }
        System.out.println("| 4. Marcar Tarefa como Concluída");
        System.out.println("| 5. Listar Todas as Tarefas");
        System.out.println("| 6. Listar Tarefas Concluídas");
        System.out.println("| 7. Listar Tarefas Pendentes");
        System.out.println("| 9. Mudar Tipo de Usuário");
        System.out.println("| 0. Finalizar\n");
    }

    private static void criarTarefa(CrudTarefa crudTarefa, String titulo, String descricao, LocalDate dataEntrega) {
        crudTarefa.criarTarefa(titulo, descricao, dataEntrega);
        System.out.println("Tarefa criada com sucesso!");
    }

    private static void editarTarefa(CrudTarefa crudTarefa, Scanner scanner, DateTimeFormatter formatter) {
        System.out.print("\nTítulo da Tarefa a ser editada: ");
        String titulo1 = scanner.nextLine();
        if (crudTarefa.buscarTarefa(titulo1)) {
            System.out.print("Novo Título da Tarefa: ");
            String novoTitulo = scanner.nextLine();
            System.out.print("Nova Descrição da Tarefa: ");
            String novaDescricao = scanner.nextLine();
            System.out.print("Nova Data de Entrega (dd/MM/yyyy): ");
            String novaDataEntregaStr = scanner.nextLine();
            LocalDate novaDataEntrega = LocalDate.parse(novaDataEntregaStr, formatter);
            if(crudTarefa.editarTarefa(titulo1, novoTitulo, novaDescricao, novaDataEntrega)){
                System.out.println("Tarefa editada com sucesso!");
            } else {
                System.out.println("Tarefa não encontrada.");
            }
        }
    }

    private static void removerTarefa(CrudTarefa crudTarefa, Scanner scanner) {
        System.out.print("\nTítulo da Tarefa a ser removida: ");
        String titulo = scanner.nextLine();
        if(crudTarefa.removerTarefa(titulo)) {
            System.out.println("Tarefa removida com sucesso!");
        }
    }

    private static void marcarComoConcluida(CrudTarefa crudTarefa, Scanner scanner) {
        System.out.print("\nTítulo da Tarefa a ser marcada como concluída: ");
        String titulo2 = scanner.nextLine();
        boolean marcar = crudTarefa.marcarComoConcluida(titulo2);
    if (!marcar) {
        System.out.println("Tarefa não encontrada!.");
    } else{
        System.out.println("Tarefa marcada como concluída com sucesso!");
    }
 }
}
