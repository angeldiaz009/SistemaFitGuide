package omr.uacm.sistemafitguide.modelo;

public class Ejercicio {
    private int id;
    private String nombre;
    private String descripcion;
    private String musculo;
    private String nivel;

    public Ejercicio(int id, String nombre, String descripcion, String musculo, String nivel) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.musculo = musculo;
        this.nivel = nivel;
    }

    // Getters para que la interfaz gráfica pueda leer los datos
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getMusculo() { return musculo; }
    public String getNivel() { return nivel; }
}