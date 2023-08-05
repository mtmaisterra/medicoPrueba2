package servicios;



import dao.TurnoDAO;
import entidad.Turno;
import enums.DiaDeLaSemana;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class TurnoServicios {
    Scanner leer = new Scanner (System.in).useDelimiter("\n");
    
    TurnoDAO turnoDao = new TurnoDAO();
    Turno turno = new Turno();
    
    public void cargarDiaDeTurnos() {

        /* public Turno(DiaDeLaSemana dia, Date horaInicio, Date horaFinal, int cupo, Medico medico, Paciente paciente) */
        Turno TurnoL = new Turno();        
        TurnoL.setDia(DiaDeLaSemana.LUNES);
        TurnoL.setHoraInicio(crearHora(14, 00));
        TurnoL.setHoraFinal(crearHora(22, 00));
        TurnoL.setCupo(15);        
        
        
        Set<Turno> turnos = new HashSet<>();
        turnos.add(TurnoL);
        
        Turno TurnoM = new Turno();        
        TurnoM.setDia(DiaDeLaSemana.MARTES);
        TurnoM.setHoraInicio(crearHora(14, 00));
        TurnoM.setHoraFinal(crearHora(22, 00));
        TurnoM.setCupo(15);        
        turnoDao.crear(TurnoM);
        
        Set<Turno> turno2 = new HashSet<>();
        turnos.add(TurnoM);
        
        Turno TurnoMi = new Turno();        
        TurnoMi.setDia(DiaDeLaSemana.MIERCOLES);
        TurnoMi.setHoraInicio(crearHora(14, 00));
        TurnoMi.setHoraFinal(crearHora(22, 00));
        TurnoMi.setCupo(15);        
        turnoDao.crear(TurnoMi);
        
        Set<Turno> turno3 = new HashSet<>();
        turnos.add(TurnoMi);
        
        Turno TurnoJ = new Turno();        
        TurnoJ.setDia(DiaDeLaSemana.JUEVES);
        TurnoJ.setHoraInicio(crearHora(14, 00));
        TurnoJ.setHoraFinal(crearHora(22, 00));
        TurnoJ.setCupo(15);        
        turnoDao.crear(TurnoJ);
        
        Set<Turno> turno4 = new HashSet<>();
        turnos.add(TurnoJ);
        
        Turno TurnoV = new Turno();        
        TurnoV.setDia(DiaDeLaSemana.VIERNES);
        TurnoV.setHoraInicio(crearHora(14, 00));
        TurnoV.setHoraFinal(crearHora(22, 00));
        TurnoV.setCupo(15);        
        turnoDao.crear(TurnoV);        
        
        Set<Turno> turno5 = new HashSet<>();
        turnos.add(TurnoV);
    }
    private Turno cargarTurno(String dia){
        System.out.println("Ingrese el día que desea ingresar el turno");
       turnoDao.crear(turno);
        System.out.println("Turno guardado");
               return turno;
    }
    
    private Date crearHora(int horas, int minutos) {
        LocalTime hora = LocalTime.of(horas, minutos);
        Date fecha = Date.from(hora.atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant());
        return fecha;        
    }

   public Turno listarTurnoPorDia(String dia){
        Iterable<Turno> turnos = null;
       for (Turno turno : turnos) {
           if(turno.getDia().equalsIgnoreCase(dia)){
               return turno;
           }
       }
   return null;
    }
}
