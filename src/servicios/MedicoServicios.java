package servicios;




import dao.MedicoDAO;
import entidad.Medico;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class MedicoServicios {
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Medico medico = new Medico();
    MedicoDAO medicoDao = new MedicoDAO();
        
    public Medico cargarMedico(){
      
        System.out.println("Ingrese el nombre del médico");
        medico.setNombre(leer.next());
        System.out.println("Ingrese el apellido del médico");
        medico.setApellido(leer.next());
        System.out.println("Ingrese la especialidad del médico");
        medico.setEspecialidad(leer.next());
 medicoDao.crearMedico(medico);
        
        Set<Medico> medicos= new HashSet<>();      
       medicos.add(medico);     
        System.out.println("Médico cargado con éxito");
       return medico;              
    }
}
