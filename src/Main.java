import entities.Aluno;
import entities.*;
import service.RelatorioAcademico;

import java.util.Locale;
import java.util.Scanner;

public class Main{
    static service.GestaoInstucional sistemaSecretaria = new service.GestaoInstucional();
    public static void main(String[] args) {
        int opcao;
        Scanner userInput = new Scanner(System.in).useLocale(Locale.US);
        do{
            exibirMenu();
            opcao = lerOpcao(userInput);

            switch(opcao){
                case 1:
                    menuCadastrarAluno(userInput);
                    break;
                case 2:
                    menuCadastrarFuncionario(userInput);
                    break;
                case 3:
                    menuLancarNota(userInput);
                    break;
                case 4:
                    menuListarComunidade();
                    break;
                case 5:
                    menuExibirEstatisticaAluno(userInput);
                    break;
                case 6:
                    menuExibirEstatisticas();
                    break;
                case 7:
                    menuExibirAutenticacao(userInput);
                    break;
                case 8:
                    finalizarPrograma();
                    break;
                default:
                    System.out.println("[x] Opção inválida! Tente novamente.");
            }
        }while(opcao != 8);
    }
    public static void exibirMenu(){
        System.out.println("=== SISTEMA ACADÊMICO ===");
        System.out.println("[1] Cadastrar aluno\n[2] Cadastrar Professor/Coordenador\n[3] Lançar notas do Aluno\n[4] Listar comunidade acadêmica\n[5] Exibir Estatísticas do Aluno \n[6] Exibir Estatísticas\n[7] Acesso Administrativo\n[8] Sair\n\nInsira uma opção: ");
    }

    public static void menuCadastrarAluno(Scanner userInput){
        System.out.println("[INSIRA AS INFORMAÇÕES DO ALUNO]");
        System.out.println("Nome: ");
        String nome = userInput.nextLine();
        System.out.println("Email: ");
        String email = userInput.nextLine();
        System.out.println("Cpf: ");
        String cpf = userInput.nextLine();
        System.out.println("Insira o número de matrícula: ");
        int matricula = Integer.parseInt(userInput.nextLine());
        Aluno aluno = new Aluno(nome, email, cpf, matricula);

        sistemaSecretaria.cadastrarAluno(aluno);
        System.out.printf("[ ✔ ] Aluno criado com sucesso!%n%s%n%n", aluno);
    }

    public static void menuCadastrarFuncionario(Scanner userInput){

        System.out.println("[INSIRA O CARGO DESEJADO]");
        System.out.println("[1] Coordenador");
        System.out.println("[2] Professor");

        int opcao = Integer.parseInt(userInput.nextLine());

        System.out.println("Nome:");
        String nome = userInput.nextLine();
        System.out.println("Email:");
        String email = userInput.nextLine();
        System.out.println("CPF:");
        String cpf = userInput.nextLine();
        System.out.println("Código Siepe:");
        int siepe = Integer.parseInt(userInput.nextLine());
        System.out.println("Senha:");
        int senha = Integer.parseInt(userInput.nextLine());

        if(opcao == 1){
            Coordenador coordenador = new Coordenador(nome, email, cpf, siepe, senha);
            sistemaSecretaria.cadastrarFuncionario(coordenador);
            System.out.printf("[ ✔ ] Coordenador criado com sucesso!%n%s%n%n", coordenador);
        } else if(opcao == 2){
            Professor professor = new Professor(nome, email, cpf, siepe, senha);
            sistemaSecretaria.cadastrarFuncionario(professor);
            System.out.printf("[ ✔ ] Professor criado com sucesso!%n%s%n%n", professor);
        }else{
            System.out.println("[x] Opção inválida!");
        }
    }

    public static void menuLancarNota(Scanner userInput){
        System.out.println("[INSIRA A MATRICULA DO ALUNO]");
        int matricula = Integer.parseInt(userInput.nextLine());

        Aluno aluno = sistemaSecretaria.buscarAluno(matricula);

        if(aluno == null){
            System.out.println("[x] Aluno não encontrado");
            return;
        }

        System.out.println("Nota: ");
        double nota = Double.parseDouble(userInput.nextLine());
        sistemaSecretaria.lancarNotas(matricula, nota);
    }

    public static void menuListarComunidade(){
        sistemaSecretaria.listarComunidade();
    }

    public static void menuExibirEstatisticaAluno(Scanner userInput){
        System.out.println("[INSIRA A MATRICULA DO ALUNO]");
        int matricula = Integer.parseInt(userInput.nextLine());
        Aluno aluno = sistemaSecretaria.buscarAluno(matricula);

        if(aluno != null){
            System.out.printf("Média final: %.2f", aluno.getMediaFinal());
        }else{
            System.out.println("[x] Aluno não encontrado!");
        }
    }

    public static void menuExibirEstatisticas(){
        RelatorioAcademico relatorio = new RelatorioAcademico();
        for(Aluno aluno : sistemaSecretaria.getListaAlunos()){
            relatorio.adicionarDados(aluno);
        }
        relatorio.exibirEstatisticas();
    }

    public static void menuExibirAutenticacao(Scanner userInput){
        System.out.println("[INSIRA O SIEPE]");
        int siepe = Integer.parseInt(userInput.nextLine());

        System.out.println("[INSIRA A SENHA]");
        int senha = Integer.parseInt(userInput.nextLine());

        sistemaSecretaria.autenticarFuncionario(siepe, senha);
    }

    public static void finalizarPrograma(){
        System.out.println(". . . . FINALIZANDO PROGRAMA . . . .");
    }

    public static int lerOpcao(Scanner userInput){
        try{
            return Integer.parseInt(userInput.nextLine());
        }catch(Exception e){
            return 0;
        }
    }
}
