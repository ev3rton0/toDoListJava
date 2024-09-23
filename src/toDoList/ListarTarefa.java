package toDoList;
import java.util.List;

public class ListarTarefa {

    public void listarTarefas(List<Tarefa> tarefas) {
        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas a serem listadas.");
        } else {
            System.out.println("\n|Lista de Tarefas:");
            for (Tarefa tarefa : tarefas) {
                System.out.println(tarefa);
            } System.out.println("==========================");
        }
    }

    public void listarTarefasConcluidas(List<Tarefa> tarefas) {
        System.out.println("\n|Tarefas Concluídas:");
        if (tarefas.isEmpty()){
            System.out.println("Não há tarefas concluídas");
        } else {
            for (Tarefa tarefa : tarefas) {
                if (tarefa.isConcluida()) {
                System.out.println(tarefa);
                }
        } System.out.println("==========================");
        
        }
    }

    public void listarTarefasPendentes(List<Tarefa> tarefas) {
        System.out.println("\n|Tarefas Pendentes:");
        if(tarefas.isEmpty()){
            System.out.println("Não há tarefas pendentes");
        } else {
            for (Tarefa tarefa : tarefas) {
                if (!tarefa.isConcluida()) {
                    System.out.println(tarefa);}
        }System.out.println("==========================");
        }
    }
}