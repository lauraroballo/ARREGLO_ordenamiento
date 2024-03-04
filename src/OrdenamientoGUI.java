import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OrdenamientoGUI extends JFrame {

    private final JLabel labelNumero;
    private final JTextField textFieldNumero;
    private final JButton buttonAgregar;
    private final JButton buttonGenerarAleatorios;
    private final JButton buttonOrdenar;
    private final JTextArea textAreaResultado;
    private int[] arreglo;

    // Constructor de la interfaz gráfica
    public OrdenamientoGUI() {
        // Configuración de los componentes de la interfaz gráfica
        labelNumero = new JLabel("Número:");
        textFieldNumero = new JTextField(20);
        buttonAgregar = new JButton("Agregar");
        buttonGenerarAleatorios = new JButton("Generar Aleatorios");
        buttonOrdenar = new JButton("Ordenar");
        textAreaResultado = new JTextArea(20, 40);

        // Configuración del contenedor
        setLayout(null);

        // Posicionamiento de componentes
        labelNumero.setBounds(10, 10, 80, 25);
        textFieldNumero.setBounds(100, 10, 160, 25);
        buttonAgregar.setBounds(270, 10, 100, 25);
        buttonGenerarAleatorios.setBounds(10, 40, 160, 25);
        buttonOrdenar.setBounds(180, 40, 120, 25);
        textAreaResultado.setBounds(20, 80, 460, 250);

        // Eventos de botones
        buttonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarNumero();
            }
        });

        buttonGenerarAleatorios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarNumerosAleatorios();
            }
        });

        buttonOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarYMostrar();
            }
        });

        // Añadir componentes al contenedor
        add(labelNumero);
        add(textFieldNumero);
        add(buttonAgregar);
        add(buttonGenerarAleatorios);
        add(buttonOrdenar);
        add(textAreaResultado);

        // Configuración de la ventana
        setTitle("Programa de Ordenamiento");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        System.out.print("Tiempo actual en milisegundos = ");
        System.out.println(System.currentTimeMillis());
        System.out.print("Tiempo actual en nanosegundos = ");
        System.out.println(System.nanoTime());
    }

    private void agregarNumero() {
        String numeroTexto = textFieldNumero.getText();
        if (!numeroTexto.isEmpty()) {
            int numero = Integer.parseInt(numeroTexto);
            if (arreglo == null) {
                arreglo = new int[]{numero};
            } else {
                int[] nuevoArreglo = Arrays.copyOf(arreglo, arreglo.length + 1);
                nuevoArreglo[arreglo.length] = numero;
                arreglo = nuevoArreglo;
            }
            textFieldNumero.setText("");
        }
    }

    private void generarNumerosAleatorios() {
        // Generar N números aleatorios y almacenarlos en el arreglo
        int N = 10000000; // Puedes ajustar la cantidad de números aleatorios que deseas generar
        arreglo = new int[N];

        for (int i = 0; i < N; i++) {
            arreglo[i] = (int) (Math.random() * 100); // Puedes ajustar el rango según tus necesidades
        }

        // Mostrar los números generados en el área de texto
        textAreaResultado.setText("Números generados aleatoriamente: " + Arrays.toString(arreglo));
    }

    private void ordenarYMostrar() {
        if (arreglo != null) {
            // Aplicar algoritmos de ordenamiento
            int[] copiaBurbuja = Arrays.copyOf(arreglo, arreglo.length);
            int[] copiaInsercion = Arrays.copyOf(arreglo, arreglo.length);
            int[] copiaSeleccion = Arrays.copyOf(arreglo, arreglo.length);
            int[] copiaShell = Arrays.copyOf(arreglo, arreglo.length);
            int[] copiaHeapSort = Arrays.copyOf(arreglo, arreglo.length);
            int[] copiaQuickSort = Arrays.copyOf(arreglo, arreglo.length);

            AlgoritmosOrdenamiento.burbuja(copiaBurbuja);
            AlgoritmosOrdenamiento.insercion(copiaInsercion);
            AlgoritmosOrdenamiento.seleccion(copiaSeleccion);
            AlgoritmosOrdenamiento.shell(copiaShell);
            AlgoritmosOrdenamiento.heapSort(copiaHeapSort);
            AlgoritmosOrdenamiento.quickSort(copiaQuickSort, 0, copiaQuickSort.length - 1);

            // Mostrar resultados
            textAreaResultado.setText("Original: " + Arrays.toString(arreglo) + "\n\n"
                    + "Burbuja: " + Arrays.toString(copiaBurbuja) + "\n"
                    + "Inserción: " + Arrays.toString(copiaInsercion) + "\n"
                    + "Selección: " + Arrays.toString(copiaSeleccion) + "\n"
                    + "Shell: " + Arrays.toString(copiaShell) + "\n"
                    + "HeapSort: " + Arrays.toString(copiaHeapSort) + "\n"
                    + "QuickSort: " + Arrays.toString(copiaQuickSort));
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OrdenamientoGUI().setVisible(true);
            }
        });
    }
}
