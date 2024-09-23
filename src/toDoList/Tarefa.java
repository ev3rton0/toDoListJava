package toDoList;
import java.time.LocalDate;

public class Tarefa {
    private String titulo;
    private String descricao;
    private LocalDate dataEntrega;
    private boolean concluida;

    public Tarefa(String titulo, String descricao, LocalDate dataEntrega) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.concluida = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void marcarComoConcluida() {
        this.concluida = true;
    }
    
    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    @Override
    public String toString() {
        return "=========================="+"\nTarefa: " + titulo + "\nDescrição: " + descricao + "\nData de Entrega: " + dataEntrega + "\nConcluída: " + (concluida ? "Sim" : "Não");
    }

    // Sobrescreve equals() para comparação de tarefas pelo título que garante que só são iguais se o título for igual.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tarefa tarefa = (Tarefa) obj;
        return titulo.equals(tarefa.titulo);
    }
}