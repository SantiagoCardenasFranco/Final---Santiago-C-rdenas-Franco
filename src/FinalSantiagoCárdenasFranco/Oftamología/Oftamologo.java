package FinalSantiagoCárdenasFranco.Oftamología;

import java.util.ArrayList;
import java.util.List;

public class Oftamologo {
    private String nombre;
    private ArrayList<Paciente> pacientes;

    public Oftamologo() {
        this.pacientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public Paciente revisarPaciente(String nombre, int edad)
    {
        boolean necesitaCirugia;
        if(nombre.toLowerCase().contains("a") && edad < 40)
        {
            //nombre.toLowerCase().contains("a") lo transforma en minuscula y luego hace la operación de contiene
            //El nombre quedará igual como se escribe en main
            //El paciente necesita la cirugía y es apto
            necesitaCirugia = true;
            PacienteApto pacienteApto = new PacienteApto(nombre, edad, necesitaCirugia);
            this.pacientes.add(pacienteApto);
            return pacienteApto;
        }
        else if (nombre.toLowerCase().contains("a") && edad >= 40)
        {
            //El paciente necesita la cirugia, pero no es apto
            necesitaCirugia = true;
            PacienteNoApto pacienteNoApto = new PacienteNoApto(nombre, edad, necesitaCirugia);
            this.pacientes.add(pacienteNoApto);
            return pacienteNoApto;
        }
        else
        {
            //El paciente no la necesita y no es apto
            necesitaCirugia = false;
            PacienteNoApto pacienteNoApto = new PacienteNoApto(nombre, edad, necesitaCirugia);
            this.pacientes.add(pacienteNoApto);
            return pacienteNoApto;
        }
    }

    public void operarPaciente()
    {
        getPacientes().forEach(paciente -> {
            boolean existente = pacientes.stream().anyMatch(p -> p.isNecesitaCirugia() == paciente.isNecesitaCirugia());
            boolean contiene = paciente.getNombre().toLowerCase().contains("a");
            if(paciente instanceof PacienteApto && existente && paciente.getEdad() < 40 && contiene == true)
            {
                ((PacienteApto) paciente).operar();
                System.out.println("El paciente " + paciente.getNombre() + " con la edad de " + paciente.getEdad() + " años, ha sido operado ");
                System.out.println(paciente);
            }
            else if(paciente.getEdad() >= 40 && contiene == true){
                System.out.println("El paciente " + paciente.getNombre() + " con la edad de " + paciente.getEdad() + " años, no cumple con la edad requerida");
                System.out.println(paciente);
            }
            else if(paciente.getEdad() < 40 && !contiene)
            {
                System.out.println("El paciente " + paciente.getNombre() + " con la edad de " + paciente.getEdad() + " años, no puedo operarse pues en su nombre no contiene la 'a'");
                System.out.println(paciente);
            }
            else if(paciente.getEdad() >= 40 && contiene == false)
            {
                System.out.println("El paciente " + paciente.getNombre() + " con la edad de " + paciente.getEdad() + " años, no puedo operarse pues en su nombre no contiene la 'a', y su edad tampoco corresponde");
                System.out.println(paciente);
            }
        });
    }
    //En este métdodo lo que hace es que lo que son aptos se operan y ya no necesitan la cirugía y se vuelve false

    public List<PacienteApto> getPacienteAOperar ()
    {
        List<PacienteApto> pacienteAptos = new ArrayList<>();
        getPacientes().forEach(paciente -> {
            boolean existente1 = pacientes.stream().anyMatch(Paciente::isNecesitaCirugia);
            if(paciente instanceof PacienteApto && existente1 == true)
            {
                pacienteAptos.add((PacienteApto) paciente);
            }
        });
        //Recorre la lista que ya teniamos y con ayuda del filter y eese lambda filtra solo a los pacientes aptos
        //los agrega a otra lista y este método retorna esa lista que va a estar los pacientes
        return pacienteAptos;
    }
}