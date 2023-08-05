package dao;


import entidad.Paciente;
import java.util.List;
import java.util.Scanner;

public class PacienteDAO extends DAO{

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    public PacienteDAO() {
        super();
    }

    public void crear(Paciente paciente) {
        super.create(paciente);
    }

    public void editar(Paciente paciente) {
        super.update(paciente);
    }

    public void borrar(Long documento) {
        Paciente paciente = em.find(Paciente.class, documento);
        if (paciente == null) {
            System.out.println("No existe el paciente con ese documento");
        } else {
            super.delete(paciente);
            System.out.println("El paciente se eliminó con éxito");
        }
    }   

    private Paciente findId(Long documento) {
        super.conect();
        Paciente paciente = em.find(Paciente.class, documento);
        super.disconect();
        return paciente;
    }    

     
     public Long cantidadPacientes(){
         super.conect();         
         Long cantidad = (Long) em.createNativeQuery("SELECT COUNT(*) FROM Pacientes").getSingleResult();
    super.disconect();
    return cantidad;
         /*El (Long) es un casteo que indica que se obliga a dar un resultado*/
     }
     
      public List<Paciente> listarPacientesPorDocumento() {
        super.conect();
          System.out.println("Ingrese el documento para buscar");
          Long documento = leer.nextLong();
        List<Paciente> pacientes = em.createNamedQuery("SELECT p FROM Paciente p.documento =:documento", Paciente.class).getResultList();
        super.disconect();
        return pacientes;
        /*NamedQuery permite ver una consulta ordenada*/
        
        
    }
      public List<Paciente> listarPacientesPorPatologia() {
        super.conect();
          System.out.println("Ingrese la patologia a buscar");
          String patologia = leer.next();
        List<Paciente> pacientes = em.createNamedQuery("SELECT p FROM Paciente p.patologia =:patologia", Paciente.class).getResultList();
        super.disconect();
        return pacientes;
        /*NamedQuery permite ver una consulta ordenada*/
        
        
    }
}
