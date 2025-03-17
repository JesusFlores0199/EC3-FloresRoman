package pe.edu.idat.EC3_FloresRoman.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.idat.EC3_FloresRoman.model.Usuario;
import pe.edu.idat.EC3_FloresRoman.repository.UsuarioRepository;
import pe.edu.idat.EC3_FloresRoman.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {
    private final UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public Usuario obtenerUsuarioxNomusuario(String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }
}