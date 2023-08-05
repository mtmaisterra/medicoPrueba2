package entidad;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@NamedQuery(
        name="Paciente.listarTodos",
        query="SELECT a FROM Paciente a"
)

@Entity
@Table(name="Pacientes")
public class Paciente implements Serializable {

    @Id
    private Long documento;
    @Column(name = "Nombre", length = 20, nullable = false)
    private String nombre;
    @Column(name = "Apellido", length = 20, nullable = false)
    private String apellido;
    @Column(name="Fecha_Nacimiento", length = 12, nullable= false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNac;
    @Column(name = "Edad", length = 5, nullable = false)
        private int edad;
    @Column(name = "Obra_Social", length = 20, nullable = false)
    private String obraSocial;
    @Column(name = "Patología", length = 20, nullable = false)
    private String patologia;
    @Column(name = "Medicación", length = 20, nullable = false)
    private String medicacion;
    
@OneToMany
@JoinTable(name="Paciente",
        joinColumns=@JoinColumn(name="id"),
 inverseJoinColumns=@JoinColumn(name="documento"))
    private Set<Turno> turnos;

    public Paciente() {
    }

    public Paciente(Long documento, String nombre, String apellido, Date fechaNac,int edad, String obraSocial, String patologia, String medicacion, Set<Turno> turnos) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
     this.fechaNac = fechaNac;
        this.edad = edad;
        this.obraSocial = obraSocial;
        this.patologia = patologia;
        this.medicacion = medicacion;
        this.turnos = turnos;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    

    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public String getMedicacion() {
        return medicacion;
    }

    public void setMedicacion(String medicacion) {
        this.medicacion = medicacion;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }


    
    
}
