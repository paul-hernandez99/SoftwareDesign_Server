package server.LD;

import javax.jdo.annotations.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@PersistenceCapable
public class Investigador {

    @PrimaryKey
    @Persistent(valueStrategy= IdGeneratorStrategy.INCREMENT)
    long id_investigador=0;
    String nombre = null;
    String apellido1=null;
    String apellido2=null;


    @Column(name="id_organizacion")
    Organizacion organizacion;

    @Persistent(mappedBy="investigador")
    Set<Avance> avance = new HashSet<Avance>();

    @Persistent(mappedBy="investigador")
    Set<Investigador_Equipo> investigador_equipo= new HashSet<>();

    @Persistent(mappedBy="investigador")
    Set<Repositorio> repositorio = new HashSet<Repositorio>();

    public Set<Investigador_Equipo> getInvestigador_Equipo() { return investigador_equipo;}
    public void setInvestigador_Equipo(Set<Investigador_Equipo> investigador_equipo) { this.investigador_equipo = investigador_equipo;}

    public Set<Avance> getAvance() { return avance; }
    public void setAvance(Set<Avance> avance) { this.avance = avance; }

    public long getId_investigador() { return id_investigador; }
    public void setId_investigador(long id_investigador) { this.id_investigador = id_investigador; }

    public Organizacion getOrganizacion() { return organizacion; }
    public void setOrganizacion(Organizacion organizacion) { this.organizacion = organizacion; }

    public String getNombre() { return nombre;}
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido1() { return apellido1; }
    public void setApellido1(String apellido1) { this.apellido1 = apellido1; }

    public String getApellido2() { return apellido2; }
    public void setApellido2(String apellido2) { this.apellido2 = apellido2; }


    public Investigador(String nombre, String apellido1, String apellido2, int edad) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
 
    }

}
