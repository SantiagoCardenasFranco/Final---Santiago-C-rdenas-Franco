package FinalSantiagoCárdenasFranco.Oftamología;

public abstract class Paciente {
    private String nombre;
    private int edad;
    private boolean necesitaCirugia;

    public Paciente(String nombre, int edad, boolean necesitaCirugia) {
        this.nombre = nombre;
        this.edad = edad;
        this.necesitaCirugia = necesitaCirugia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isNecesitaCirugia() {
        return necesitaCirugia;
    }

    public void setNecesitaCirugia(boolean necesitaCirugia) {
        this.necesitaCirugia = necesitaCirugia;
    }
}
