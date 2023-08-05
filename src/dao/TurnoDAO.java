package dao;


import entidad.Turno;
import java.util.List;
import java.util.Scanner;


public class TurnoDAO extends DAO {
    Scanner leer=new Scanner(System.in);

    public static Object listarTurnosPorDia(String dia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public TurnoDAO() {
        super();
    }

    public void crear(Turno turno) {
        super.create(turno);
    }

    public void editar(Turno turno) {
        super.update(turno);
    }

    public void borrar(Long id) {
         Turno turno = em.find(Turno.class, id);
        if (turno == null) {
            System.out.println("No existe el turno con ese id");
        } else {
            super.delete(turno);
            System.out.println("El turno se eliminó con éxito");
        }
    }   

    private Turno findId(Long id) {
        super.conect();
        Turno turno = em.find(Turno.class, id);
        super.disconect();
        return turno;
    }
    
     public List<Turno> listarTurnoPorDia() {
        super.conect();
         System.out.println("Ingrese el día a buscar");
         String dia = leer.next();
        List<Turno> turnos = em.createQuery("SELECT t FROM Turno t WHERE t.dia =:dia", Turno.class).setParameter("dia", dia.toString()).getResultList();
        super.disconect();
        return turnos;
        /*NamedQuery permite ver una consulta ordenada*/
    }
     public List<Turno> listarTurnoPorMedico() {
        super.conect();
        String medico = leer.next();
        List<Turno> turnos = em.createQuery("SELECT t FROM Turno t WHERE t.medico =:medico", Turno.class).getResultList();
        super.disconect();
        return turnos;
        /*NamedQuery permite ver una consulta ordenada*/
    }
     
     public List <Turno> listarTurnos(){
         super.conect();
         List<Turno> turnos = em.createNamedQuery("Turno.findAll").getResultList();
         super.disconect();
         return turnos;
     }
    public Long cantidadTurnos(){
         super.conect();         
         Long cantidad = (Long) em.createNativeQuery("SELECT COUNT(*) FROM Turnos").getSingleResult();
    super.disconect();
    return cantidad;
         /*El (Long) es un casteo que indica que se obliga a dar un resultado*/
     }
}
