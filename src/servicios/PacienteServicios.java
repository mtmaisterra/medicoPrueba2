
package servicios;



import dao.PacienteDAO;
import entidad.Paciente;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class PacienteServicios {
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
     PacienteDAO pacienteDao = new PacienteDAO();
     Paciente paciente = new Paciente();
     
     public Paciente cargarPaciente() {        
               
        System.out.println("Ingrese el número de documento del paciente");
        paciente.setDocumento(leer.nextLong());
        System.out.println("Ingrese el nombre del paciente");
        paciente.setNombre(leer.next());
        System.out.println("Ingrese el apellido del paciente");
        paciente.setApellido(leer.next());
        System.out.println("Ingresa el año de nacimiento");
        int año = leer.nextInt();
        System.out.println("Ingrese el mes de nacimiento");
        int mes = leer.nextInt();
        System.out.println("Ingrese el día del cumpleaños");
        int diaN = leer.nextInt();
        Date fechaNac = new Date(año - 1900, mes - 1, diaN);
        paciente.setFechaNac(fechaNac);
        System.out.println("Ingrese la edad del paciente");
        paciente.setEdad(leer.nextInt());
        System.out.println("Tiene obra social 1-Si, 2-No");
        int opcion = leer.nextInt();
        if (opcion == 1) {
            System.out.println("¿Cuál es?");
            paciente.setObraSocial(leer.next());
        }else{
           paciente.setObraSocial("No posee obra social");
        }
        System.out.println("Indique la patología del paciente");
        paciente.setPatologia(leer.next());
        System.out.println("Ingrese la medicación recetada anteriormente");
       paciente.setMedicacion(leer.next());
        pacienteDao.crear(paciente);
        
        Set<Paciente> pacientes= new HashSet<>();      
       pacientes.add(paciente);       
     
         System.out.println("Paciente cargado con éxito");
       return paciente;
     }
}
