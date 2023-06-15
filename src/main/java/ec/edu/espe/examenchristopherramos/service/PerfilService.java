package ec.edu.espe.examenchristopherramos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.examenchristopherramos.model.Perfil;
import ec.edu.espe.examenchristopherramos.model.Usuario;
import ec.edu.espe.examenchristopherramos.repository.PerfilRepository;
import ec.edu.espe.examenchristopherramos.repository.UsuarioRepository;

@Service
public class PerfilService {
    
    private final PerfilRepository perfilRepository;
    private final UsuarioRepository usuarioRepository;

    public PerfilService(PerfilRepository perfilRepository, UsuarioRepository usuarioRepository) {
        this.perfilRepository = perfilRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Perfil> obtainByCode(String code) {
        return this.perfilRepository.findById(code);
    }

    public Optional<Usuario> obtainByCodeUser(Integer code) {
        return this.usuarioRepository.findById(code);
    }

    public List<Perfil> listByName(){
        return this.perfilRepository.findAllOrderByNombre();
    }

    public Usuario assignProfileToUser(Integer codigoUsuario, Perfil perfil){
        Optional<Usuario> usuarioOpt = this.usuarioRepository.findById(codigoUsuario);
        if (usuarioOpt.isPresent()) {
            Usuario usuarioTmp = usuarioOpt.get();
            usuarioTmp.getPerfiles().add(perfil);
            return usuarioTmp;
        } else {
            throw new RuntimeException("Usuario no existe");
        }
    }
}
