package entities;
import Interfaces.Autenticavel;

public class Professor extends Pessoa implements Autenticavel {
    private int siepe;
    private int senha;

    public Professor(String nome, String email, int cpf, int siepe, int senha){
        super(nome, email, cpf);
        this.siepe = siepe;
        this.senha = senha;
    }

    public int getSiepe() {
        return siepe;
    }

    public int getSenha() {
        return senha;
    }


    @Override
    public boolean login(int senha){
        if(this.senha != senha){
            System.out.println("[x] Senha incorreta!");
            return false;
        }
        System.out.println("Login realizado!");
        return true;
    }

    @Override
    public String toString() {
        return String.format("Professor: %s %nEmail: %s%nCpf: %d%nSiepe: %d", getNome(), getEmail(), getCpf(), getSiepe()
        );
    }
}
