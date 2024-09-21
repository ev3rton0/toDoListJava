package toDoList;
import java.util.List;

public class ListarTarefa {

    public void listarTarefas(List<Tarefa> tarefas) {
        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas a serem listadas.");
        } else {
            System.out.println("Lista de Tarefas:");
            for (Tarefa tarefa : tarefas) {
                System.out.println(tarefa);
            }
        }
    }

    public void listarTarefasConcluidas(List<Tarefa> tarefas) {
        System.out.println("Tarefas Concluídas:");
        for (Tarefa tarefa : tarefas) {
            if (tarefa.isConcluida()) {
                System.out.println(tarefa);
            }
        }
    }

    public void listarTarefasPendentes(List<Tarefa> tarefas) {
        System.out.println("Tarefas Pendentes:");
        for (Tarefa tarefa : tarefas) {
            if (!tarefa.isConcluida()) {
                System.out.println(tarefa);
            }
        }
    }
}