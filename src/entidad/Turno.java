package entidad;



import enums.DiaDeLaSemana;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@NamedQuery(
        name="Turno.listarTodos",
        query="SELECT a FROM Turno a"
)

@Entity
@Table(name="Turnos")
public class Turno implements Serializable {
    @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;  
    @Enumerated(EnumType.STRING)
    private DiaDeLaSemana dia;
    @Column(name="Hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Column(name="Hora_final")
    @Temporal(TemporalType.TIME)
    private Date horaFinal;
    @Column(name="Cupo")
    private int cupo;    
 
    @ManyToOne    
    private Medico medico;
   @ManyToOne
    private Paciente paciente;

    public Turno() {
    }

    public Turno(DiaDeLaSemana dia, Date horaInicio, Date horaFinal, int cupo, Medico medico, Paciente paciente) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.cupo = cupo;
        this.medico = medico;
        this.paciente = paciente;
    }

    public DiaDeLaSemana getDia() {
        return dia;
    }

    public void setDia(DiaDeLaSemana dia) {
        this.dia = dia;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

}
