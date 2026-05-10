package Service;
import entities.Aluno;
import entities.Pessoa;
import entities.Professor;

import java.util.ArrayList;

public class GestaoInstucional {
    private ArrayList<Aluno> listaAlunos = new ArrayList<>();
    private ArrayList<Professor> listaFuncionario = new ArrayList<>();
    private ArrayList<Pessoa> listaComunidade = new ArrayList<>();

    public void cadastrarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
        listaComunidade.add(aluno);
    }

    public void cadastrarFuncionario(Professor funcionario) {
        listaFuncionario.add(funcionario);
        listaComunidade.add(funcionario);
    }

    public Aluno buscarAluno(int matricula) {
        if (listaAlunos.isEmpty()) {
            System.out.println("[x] Nenhum aluno cadastrado.");
        }
        for (int aux = 0; aux < listaAlunos.size(); aux++) {
            Aluno aluno = listaAlunos.get(aux);
            if (aluno.getMatricula() == matricula) {
                return aluno;
            }
        }
        return null;
    }

    public void lancarNotas(int matricula, double nota) {
        Aluno aluno = buscarAluno(matricula);

        if (aluno != null) {
            aluno.adicionarNota(nota);
            System.out.printf("[ ✔ ] Nota: %.2f lançada com sucesso!%n%n", nota);
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    public void listarComunidade() {
        if (listaComunidade.isEmpty()) {
            System.out.println("[x] Comunidade vazia.");
            return;
        }
        System.out.println("=== COMUNIDADE ACADÊMICA ===");
        int i = 1;
        for (Pessoa p : listaComunidade) {
            System.out.println(i + " - " + p);
            i++;
        }
    }

    public Professor buscarFuncionario(int siepe) {
        if (listaFuncionario.isEmpty()) {
            System.out.println("[x] Não há funcionários cadastrados!");
        }
        for (int aux = 0; aux < listaFuncionario.size(); aux++) {
            Professor funcionario = listaFuncionario.get(aux);
            if (funcionario.getSiepe() == siepe) {
                return funcionario;
            }
        }
        return null;
    }

    public boolean autenticarFuncionario(int siepe, int senha) {
        Professor funcionario = buscarFuncionario(siepe);

        if(funcionario != null){
            return funcionario.login(senha);
        }
        System.out.println("[x] Funcionário não encontrado!");
        return false;
    }
}

