package FinalSantiagoCárdenasFranco.Oftamología;

public class PacienteApto extends Paciente implements Operable{
    public PacienteApto(String nombre, int edad, boolean necesitaCirugia) {
        super(nombre, edad, necesitaCirugia);
    }

    @Override
    public void operar() {
        this.setNecesitaCirugia(false);
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + ", edad: " + getEdad() + ", necesita cirugia: " + isNecesitaCirugia() + ". Es un pacienteApto";
    }

}
