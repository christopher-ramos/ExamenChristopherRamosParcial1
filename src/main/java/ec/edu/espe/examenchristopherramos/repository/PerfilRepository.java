package ec.edu.espe.examenchristopherramos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.examenchristopherramos.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, String> {

    List<Perfil> findByNombreLikeOrderByNombre(String nombre);

    List<Perfil> findAllOrderByNombre();
}
