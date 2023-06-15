package ec.edu.espe.examenchristopherramos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.examenchristopherramos.model.Perfil;
import ec.edu.espe.examenchristopherramos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByMail(String email);

    List<Usuario> findByPerfiles(Perfil perfil);
}
