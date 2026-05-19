package entities;
public class Coordenador extends Professor{

    public Coordenador(String nome, String email, String cpf, int siepe, int senha){
        super(nome, email, cpf, siepe, senha);
    }

    @Override
    public boolean login(int senha){
        if(getSenha() != senha){
            System.out.println("[x] Senha incorreta!");
            return false;
        }
        System.out.println("Login realizado com sucesso!");
        return true;
    }


    @Override
    public String toString() {
        return String.format("Coordenador: %s %nEmail: %s%nCpf: %s%nSiepe: %d", getNome(), getEmail(), getCpf(), getSiepe()
        );
    }
}
