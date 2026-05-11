package entities;
import Interfaces.Avaliavel;
import java.util.ArrayList;

public class Aluno extends Pessoa implements Avaliavel {
    private int matricula;
    private ArrayList<Double> notasAluno = new ArrayList<>();

    public Aluno(String nome, String email, String cpf, int matricula){
        super(nome, email, cpf);
        this.matricula = matricula;
        this.notasAluno = notasAluno;
    }

    public int getMatricula() {
        return matricula;
    }

    public void adicionarNota(double nota){
        notasAluno.add(nota);
    }


    @Override
    public double getMediaFinal(){
        double soma = 0;

        if(notasAluno.isEmpty()){
            System.out.println("[x] Alunos sem notas cadastradas!");
            return 0;
        }
        for(Double nota : notasAluno){
            soma += nota;
        }
        return soma / notasAluno.size();
    }

    @Override
    public String toString() {
        return String.format("Aluno: %s%nEmail: %s%nCpf: %d%nMatrícula: %d", getNome(), getEmail(), getCpf(), getMatricula()
        );
    }
}
