import java.util.LinkedList;
import java.util.Queue;

public class Fila<T> {

    private final Queue<T> fila = new LinkedList<>();

    public void adicionar(T elemento){
        fila.offer(elemento);
    }
    public T remover(){ return fila.poll();}
    public boolean estaVazia(){return fila.isEmpty();}
    public void exibir(){
        if(estaVazia()){
            System.out.println("Fila está vazia.");
            return;
        }
        for (T elemento: fila){
            System.out.println(elemento);
        }

    }



}
