package toDoList;
import java.util.ArrayList;

public class ListarTarefas {
	ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
	
	public void adicionarTarefa(Tarefa tarefa) {
		tarefas.add(tarefa);
	}
	
	public void removerTarefa(Tarefa tarefa) {
		tarefas.remove(tarefa);
	}
	
	public void listarTarefas() {
		for (Tarefa tarefa : tarefas) {
			System.out.println(tarefa.toString());
		}
	}
	
	
	
}