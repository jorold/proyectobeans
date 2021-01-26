package beans;

public class Bean01PrimerEjemplo {

    //aquí van los métodos para dibujar en la página/s
    public String getSaludo() {
        //devolvemos el código que seseamos dibujar
        // por ejemplo devolvemos un título
        return "<h1 style='color:red'>Saludos desde Java Beans</h1>";
    }

    public String getSaludoPersonal(String nombre) {
        return "<h1 style='color:blue'>Bienvenido, " + nombre + "</h1>";
    }
}
