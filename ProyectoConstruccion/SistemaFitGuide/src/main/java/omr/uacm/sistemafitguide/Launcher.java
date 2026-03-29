package omr.uacm.sistemafitguide;

public class Launcher {
    public static void main(String[] args) {
        // Engañamos a la Máquina Virtual llamando a App desde una clase que NO hereda de Application
        App.main(args);
    }
}