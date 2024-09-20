package toDoList;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
	
		
		Tarefa tarefa1 = new Tarefa("Estudar java", "tem que estudar", LocalDate.of(2024, 9, 20), 3);
		Tarefa tarefa2 = new Tarefa("Estudar java2", "tem que estudar", LocalDate.of(2024, 9, 20), 3);
		
		ListarTarefas listaOficial = new ListarTarefas();
		
		listaOficial.adicionarTarefa(tarefa1);
		
		listaOficial.listarTarefas();
		
		
		
	}
}