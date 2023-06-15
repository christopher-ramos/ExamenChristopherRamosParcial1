package ec.edu.espe.examenchristopherramos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.examenchristopherramos.model.Perfil;
import ec.edu.espe.examenchristopherramos.model.Usuario;
import ec.edu.espe.examenchristopherramos.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> obtainByCode(Integer code) {
        return this.usuarioRepository.findById(code);
    }

    public Usuario create(Usuario usuario) {
        Usuario usuarioTmp = this.usuarioRepository.findByMail(usuario.getEmail());
        if (usuarioTmp == null) {
            return this.usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("El correo electronico ya fue registrado");
        }
    }

    public List<Usuario> listUsersAssignedToProfile(Perfil perfil) {
        return this.usuarioRepository.findByPerfiles(perfil);
    }
}
