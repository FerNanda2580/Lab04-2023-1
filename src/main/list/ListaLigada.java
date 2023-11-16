package linked;

import list.EstruturaElementar;

public class ListaLigada implements EstruturaElementar {

    private No cabeca;
    

    public ListaLigada() {
        cabeca = null;
        

    }

    @Override
    public boolean buscaElemento(int valor) {
        No elem = cabeca;

        while (elem != null) {
            if (elem.getValor() == valor) {
                return true;
            }
            elem = elem.getProximo();
        }

        return false;

    }

    @Override
    public int buscaIndice(int valor) {
        if (cabeca == null) {
            return -1;
        } else {
            int contador = 0;
            No bus = cabeca;

            while (bus != null) {
                if (bus.getValor() == valor) {
                    return contador;
                }
                bus = bus.getProximo();
                contador++;
            }

            return -1;
        }

    }

    @Override
    public int minimo() {
        if (cabeca == null) {
            cabeca = null;
        }

        No mini = cabeca;
        int min = mini.getValor();

        while (mini != null) {
            if (mini.getValor() < min) {
                min = mini.getValor();
            }
            mini = mini.getProximo();
        }

        return min;

    }

    @Override
    public int maximo() {
        if (cabeca == null) {
            cabeca = null;
        }

        No maxi = cabeca;
        int max = maxi.getValor();

        while (maxi != null) {
            if (maxi.getValor() > max) {
                max = maxi.getValor();
            }
            maxi = maxi.getProximo();
        }

        return max;
    }

    @Override
    public int predecessor(int valor) {
        No atual = cabeca;
        No anterior = null;

        while (atual != null) {
            if (atual.getValor() == valor) {
                if (anterior != null) {
                    return anterior.getValor(); 
                } else {
                    return -1; 
                }
            }
            anterior = atual;
            atual = atual.getProximo();
        }

        return -1; 


    }

    @Override
    public int sucessor(int valor) {
        No atual = cabeca;

        while (atual != null) {
            if (atual.getValor() == valor) {
                if (atual.getProximo() != null) {
                    return atual.getProximo().getValor(); // Valor do sucessor
                } else {
                    return -1; 
                }
            }
            atual = atual.getProximo();
        }

        return -1; 
        

    }

    @Override
    public void insereElemento(int valor) {
        No novoNo = new No(valor);

        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            No elem = cabeca;
            while (elem.getProximo() != null) {
                elem = elem.getProximo();
            }
            elem.setProximo(novoNo);
        }
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        No posicao = new No(valor);
        if(buscaIndice == 0){
            posicao.setProximo(this.cabeca);
            this.cabeca = posicao;
        }
        No atual = this.cabeca;
        for (int i = 0; i <= buscaIndice - 1 && atual != null; i++){
            atual = atual.getProximo();
        }
        atual = posicao;
      
    }

    @Override
    public void insereInicio(int valor) {
        if (this.cabeca == null) {
            this.cabeca = new No(valor);
        } else {
            No n = new No(valor);
            n.setProximo(this.cabeca);
            this.cabeca = n;
        }

    }

    @Override
    public void insereFim(int valor) {
        if (cabeca == null) {
            cabeca = new No(valor);
           
        } else {
            No novoNo = new No(valor);
            No nFim = cabeca;

            while (nFim.getProximo() != null) {
                nFim = nFim.getProximo();
            }

            nFim.setProximo(novoNo);
        }

    }

    @Override
    public void remove(int valor) {
        if (cabeca == null) {
            cabeca = null;
        } else if (cabeca.getValor() == valor) {

            cabeca = cabeca.getProximo();
        } else {
            No remo = cabeca;

            while (remo.getProximo() != null) {
                if (remo.getProximo().getValor() == valor) {
                    remo.setProximo(remo.getProximo().getProximo());
                } else {
                    remo = remo.getProximo();
                }
            }

            if (remo.getProximo() != null) {
                remo.setProximo(remo.getProximo().getProximo());
            }
        }
    }

    @Override
    public void removeIndice(int indice) {
        No aux = null;
        No atual = this.cabeca;
        if(indice == 0){
            this.cabeca = this.cabeca.getProximo();
            return;
        }
        int pointer = 0;
        while(atual != null && pointer < indice){
            aux = atual;
            atual = atual.getProximo();
            pointer++;
        }
        if(atual != null){
            aux.setProximo(atual.getProximo());
        }

    }

    @Override
    public void removeInicio() {
        if (cabeca == null) {
            cabeca = null;
        } else {
            cabeca = cabeca.getProximo();
        }

    }

    @Override
    public void removeFim() {
        if (cabeca == null) {
            cabeca = null;
            

        } else if (cabeca.getProximo() == null) {
            cabeca = null;
        } else {

            No penultimo = cabeca;
            while (penultimo.getProximo().getProximo() != null) {
                penultimo = penultimo.getProximo();
            }

            penultimo.setProximo(null);
        }

    }

}