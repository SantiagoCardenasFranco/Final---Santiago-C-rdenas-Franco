package FinalSantiagoCárdenasFranco.AppOftamología;

import FinalSantiagoCárdenasFranco.Oftamología.Oftamologo;

public class AppOftamología {
    public static void main(String[] args) {
        Oftamologo oftamologo = new Oftamologo();
        System.out.println(oftamologo.revisarPaciente("MARCO", 25));
        System.out.println(oftamologo.revisarPaciente("Arquimides", 50));
        System.out.println(oftamologo.revisarPaciente("Santiago", 18));
        System.out.println(oftamologo.revisarPaciente("Juan", 18));
        System.out.println(oftamologo.revisarPaciente("Zoe", 45));

        System.out.println("\n");
        System.out.println("Lista de Aptos para lo operación");
        System.out.println(oftamologo.getPacienteAOperar());

        System.out.println("\n");
        System.out.println("Quien va a operarse y quien no");
        oftamologo.operarPaciente();
    }
}
