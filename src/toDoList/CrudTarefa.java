package toDoList;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CrudTarefa {
    private List<Tarefa> tarefas;

    public CrudTarefa() {
        this.tarefas = new ArrayList<>();
    }

    public boolean marcarComoConcluida(String titulo) {
        /*if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas para marcar como concluída.");
            return false;
        }*/

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equals(titulo)) {
                tarefa.setConcluida(true);
                System.out.println("Tarefa marcada como concluída: " + titulo);
                
                return true;
            }
        }
        return false;
    }

    public boolean buscarTarefa(String titulo) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equals(titulo)) {
                System.out.println(tarefa);
                return true;
            }
        }
        System.out.println("Tarefa não encontrada.");
        return false;
    }

    // Método para criar uma nova tarefa
    public void criarTarefa(String titulo, String descricao, LocalDate dataEntrega) {
        Tarefa novaTarefa = new Tarefa(titulo, descricao, dataEntrega);
        tarefas.add(novaTarefa);
        System.out.println("Tarefa criada: " + novaTarefa.getTitulo());
    }

    // Método para editar uma tarefa existente
    public boolean editarTarefa(String tituloExistente, String novoTitulo, String novaDescricao, LocalDate novaDataEntrega) {
        if (tarefas.isEmpty()){
            System.out.println("Não há tarefas para ser editada.");
        } else {
            for (Tarefa tarefa : tarefas) {
                if (tarefa.getTitulo().equals(tituloExistente)) {
                    // Como não temos setters, criamos uma nova instância e substituímos a tarefa
                    tarefas.remove(tarefa);
                    tarefas.add(new Tarefa(novoTitulo, novaDescricao, novaDataEntrega));
                    System.out.println("Tarefa editada: " + novoTitulo);
                    return true;
            }
         }
        }return false;
        
        
    }

    // Método para remover uma tarefa
    public boolean removerTarefa(String titulo) {
        Tarefa tarefaParaRemover = null;
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equals(titulo)) {
                tarefaParaRemover = tarefa;
                break;
            }
        }
        if (tarefaParaRemover != null) {
            tarefas.remove(tarefaParaRemover);
            System.out.println("Tarefa removida: " + titulo);
            return true;
        } else {
            System.out.println("Tarefa não encontrada para remoção.");
            return false;
        }
    }

    // Getter para obter a lista de tarefas
    public List<Tarefa> getTarefas() {
        return tarefas;
    }
}