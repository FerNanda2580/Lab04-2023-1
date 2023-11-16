import list.Fila;
import list.No;

public class FilaF implements Fila{


    private No ce;
    private No cauda;

    public FilaF(){
        this.ce = null;
        cauda = null;

    }
 

    @Override
    public void enqueue(int item){
        No novoNo = new No(item);
        if (isEmpty()) {
            
            ce = novoNo;
            cauda = novoNo;
        } else {
          
            cauda.setProximo(novoNo);
            
            cauda = novoNo;
        }
       
    }


    @Override
    public int	dequeue(){
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia.");
        }

        int dequeuedItem = ce.getValor();
        ce = ce.proximo;

        if (ce == null) {
            cauda = null;
        }

        return dequeuedItem;

       
      

    }




    @Override
    public boolean isEmpty(){
        return ce == null;

        

    }



    @Override
    public int	size(){   
        int contador = 0;
        No current = ce;

        while (current != null) {
            contador++;
            current = current.next;
        }

        return contador;
    }
   

    
}
