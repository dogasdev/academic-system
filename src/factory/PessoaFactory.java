package factory;

import entities.Coordenador;
import entities.Professor;

public class PessoaFactory {
    public static Professor criarFuncionario(
            int opcao,
            String nome,
            String email,
            String cpf,
            int siepe,
            int senha
    ){

        if(opcao == 1){
            return new Coordenador(
                    nome,
                    email,
                    cpf,
                    siepe,
                    senha
            );
        }

        if(opcao == 2){
            return new Professor(
                    nome,
                    email,
                    cpf,
                    siepe,
                    senha
            );
        }

        return null;
    }
}
