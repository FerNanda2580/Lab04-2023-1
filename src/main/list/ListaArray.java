package array;

import list.EstruturaElementar;

public class ListaArray implements EstruturaElementar{

    private int[] array;
    private int indice_fim;

    public ListaArray() {
        this.array = new int[10];
        this.indice_fim = 0;

    }

    @Override
    public boolean buscaElemento(int valor) {
        for (int i = 0; i < indice_fim; i++) {
            if (array[i] == valor) {
                return true;
            }
        }
        return false;
        
    }

    @Override
    public int buscaIndice(int valor) {    
        for (int i = 0; i < indice_fim; i++) {
            if (array[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int minimo() {
        if (indice_fim == 0) {
            return -1;
        }

        int min = array[0];
        for (int i = 1; i < indice_fim; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    @Override
    public int maximo() {
        if (indice_fim == 0) {
            return -1;
        }

        int max = array[0];
        for (int i = 1; i < indice_fim; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
        
    }

    @Override
    public int predecessor(int valor) {
        for (int i = 0; i < indice_fim; i++) {
            if (array[i] == valor) {
                if (i > 0) {
                    return array[i - 1];
                    return -1; 
                }
            }
        }
        return -1; 
        
    }

    @Override
    public int sucessor(int valor) {
        for (int i = 0; i < indice_fim; i++) {
            if (array[i] == valor) {
                if (i < indice_fim - 1) {
                    return array[i + 1]; 
                } else {
                    return -1; 
                }
            }
        }
        return -1; 
    }

    @Override
    public void insereElemento(int valor) {
        if (indice_fim == array.length) {
            indice_fim = 0;
        }
        array[indice_fim] = valor;
        indice_fim++;
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        if (buscaIndice >= 0) {
            if (buscaIndice <= indice_fim) {
                if (indice_fim == array.length) {
                    indice_fim = 0;
                }

                for (int i = indice_fim; i > buscaIndice; i--) {
                    array[i] = array[i - 1];
                }

                array[buscaIndice] = valor;
                indice_fim++;
            }
        }
       
    }

    @Override
    public void insereInicio(int valor) {
        for (int i = indice_fim; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = valor;
        indice_fim++;
    }
    

    @Override
    public void insereFim(int valor) {
        array[indice_fim] = valor;
        indice_fim++;
    }

    @Override
    public void remove(int valor) {
        int indice = buscaIndice(valor);

        if (indice != -1) {
            for (int i = indice; i < indice_fim - 1; i++) {
                array[i] = array[i + 1];
            }
            indice_fim--;
        }
        
    }

    @Override
    public void removeIndice(int indice) {
        if (indice >= 0) {
            if (indice < indice_fim) {
                for (int i = indice; i < indice_fim - 1; i++) {
                    array[i] = array[i + 1];
                }
                indice_fim--;
            }
        }
        
    }

    @Override
    public void removeInicio() {
    if (indice_fim > 0) {
         for (int i = 0; i < indice_fim - 1; i++) {
             array[i] = array[i + 1];
            }
         indice_fim--;
        }
       
    }

    @Override
    public void removeFim() {
        if (indice_fim > 0) {
            indice_fim--;
        }
    }     
}