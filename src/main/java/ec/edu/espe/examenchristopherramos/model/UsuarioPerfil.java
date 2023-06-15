package ec.edu.espe.examenchristopherramos.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;

@Entity
@Table(name = "SEG_USUARIO_PERFIL")
public class UsuarioPerfil {

    @EmbeddedId
    private UsuarioPerfilPk PK;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_CREACION", nullable = false)
    private Date fechaCreacion;

    @Column(name = "ES_ACTIVO", nullable = false)
    private Boolean esActivo;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    @ManyToOne
    @JoinColumn(name = "COD_USUARIO", referencedColumnName = "COD_USUARIO", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "COD_PERFIL", referencedColumnName = "COD_PERFIL", insertable = false, updatable = false)
    private Perfil perfil;

    public UsuarioPerfil() {
    }

    public UsuarioPerfil(UsuarioPerfilPk PK) {
        this.PK = PK;
    }

    public UsuarioPerfilPk getPK() {
        return PK;
    }

    public void setPK(UsuarioPerfilPk pK) {
        PK = pK;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Boolean getEsActivo() {
        return esActivo;
    }

    public void setEsActivo(Boolean esActivo) {
        this.esActivo = esActivo;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "UsuarioPerfil [PK=" + PK + ", fechaCreacion=" + fechaCreacion + ", esActivo=" + esActivo + ", version="
                + version + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((PK == null) ? 0 : PK.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UsuarioPerfil other = (UsuarioPerfil) obj;
        if (PK == null) {
            if (other.PK != null)
                return false;
        } else if (!PK.equals(other.PK))
            return false;
        return true;
    }

}
