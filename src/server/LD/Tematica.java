package server.LD;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.util.HashSet;
import java.util.Set;

@PersistenceCapable
public class Tematica {

    @PrimaryKey
    @Persistent(valueStrategy= IdGeneratorStrategy.INCREMENT)
    long id_tematica=0;
    String nombre=null;
    String area=null;

    @Persistent(mappedBy="tematica")
    Set<Repositorio> repositorio = new HashSet<Repositorio>();

    public long getId_tematica() { return id_tematica; }
    public void setId_tematica(long id_tematica) { this.id_tematica = id_tematica; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public Set<Repositorio> getRepositorio() { return repositorio; }
    public void setRepositorio(Set<Repositorio> repositorio) { this.repositorio = repositorio; }

    public Tematica(String nombre, String area) {
        this.nombre = nombre;
        this.area = area;
    }
}
