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
            try {
                System.out.print("\n >> Elige una opcion > ");
                opcion = Integer.parseInt(sc.nextLine());  // Intentamos leer un número

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
                        System.out.println("\n>>> Opción no válida. Intenta de nuevo.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("\n>>> Error: Debes introducir un número válido. Intenta de nuevo.");
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
        while (true) {
            try {
                String nombre;
                String apellido1;
                String apellido2;
                int edad;
                double nota;


                System.out.println("  > Introduce los datos del estudiante ");

                do {
                    System.out.print("   > Introduce el nombre: ");
                    nombre = sc.nextLine().trim();
                    if (nombre.isEmpty()) {
                        System.out.println("     * El nombre no puede estar vacío. Intenta de nuevo.");
                    }
                } while (nombre.isEmpty());

                do {
                    System.out.print("   > Introduce el primer apellido: ");
                    apellido1 = sc.nextLine().trim();
                    if (apellido1.isEmpty()) {
                        System.out.println("     * El primer apellido no puede estar vacío. Intenta de nuevo.");
                    }
                } while (apellido1.isEmpty());

                do {
                    System.out.print("   > Introduce el segundo apellido: ");
                    apellido2 = sc.nextLine().trim();
                    if (apellido2.isEmpty()) {
                        System.out.println("     * El segundo apellido no puede estar vacío. Intenta de nuevo.");
                    }
                } while (apellido2.isEmpty());

                do {
                    System.out.print("   > Introduce la edad: ");
                    edad = Integer.parseInt(sc.nextLine());
                    if (edad <= 0) {
                        System.out.println("     * La edad debe ser mayor que 0. Intenta de nuevo.");
                    }
                } while (edad <= 0);

                do {
                    System.out.print("   > Introduce la nota media del estudiante: ");
                    String notaStr = sc.nextLine().replace(",", ".");
                    nota = Double.parseDouble(notaStr);
                    if (nota < 0 || nota > 10) {
                        System.out.println("     * La nota debe estar entre 0 y 10. Intenta de nuevo.");
                    }
                } while (nota < 0 || nota > 10);

                Estudiante p1 = new Estudiante(nombre, apellido1, apellido2, edad, nota);
                listaEstudiantes.add(p1);

                System.out.printf(
                        "\n >> Datos del o la estudiante: %s %s %s, %d años, nota media: %.2f.%n",
                        p1.getNombre(), p1.getApellido1(), p1.getApellido2(), p1.getEdad(), p1.getNota()
                );

                break;

            } catch (NumberFormatException e) {
                System.out.println("Error: Debes introducir un número válido para la edad y la nota. Intenta de nuevo.\n");
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage() + ". Intenta de nuevo.\n");
            }
        }
    }

    public static void listarEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        try {
            if (listaEstudiantes.isEmpty()) {
                System.out.println("\n>> No hay estudiantes registrados");
            } else {
                int contador = 0;
                for (Estudiante i : listaEstudiantes) {
                    ++contador;
                    System.out.printf(
                            "  > Estudiante n%d: %s %s %s, %d años, nota media: %.2f.%n",
                            contador,
                            i.getNombre() != null ? i.getNombre() : "N/A",
                            i.getApellido1() != null ? i.getApellido1() : "N/A",
                            i.getApellido2() != null ? i.getApellido2() : "N/A",
                            i.getEdad(),
                            i.getNota()
                    );
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al listar los estudiantes: " + e.getMessage());
        }
    }

    public static void buscarEstudiante(ArrayList<Estudiante> listaEstudiantes, Scanner sc) {
        System.out.print("  >> Introduce el nombre: ");
        String buscarNombre = sc.nextLine().trim();
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


