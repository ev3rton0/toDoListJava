package toDoList;
import java.time.LocalDate;


public class Tarefa {
	    private String titulo;
	    private String descricao;
	    private boolean concluida;
	    private LocalDate dataEntrega;
	    private int prioridade; // 1: Baixa, 2: Média, 3: Alta

	    // Construtor
	    public Tarefa(String titulo, String descricao, LocalDate dataEntrega, int prioridade) {
	        this.titulo = titulo;
	        this.descricao = descricao;
	        this.dataEntrega = dataEntrega;
	        this.prioridade = prioridade;
	        this.concluida = false; // Por padrão, uma nova tarefa não está concluída
	    }
	    
	    @Override
	    public String toString() {
	    	return "titulo da tarefa: " + this.titulo + " | descrição: " + this.descricao + "| a prioridade é: " + Integer.toString(this.prioridade);
	    }

	    // Método para marcar a tarefa como concluída
	    public void marcarComoConcluida() {
	        this.concluida = true;
	    }

	    // Método para editar a tarefa
	    public void editarTarefa(String titulo, String descricao, LocalDate dataEntrega, int prioridade) {
	        this.titulo = titulo;
	        this.descricao = descricao;
	        this.dataEntrega = dataEntrega;
	        this.prioridade = prioridade;
	    }

	    // Retorna se a tarefa está concluída ou não
	    public boolean isConcluida() {
	        return concluida;
	    }

	    // Comparação de tarefas por data de entrega (se quiser ordenar por data)
	    public int compareTo(Tarefa outraTarefa) {
	        return this.dataEntrega.compareTo(outraTarefa.dataEntrega);
	    }

	    // Getters e Setters (se precisar acessar os atributos de fora)
	    public String getTitulo() {
	        return titulo;
	    }

	    public String getDescricao() {
	        return descricao;
	    }

	    public LocalDate getDataEntrega() {
	        return dataEntrega;
	    }

	    public int getPrioridade() {
	        return prioridade;
	    }
	    
	    public void setTitulo(String titulo) {
	        this.titulo = titulo;
	    }

	    public void setDescricao(String descricao) {
	        this.descricao = descricao;
	    }

	    public void setDataEntrega(LocalDate dataEntrega) {
	        this.dataEntrega = dataEntrega;
	    }

	    public void setPrioridade(int prioridade) {
	        this.prioridade = prioridade;
	    }
}