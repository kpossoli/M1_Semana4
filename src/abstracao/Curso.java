package abstracao;
import java.util.ArrayList;

// Classe Curso
public class Curso {
    // Atributos
    private String nome;
    private String descricao;
    private ArrayList<Professor> professores;
    private int cargaHoraria;

    // Construtor
    public Curso(String nome, String descricao, int cargaHoraria) {
        this.nome = nome;
        this.descricao = descricao;
        this.professores = new ArrayList<>();
        this.cargaHoraria = cargaHoraria;
    }

    // Método Progresso
    public void progresso() {
        System.out.println("Acompanhamento do progresso do curso.");
    }

    // Método Notas
    public void notas() {
        System.out.println("Exibindo notas do curso.");
    }

    // Método Participação
    public void participacao() {
        System.out.println("Avaliando participação no curso.");
    }
}
