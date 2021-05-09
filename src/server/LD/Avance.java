package server.LD;

import javax.jdo.annotations.*;
import java.util.Date;

@PersistenceCapable
public class Avance {

    @PrimaryKey
    @Persistent(valueStrategy= IdGeneratorStrategy.INCREMENT)
    long id_avance=0;

    Date fec_avance=null;

    @Column(name="id_investigador")
    Investigador investigador;

    @Column(name="id_repositorio")
    Repositorio repositorio;

    public long getId_avance() { return id_avance; }
    public void setId_avance(long id_avance) { this.id_avance = id_avance; }

    public Date getFec_avance() { return fec_avance; }
    public void setFec_avance(Date fec_avance) { this.fec_avance = fec_avance; }

    public Investigador getInvestigador() { return investigador; }
    public void setInvestigador(Investigador investigador) { this.investigador = investigador; }

    public Repositorio getRepositorio() { return repositorio; }
    public void setRepositorio(Repositorio repositorio) { this.repositorio = repositorio; }

    public Avance(Date fec_avance)
    {
        this.fec_avance=fec_avance;
    }
}
