public class Estudiante {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    private double nota;

    public Estudiante(String nombre, String apellido1, String apellido2, int edad, double nota) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
        this.nota = nota;
    }

    public String getNombre() {
        return this.nombre;
    }
    public String getApellido1() {
        return this.apellido1;
    }
    public String getApellido2() {
        return this.apellido2;
    }
    public int getEdad() {
        return this.edad;
    }
    public double getNota() {
        return this.nota;
    }
}
