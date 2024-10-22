public class QuickSortBenchmark {
    
    public static int particao(int[] vetor, int esquerda, int direita) {
        int meio = (int) (esquerda + direita) / 2; // Pega o index do meio do vetor
        int pivo = vetor[meio]; // Pega o valor que está nesse índice para ser o pivo
        int i  = esquerda - 1; // Posição do ponteiro inicial
        int j = direita + 1; // Posição do ponteiro final

        while(true) {
            do {
                i++;
            } while(vetor[i] < pivo); // Quando o vetor na posição i for maior que o pivo ele trava
            
            do {
                j--;
            } while(vetor[j] > pivo); // Quando o vetor na posição j for menor que o pivo ele trava 

            if(i >= j) { // Se for verdadeiro, já foram separados os valores maiores e menores que o pivo
                return j; // Posição do pivo atual 
            }

            int aux = vetor[i]; // Aqui faz a troca dos elementos que foram travados 
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }
    }

    public static void quickSort(int[] vetor, int esquerda, int direita) {
        if(esquerda < direita) {
            int pivo = particao(vetor, esquerda, direita); // Acontece até que o da esquerda seja maior que o da direita
            quickSort(vetor, esquerda, pivo); // Ordenar à esquerda do pivo
            quickSort(vetor, pivo + 1, direita); // Ordenar à direita do pivo
        }
    }

    public static void main(String[] args) {
        int[] vetor = {3, 2, 8, 1, 5};

        // Medir tempo de execução
        long startTime = System.nanoTime();

        // Medir uso de memória antes da execução
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Chama o garbage collector para ter uma medição mais precisa
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        quickSort(vetor, 0, vetor.length - 1); // Chama o quicksort

        // Medir uso de memória após a execução
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();

        // Medir tempo de execução
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        // Exibir os elementos ordenados
        for (int i = 0; i < vetor.length - 1; i++) {
            System.out.print(vetor[i] + ",");
        }
        System.out.println(vetor[vetor.length - 1]);

        // Converter o tempo de execução para segundos
        double executionTimeSeconds = executionTime / 1_000_000_000.0;

        // Converter o uso de memória para megabytes
        double memoryUsedBeforeMB = usedMemoryBefore / (1024.0 * 1024.0);
        double memoryUsedAfterMB = usedMemoryAfter / (1024.0 * 1024.0);

        // Exibir tempo de execução em segundos
        System.out.println("Tempo de execução: " + executionTimeSeconds + " segundos");

        // Exibir uso de memória em megabytes
        System.out.println("Memória usada antes da execução: " + memoryUsedBeforeMB + " MB");
        System.out.println("Memória usada depois da execução: " + memoryUsedAfterMB + " MB");
    }
}
