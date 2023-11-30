import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LIstaDoble listaDoble = new LIstaDoble();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Insertar Ordenado");
            System.out.println("2. Eliminar Valor");
            System.out.println("3. Modificar Valor");
            System.out.println("4. Mostrar Lista");
            System.out.println("5. Mostrar si Existe Valor");
            System.out.println("6. Eliminar Lista");
            System.out.println("7. Créditos");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opción: ");
            opcion = scanner.nextInt();

            scanner.nextLine();

            switch (opcion) {
                case 1:
                    listaDoble.insertarOrdenado();
                    break;
                case 2:
                    System.out.print("Ingrese el valor a eliminar: ");
                    String valorEliminar = scanner.nextLine();
                    listaDoble.Eliminar(valorEliminar);
                    break;
                case 3:
                    listaDoble.Modificar();
                    break;
                case 4:
                    listaDoble.MostrarLD();
                    break;
                case 5:
                    listaDoble.BucarValorExistente();
                    break;
                case 6:
                    listaDoble.EliminarLista(listaDoble.P);
                    listaDoble.P = null;
                    listaDoble.F = null;
                    System.out.println("Lista Eliminada");
                    break;
                case 7:
                    System.out.println("Créditos:");
                    System.out.println("Materia: Estructura de datos");
                    System.out.println("Matricula: 22170016");
                    System.out.println("Nombre: Jesus Aranda Rodriguez");
                    System.out.println("Matricula: 22170038");
                    System.out.println("Nombre: Ricardo Ramon Sanchez Gonzalez");
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }
}
