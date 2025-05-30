import java.util.*;

public class AtencionIntercalada {

    private Queue<Integer> colaPar;
    private Queue<Integer> colaImpar;
    public AtencionIntercalada() {
        colaPar = new LinkedList<>();
        colaImpar = new LinkedList<>();
    }
    // definir num como par o impar

    public void agregarNumero(int num) {
        if (num % 2 == 0) {
            colaPar.offer(num);
        } else {
            colaImpar.offer(num);
        }
    } 
    //salida de la cola
    public List<Integer> procesarCola() {
        List<Integer> salida = new ArrayList<>();
        boolean turnoPar = true;

        while (!colaPar.isEmpty() || !colaImpar.isEmpty()) {
            if (turnoPar) {
                if (!colaPar.isEmpty()) {
                    salida.add(colaPar.poll());
                } else if (!colaImpar.isEmpty()) {
                    salida.add(colaImpar.poll());
                }
            } else {
                if (!colaImpar.isEmpty()) {
                    salida.add(colaImpar.poll());
                } else if (!colaPar.isEmpty()) {
                    salida.add(colaPar.poll());
                }
            }
            turnoPar = !turnoPar;
        }

        return salida;
    }       

    public static void main(String[] args) {
        AtencionIntercalada atencion = new AtencionIntercalada();
        //entrada de num 
        List<Integer> entrada = Arrays.asList(4,9,2,3,8,7); 
        for (int num : entrada) {
            atencion.agregarNumero(num);
        } 
        
        List<Integer> resultado = atencion.procesarCola();

        System.out.println("Orden de atención intercalada:");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}
    
    