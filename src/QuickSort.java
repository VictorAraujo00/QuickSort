public class QuickSort{
    
    public static int particao(int[] vetor, int esquerda, int direita){
        int meio = (int) (esquerda + direita)/2; //Pega o index do meio do vetor
        int pivo = vetor[meio]; //Pega o valor que esta nesse indice para ser o pivo
        int i  = esquerda - 1; //Posição do ponteiro inicial
        int j = direita + 1; //Posição do ponteiro final

        while(true){
            do{
                i++;
            }while(vetor[i] < pivo); //Quando o vetor na posição i for maior que o pivo ele trava
            
            do{
                j--;
            }while(vetor[j] > pivo); //Quando o vetor na posição j for menor que o pivo ele trava 

            if(i >= j){ //Se for verdadeiro quer dizer que ja foram separados os valores maiores e menores que o pivo
                return j; //Posição do pivo atual 
            }

            int aux = vetor[i]; //Aqui faz a troca dos elementos que foram travados 
            vetor[i] = vetor[j];
            vetor[j] = aux;

        }
    }

    public static void quickSort(int [] vetor, int esquerda, int direita){//Procesimento recursivo 

        if(esquerda < direita){ //Se o valor da esqueda do subArray for menor que o valor do subArray a direta é porque ainda precisa ordenar o subArray verifica se há mais de um elemento no subarray que está sendo considerado. Se a condição for verdadeira, significa que ainda há elementos a serem ordenados.
            int pivo = particao(vetor, esquerda, direita); //Acontece até que o da esquerda seja maior que o da direita
            quickSort(vetor, esquerda, pivo); //Ordenar a esquerda do pivo
            quickSort(vetor, pivo + 1, direita);//Ordenar a direita do pivo 
        }
    }

     public static void main(String[] args) {
        
        int [] vetor = {3,2,8,1,5};

        quickSort(vetor, 0, vetor.length - 1); //Chama o quicksort passando como parâmentro o vetor, o ponteiro de esquerda e direita

        for(int i = 0; i < vetor.length - 1; i++){
            System.out.print(vetor[i] + ",");
        }
        System.out.println(vetor[4]);

    }


}