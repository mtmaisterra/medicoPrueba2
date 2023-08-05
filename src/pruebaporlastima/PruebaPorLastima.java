
package pruebaporlastima;

import dao.MedicoDAO;
import dao.PacienteDAO;
import dao.TurnoDAO;
import entidad.Medico;
import entidad.Paciente;
import entidad.Turno;
import java.util.Scanner;
import servicios.MedicoServicios;
import servicios.PacienteServicios;
import servicios.TurnoServicios;


public class PruebaPorLastima {

    public static void main(String[] args) {
        // TODO code application logic here
        
          Scanner leer = new Scanner(System.in).useDelimiter("\n");
        boolean menu = true;
        
      MedicoServicios medicoS = new MedicoServicios();
      PacienteServicios pacienteS = new PacienteServicios();
      TurnoServicios turnoS = new TurnoServicios();
      Turno turno = new Turno();
      Medico medico = new Medico();
      Paciente paciente = new Paciente();
      TurnoDAO turnoD = new TurnoDAO();
      PacienteDAO pacienteD = new PacienteDAO();
      MedicoDAO medicoD = new MedicoDAO();
     
      do{
          System.out.println("'\n");
        System.out.println("     Bienvenido al Consultorio M&M     ");
        System.out.println("***************************************");
        System.out.println("Elija una opción del Menú");
        System.out.println("1- Ingresar nuevo médico");
        System.out.println("2- Ingresar un nuevo paciente");
        System.out.println("3- Sacar un turno");
        System.out.println("4- Consultar médicos por especilidad");
        System.out.println("5- Consultar médicos por apellido");
        System.out.println("6- Consultar pacientes por documento");
        System.out.println("7- Consultar pacientes por patologia");
        System.out.println("8- Consultar  turnos por día");
        System.out.println("9- Consultar turnos por médico");
        System.out.println("10- Dar de baja un paciente");
        System.out.println("11- Dar de baja un médico");
        System.out.println("12- Dar de baja un turno");
        System.out.println("13- Salir");
        System.out.println("****************************************");
          System.out.println("\n");
        int opcion = leer.nextInt();
        
          switch (opcion) {
              case 1:
                 medicoS.cargarMedico();
                  break;
              case 2:
                  pacienteS.cargarPaciente();
                  break;
              case 3:
                  turnoD.crear(turno);
                  break;
              case 4:                                   
                  medicoD.buscarPorEspecialidad();
                  break;
              case 5:                  
                  medicoD.buscarPorApellido();
                  break;
              case 6:
                  pacienteD.listarPacientesPorDocumento();
                  break;
              case 7:
                  pacienteD.listarPacientesPorPatologia();
                  break;
              case 8:
                 turnoD.listarTurnoPorDia();
                  break;
              case 9:
                  turnoD.listarTurnoPorMedico();
                  break;
              case 10:
                  System.out.println("Ingrese el documento del paciente");
                  pacienteD.borrar(leer.nextLong());
                  break;
              case 11:
                  System.out.println("Ingrese el id del médico");
                  medicoD.borrarMedico(leer.nextLong());
                  break;
              case 12:
                  System.out.println("Ingrese el id a borrar");
                  turnoD.borrar(leer.nextLong());
                  break;
              case 13:
                  menu = false;
                  System.out.println("Gracias por usar nuestro servicio");
                  break;
                default:
                    System.out.println("Opción no reconocida. Por favor, elige una opción del menú.");
          }
         
    }
     while(menu);
                 System.out.println("\n");
          }
    }
    

