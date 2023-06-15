package ec.edu.espe.examenchristopherramos.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;

@Entity
@Table(name = "SEG_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_USUARIO", nullable = false)
    private Integer codigo;

    @Column(name = "MAIL", length = 128, nullable = false)
    private String email;

    @Column(name = "CLAVE", length = 64, nullable = false)
    private String clave;

    @Column(name = "NOMBRE", length = 128, nullable = false)
    private String nombre;

    @Column(name = "INTENTOS_FALLIDOS", columnDefinition = "NUMERIC(8)", nullable = false)
    private Integer intentos;

    @Column(name = "SUELDO", precision = 8, scale = 2)
    private BigDecimal sueldo;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioPerfil> usuarioPerfil;

    private List<Perfil> perfiles;

    public List<Perfil> getPerfiles() {
        return perfiles;
    }

    public Usuario() {

    }

    public Usuario(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIntentos() {
        return intentos;
    }

    public void setIntentos(Integer intentos) {
        this.intentos = intentos;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Usuario [codigo=" + codigo + ", email=" + email + ", clave=" + clave + ", nombre=" + nombre
                + ", intentos=" + intentos + ", sueldo=" + sueldo + ", fechaNacimiento=" + fechaNacimiento
                + ", version=" + version + "]";
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
        Usuario other = (Usuario) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

}
