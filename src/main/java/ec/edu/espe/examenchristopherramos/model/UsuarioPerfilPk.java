package ec.edu.espe.examenchristopherramos.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Embeddable
public class UsuarioPerfilPk implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_USUARIO", nullable = false)
    private Integer codigoUsuario;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_PERFIL", nullable = false, length = 8)
    private String codigoPerfil;

    public UsuarioPerfilPk() {
    }

    public UsuarioPerfilPk(int codigoUsuario, String codigoPerfil) {
        this.codigoUsuario = codigoUsuario;
        this.codigoPerfil = codigoPerfil;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCodigoPerfil() {
        return codigoPerfil;
    }

    public void setCodigoPerfil(String codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }

    @Override
    public String toString() {
        return "UsuarioPerfilPk [codigoUsuario=" + codigoUsuario + ", codigoPerfil=" + codigoPerfil + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoUsuario == null) ? 0 : codigoUsuario.hashCode());
        result = prime * result + ((codigoPerfil == null) ? 0 : codigoPerfil.hashCode());
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
        UsuarioPerfilPk other = (UsuarioPerfilPk) obj;
        if (codigoUsuario == null) {
            if (other.codigoUsuario != null)
                return false;
        } else if (!codigoUsuario.equals(other.codigoUsuario))
            return false;
        if (codigoPerfil == null) {
            if (other.codigoPerfil != null)
                return false;
        } else if (!codigoPerfil.equals(other.codigoPerfil))
            return false;
        return true;
    }

}
