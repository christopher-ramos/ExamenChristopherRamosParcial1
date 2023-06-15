package ec.edu.espe.examenchristopherramos.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "SEG_PERFIL")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_PERFIL", length = 8, nullable = false)
    private String codigo;

    @Column(name = "NOMBRE", length = 100, nullable = false)
    private String nombre;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    @OneToMany(mappedBy = "perfil")
    private List<UsuarioPerfil> usuarioPerfil;

    public Perfil() {

    }

    public Perfil(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Perfil [codigo=" + codigo + ", nombre=" + nombre + ", version=" + version + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
        Perfil other = (Perfil) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }
}
