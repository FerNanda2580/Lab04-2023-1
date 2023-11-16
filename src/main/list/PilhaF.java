package list;


public class PilhaF implements Pilha{

    private No top;

       
    @Override
    public boolean isEmpty(){
        return top == null;

    }

    @Override
    public void push(int item){
        No novoNo = new No(item);
        novoNo.setProximo(top);
        top = novoNo;
    }

    @Override
    public int pop(){
        int valorRemovido = top.getValor();
        top = top.getProximo();
        return valorRemovido;
       
    }

}

    
