import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean condicion = true;

        do {
            System.out.println("\n>>> MENU ");
            System.out.println("  1. Crear estudiante");
            System.out.println("  3. Salir");
            System.out.print(" >> Elige una opcion > ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("  > Introduce los datos del estudiante ");
                    System.out.print("   > Introduce el nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("   > Introduce el primer apellido: ");
                    String apellido1 = sc.nextLine();
                    System.out.print("   > Introduce el segundo apellido: ");
                    String apellido2 = sc.nextLine();
                    System.out.print("   > Introduce la edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    System.out.print("   > Introduce la nota media del estudiante: ");
                    String notaStr = sc.nextLine().replace(",", ".");
                    double nota = Double.parseDouble(notaStr);

                    Estudiante p1 = new Estudiante(nombre, apellido1, apellido2, edad, nota);

                    System.out.println("\n >> Datos del o la estudiante <<");
                    System.out.printf(
                            "Datos del Estudiante > %s %s %s, tiene %d años, su nota media es de %.2f. %n", p1.getNombre(), p1.getApellido1(), p1.getApellido2(), p1.getEdad(), p1.getNota()
                    );
                    break;

                case 2:
                    System.out.println("Opción 2 seleccionada");
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    condicion = false;
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        } while (condicion);

        sc.close();
    }
}
