import java.util.Scanner;

public class LIstaDoble {
    Nodo P= null;
    Nodo F= null;
    private Scanner Leer = new Scanner(System.in);
    public LIstaDoble() {
        this.P = null;
        this.F = null;
    }

    public void MostrarLD() {
        if (P == null) {
            System.out.println("La lista está vacía");
        }else{
            System.out.println("Mostrar Lista Inicio-Final: Si/No");
            String text = Leer.nextLine();
            if (text.equalsIgnoreCase("si")) {
                Mostrar(P);
            } else if (text.equalsIgnoreCase("no")) {
                Mostrar(F);
            }
        }

    }
    public void Mostrar(Nodo N) {
         if (N == P) {
            do {
                System.out.println(N.getDato());
                N = N.getSiguiente();
            } while (N != null);
        } else if (N == F) {
            do {
                System.out.println(N.getDato());
                N = N.getAnterior();
            } while (N != null);
        }
    }
public void BucarValorExistente(){
        System.out.println("Inserta Valor a Buscar:");
        String text = Leer.nextLine();
        Nodo R = Buscar(text);
        if (R == null) {
            System.out.println("El valor no existe en la lista");
        } else {
            System.out.println("El valor existe en la lista");
        }
}
    public Nodo Buscar(String Valor){
    if (P == null){return null;}
    else if ((Character.toLowerCase(Valor.charAt(0)))<='n') {
        Nodo Q = P;
        while (Q != null) {
            if (Valor.equals(Q.getDato())) {
                return Q;
            }
            Q = Q.getSiguiente();
        }
    }
    else if ((Character.toLowerCase(Valor.charAt(0)))>'n'){
        Nodo Q = F;
        while (Q != null){
            if (Valor.equals(Q.getDato())){
                return Q;
            }
            Q = Q.getAnterior();
        }
    }
    return null;
}
public void insertarAntesDe(String Valor, String ValorInsertar) {
    Nodo R = Buscar(Valor);
    Nodo Q = new Nodo();
    Q.setDato(ValorInsertar);
    Q.setSiguiente(R);
    if (R.getAnterior() != null) {
        R.getAnterior().setSiguiente(Q);
        Q.setAnterior(R.getAnterior());
    } else {
        P = Q;
    }
    R.setAnterior(Q);
}
public void insertarDespuesDe(String Valor, String ValorInsertar) {
    Nodo R = Buscar(Valor);
    Nodo Q = new Nodo();
    Q.setDato(ValorInsertar);
    Q.setAnterior(R);
    if (R.getSiguiente() != null) {
        R.getSiguiente().setAnterior(Q);
        Q.setSiguiente(R.getSiguiente());
    } else {
        F = Q;
    }
    R.setSiguiente(Q);
}
public void insertarOrdenado(){
        System.out.println("Insertar Valor");
        String text = Leer.nextLine();
        Nodo Q = new Nodo();
        if (P==null){
                Q.setDato(text);
                P = Q;
                F = Q;
        }
        else {
            if((Character.toLowerCase(text.charAt(0)))<='n') {
                Q=P;
                while (Q!=null){
                    if (text.compareToIgnoreCase(Q.getDato())<=0){
                        insertarAntesDe(Q.getDato(),text);
                        return;
                    }
                    Q=Q.getSiguiente();
                }
            }else if ((Character.toLowerCase(text.charAt(0)))>'n'){
                Q=F;
                while (Q!=null){
                    if (text.compareToIgnoreCase(Q.getDato())>=0){
                        insertarDespuesDe(Q.getDato(),text);
                        return;
                    }
                    Q=Q.getAnterior();
                }
            }
            insertarDespuesDe(F.getDato(),text);
        }
}
    public Nodo Eliminar(String Valor) {
        Nodo R = Buscar(Valor);
        if (R == null) {
            return null;
        } else {
            if (P == F) {
                P = null;
            } else {
                if (R == P) {
                    P = P.getSiguiente();
                    if (P != null) {
                        P.setAnterior(null);
                    }
                } else {
                    if (R == F) {
                        F = F.getAnterior();
                        if (F != null) {
                            F.setSiguiente(null);
                        }
                    } else {
                        R.getAnterior().setSiguiente(R.getSiguiente());
                        R.getSiguiente().setAnterior(R.getAnterior());
                    }
                }
            }
            R.setAnterior(null);
            R.setSiguiente(null);
            return R;
        }
    }
    public void Modificar() {
        if (P == null) {
            System.out.println("La lista está vacía");
        } else {
            System.out.println("Insertar Nuevo Valor:");
            String text = Leer.nextLine();
            Nodo R = Eliminar(text);
            if (R == null) {
                System.out.println("El valor no existe en la lista");
            } else {
                insertarOrdenado();
            }
        }
    }

    public void EliminarLista(Nodo A) {
        if (A != null) {
            EliminarLista(A.getSiguiente());
            A.setAnterior(null);
            A.setSiguiente(null);
        }
    }

}
