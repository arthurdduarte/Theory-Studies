public class Paciente {
    private final String nome;

    public Paciente(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
    @Override
    public String toString(){
        return nome;
    }


}
