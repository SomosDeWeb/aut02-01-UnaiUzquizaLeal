import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean condicion = true;
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();


        do {
            menu();
            System.out.print("\n >> Elige una opcion > ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    crearEstudiante(listaEstudiantes, sc);
                    break;
                case 2:
                    listarEstudiantes(listaEstudiantes);
                    break;
                case 3:
                    buscarEstudiante(listaEstudiantes, sc);
                    break;
                case 4:
                    calcularMedia(listaEstudiantes);
                    break;
                case 5:
                    mayorNota(listaEstudiantes, sc);
                    break;
                case 6:
                    System.out.println("\n>>> Saliendo del programa...");
                    condicion = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        } while (condicion);

        sc.close();
    }
    public static void menu() {
        System.out.println("\n>>> MENU ");
        System.out.println("  1. Crear estudiante");
        System.out.println("  2. Listar todos los estudiantes");
        System.out.println("  3. Buscar estudiante por su nombre");
        System.out.println("  4. Calcular la media de todas las notas");
        System.out.println("  5. Mostrar al estudiante con la mejor calificación");
        System.out.println("  6. Salir");

    }

    public static void crearEstudiante(ArrayList<Estudiante> listaEstudiantes, Scanner sc) {
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
        listaEstudiantes.add(p1);

        System.out.printf(
                "\n >> Datos del o la estudiante <<\nDatos del Estudiante > %s %s %s, tiene %d años, su nota media es de %.2f. %n",
                p1.getNombre(), p1.getApellido1(), p1.getApellido2(), p1.getEdad(), p1.getNota()
        );
    }

    public static void listarEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        if (listaEstudiantes.isEmpty()) {
            System.out.println(" \n>> No hay estudiantes registrados");
        } else {
            int contador = 0;
            for (Estudiante i : listaEstudiantes) {
                ++contador;
                System.out.printf(
                        "  > Estudiante n%d: %s %s %s, %d años, nota media: %.2f.%n",
                        contador, i.getNombre(), i.getApellido1(), i.getApellido2(), i.getEdad(), i.getNota()
                );
            }
        }
    }

    public static void buscarEstudiante(ArrayList<Estudiante> listaEstudiantes, Scanner sc) {
        System.out.print("  >> Introduce el nombre: ");
        String buscarNombre = sc.nextLine();
        boolean encontrado = false;

        for (Estudiante i : listaEstudiantes) {
            if (i.getNombre().equalsIgnoreCase(buscarNombre)) {
                System.out.printf(
                        "   > Estudiante encontrado: %s %s %s, %d años, nota media: %.2f.%n",
                        i.getNombre(), i.getApellido1(), i.getApellido2(), i.getEdad(), i.getNota()
                );
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("\n>>> No se encontró ningún estudiante con ese nombre.");
        }
    }

    public static void calcularMedia(ArrayList<Estudiante> listaEstudiantes) {
        if (listaEstudiantes.isEmpty()) {
            System.out.println("\n>>> No se encontraron datos para calcular la media");
            return;
        }

        double totalNotas = 0;
        for (Estudiante i : listaEstudiantes) {
            totalNotas += i.getNota();
        }

        double mediaNotas = totalNotas / listaEstudiantes.size();
        System.out.printf("   > La nota media de todos los estudiantes es %.2f%n", mediaNotas);
    }

    public static void mayorNota(ArrayList<Estudiante> listaEstudiantes, Scanner sc) {
        if (listaEstudiantes.isEmpty()) {
            System.out.println("\n>>> No se encontraron datos para saber el estudiante con mayor calificación");
        } else {
            ArrayList<Double> listaNotas = new ArrayList<>();
            for (Estudiante i : listaEstudiantes) {
                listaNotas.add(i.getNota());
            }

            double notaMaxima = Collections.max(listaNotas);
            for (Estudiante i : listaEstudiantes) {
                if (i.getNota() == notaMaxima) {
                    System.out.printf(
                            "   > Estudiante con la mayor media es: %s %s %s, %d años, nota media: %.2f.%n",
                            i.getNombre(), i.getApellido1(), i.getApellido2(), i.getEdad(), i.getNota()
                    );
                }
            }
        }
    }

}


