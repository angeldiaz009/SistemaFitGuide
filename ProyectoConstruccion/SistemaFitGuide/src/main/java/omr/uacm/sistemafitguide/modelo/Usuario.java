package omr.uacm.sistemafitguide.modelo;

public class Usuario {
    private int id;
    private String nombre;
    private String contrasena;
    private String fechaNacimiento;

    public Usuario(int id, String nombre, String contrasena, String fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() { return nombre; }
    public String getContrasena() { return contrasena; }
    public String getFechaNacimiento() { return fechaNacimiento; }
}