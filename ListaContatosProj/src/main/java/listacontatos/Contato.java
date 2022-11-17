package listacontatos;


public class Contato {

    private String nome;
    private Telefone telefone;
    private String endereco;
    private String email;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean setEmail(String email) {
        if(email.matches("[\\w\\.]+@.*"))
        {
            this.email = email;
            return true;
        }
        
        return false;
    }

    @Override
    public String toString() {
        return nome + " <" + email + '>';
    }
}
