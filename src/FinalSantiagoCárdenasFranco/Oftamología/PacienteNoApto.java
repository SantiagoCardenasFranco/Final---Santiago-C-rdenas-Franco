package FinalSantiagoCárdenasFranco.Oftamología;

public class PacienteNoApto extends Paciente {
    public PacienteNoApto(String nombre, int edad, boolean necesitaCirugia) {
        super(nombre, edad, necesitaCirugia);
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + ", edad: " + getEdad() + ", necesita cirugia: " + isNecesitaCirugia() + ". Es un pacienteNoApto";
    }
}
