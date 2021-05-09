package server.LD;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.util.HashSet;
import java.util.Set;

@PersistenceCapable
public class Proyecto {

    @PrimaryKey
    @Persistent(valueStrategy= IdGeneratorStrategy.INCREMENT)
    long id_proyecto=0;

    String nombre=null;
    String descripcion=null;
    String tipo=null;

    @Persistent(mappedBy="proyecto")
    Set<Repositorio> Repositorio = new HashSet<Repositorio>();

    public long getId_proyecto() { return id_proyecto; }
    public void setId_proyecto(long id_proyecto) { this.id_proyecto = id_proyecto; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Set<Repositorio> getRepositorio() { return Repositorio; }
    public void setRepositorio(Set<Repositorio> repositorio) { Repositorio = repositorio; }

    public Proyecto(String nombre, String descripcion, String tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }
}
