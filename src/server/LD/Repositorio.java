package server.LD;

import javax.jdo.annotations.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@PersistenceCapable
public class Repositorio {

    @PrimaryKey
    @Persistent(valueStrategy= IdGeneratorStrategy.INCREMENT)
    long id_repositorio=0;

    String nombre=null;
    String descripcion=null;
    String estado=null;

    @Column(name="id_equipo")
    Equipo equipo;

    @Column(name="id_investigador")
    Investigador investigador;

    @Column(name="id_tematica")
    Tematica tematica;

    @Column(name="id_proyecto")
    Proyecto proyecto;

    @Persistent(mappedBy="repositorio")
    Set<Avance> avance = new HashSet<Avance>();

    public Set<Avance> getAvance() { return avance; }
    public void setAvance(Set<Avance> avance) { this.avance = avance; }

    public long getId_repositorio() { return id_repositorio; }
    public void setId_repositorio(long id_repositorio) { this.id_repositorio = id_repositorio; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Equipo getEquipo() { return equipo; }
    public void setEquipo(Equipo equipo) { this.equipo = equipo; }

    public Tematica getTematica() { return tematica; }
    public void setTematica(Tematica tematica) { this.tematica = tematica; }

    public Proyecto getProyecto() { return proyecto; }
    public void setProyecto(Proyecto proyecto) { this.proyecto = proyecto; }

    public Repositorio(String nombre, String descripcion, String estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }
}
