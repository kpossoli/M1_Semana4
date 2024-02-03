package abstracao;
import java.util.ArrayList;

// Classe Professor
public class Professor {
    // Atributos
    private String nome;
    private String especialidade;

    // Construtor
    public Professor(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    // Método Ensinar
    public void ensinar() {
        System.out.println("O professor " + nome + " está ensinando.");
    }
}