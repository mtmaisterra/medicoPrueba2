package dao;

import entidad.Medico;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class MedicoDAO extends DAO {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public MedicoDAO() {
        super();
    }

    public void crearMedico(Medico medico) {
        super.create(medico);
    }

    public void editarMedico(Medico medico) {
        super.update(medico);
    }

    public void borrarMedico(Long id) {
        //   Medico medico = /findId(id);
        Medico medico = em.find(Medico.class, id);
        if (medico == null) {
            System.out.println("No existe el médico con ese id");
        } else {
            super.delete(medico);
            System.out.println("El médico se eliminó con éxito");
        }
    }

//    private Medico findId(Long id) {
//        super.conect();
//        Medico medico = em.createNamedQuery("Medico.buscarPorId", Medico.class).setParameter("id", id).getSingleResult();
//        super.disconect();
//        return medico;
//    }
    public List<Medico> listarMedicos() {
        super.conect();
        List<Medico> medicos = em.createNamedQuery("Medico.buscarTodos", Medico.class).getResultList();
        super.disconect();
        return medicos;
        /*NamedQuery permite ver una consulta ordenada*/
    }

    public Long cantidadMedicos() {
        super.conect();
        Long cantidad = (Long) em.createNativeQuery("SELECT COUNT(*) FROM Medicos").getSingleResult();
        super.disconect();
        return cantidad;
        /*El (Long) es un casteo que indica que se obliga a dar un resultado*/
    }

    public Medico buscarPorEspecialidad() {
        super.conect();
        System.out.println("Ingrese la especialidad a mostrar");
        String especialidad = leer.next();
        Medico medico = em.createQuery("SELECT  m FROM Medico m WHERE  m.especialidad = :especialidad LIMIT 1",
                Medico.class).setParameter("especialidad", especialidad).getSingleResult();
        super.disconect();
        return medico;
    }

    public Collection<Medico> buscarPorApellido() {
        super.conect();
        System.out.println("Ingrese el apellido del medico");
        String apellido = leer.next();
        Collection<Medico> medico = em.createQuery("SELECT m from Medico m WHERE m.apellido= :apellido").
                setParameter("apellido", apellido).getResultList();
        if (medico.isEmpty()) {
            System.out.println("No existe el médico con ese apellido");

        } else {
            for (Medico medico1 : medico) {
                System.out.println(medico1.toString());
            }
        }
        super.disconect();
        return medico;
    }

}
