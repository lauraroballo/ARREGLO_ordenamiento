public class AlgoritmosOrdenamiento {

    public static void burbuja(int[] arreglo) {
        int n = arreglo.length;
        boolean intercambio;
        do {
            intercambio = false;
            for (int i = 1; i < n; i++) {
                if (arreglo[i - 1] > arreglo[i]) {
                    // Intercambiar elementos
                    int temp = arreglo[i - 1];
                    arreglo[i - 1] = arreglo[i];
                    arreglo[i] = temp;
                    intercambio = true;
                }
            }
            n--;
        } while (intercambio);
    }

    public static void insercion(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 1; i < n; i++) {
            int clave = arreglo[i];
            int j = i - 1;
            while (j >= 0 && arreglo[j] > clave) {
                arreglo[j + 1] = arreglo[j];
                j = j - 1;
            }
            arreglo[j + 1] = clave;
        }
    }

    public static void seleccion(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            // Intercambiar elementos
            int temp = arreglo[indiceMinimo];
            arreglo[indiceMinimo] = arreglo[i];
            arreglo[i] = temp;
        }
    }

    public static void shell(int[] arreglo) {
        int n = arreglo.length;
        for (int intervalo = n / 2; intervalo > 0; intervalo /= 2) {
            for (int i = intervalo; i < n; i++) {
                int temp = arreglo[i];
                int j;
                for (j = i; j >= intervalo && arreglo[j - intervalo] > temp; j -= intervalo) {
                    arreglo[j] = arreglo[j - intervalo];
                }
                arreglo[j] = temp;
            }
        }
    }

    public static void heapSort(int[] arreglo) {
        int n = arreglo.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            construirHeap(arreglo, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            // Intercambiar el primer y último elemento
            int temp = arreglo[0];
            arreglo[0] = arreglo[i];
            arreglo[i] = temp;

            construirHeap(arreglo, i, 0);
        }
    }

    private static void construirHeap(int[] arreglo, int n, int i) {
        int mayor = i;
        int izquierda = 2 * i + 1;
        int derecha = 2 * i + 2;

        if (izquierda < n && arreglo[izquierda] > arreglo[mayor]) {
            mayor = izquierda;
        }

        if (derecha < n && arreglo[derecha] > arreglo[mayor]) {
            mayor = derecha;
        }

        if (mayor != i) {
            // Intercambiar elementos
            int temp = arreglo[i];
            arreglo[i] = arreglo[mayor];
            arreglo[mayor] = temp;

            construirHeap(arreglo, n, mayor);
        }
    }

    public static void quickSort(int[] arreglo, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indiceParticion = particion(arreglo, izquierda, derecha);
            quickSort(arreglo, izquierda, indiceParticion - 1);
            quickSort(arreglo, indiceParticion + 1, derecha);
        }
    }

    private static int particion(int[] arreglo, int izquierda, int derecha) {
        int pivote = arreglo[derecha];
        int i = izquierda - 1;

        for (int j = izquierda; j < derecha; j++) {
            if (arreglo[j] <= pivote) {
                i++;
                // Intercambiar elementos
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }

        // Intercambiar el pivote con el elemento en la posición correcta
        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[derecha];
        arreglo[derecha] = temp;

        return i + 1;
    }
}
