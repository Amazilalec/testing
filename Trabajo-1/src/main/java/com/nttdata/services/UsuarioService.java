package com.nttdata.services;
import java.util.List;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nttdata.models.Role;
import com.nttdata.models.Usuario;
import com.nttdata.services.RoleService;
import com.nttdata.repository.RoleRepository;
import com.nttdata.repository.UsuarioRepository;
@Service
public class UsuarioService {
@Autowired
UsuarioRepository usuarioRepository;
@Autowired
RoleService roleService;
@Autowired
BCryptPasswordEncoder bcpe;

public void insertarUsuario(@Valid Usuario usuario) {
	usuario.setRoles(roleService.findByNombre("ROLE_USER"));
	usuarioRepository.save(usuario);
}

public void persistirUsuarioRol(Usuario usuario) {
	//encripta la password
	usuario.setPassword(bcpe.encode(usuario.getPassword()));
	usuario.setRoles(roleService.findByNombre("ROLE_USER"));
	//usuario.setRoles();
	usuarioRepository.save(usuario);

}

public List<Usuario> obtenerListaUsuarios() {
	// TODO Auto-generated method stub
	return usuarioRepository.findAll();
}


public void eliminarUsuario(@Valid Long id) {
	// TODO Auto-generated method stub
	usuarioRepository.deleteById(id);
}

public void eliminarUsuarioObjeto(Usuario usuario) {
	usuarioRepository.delete(usuario);
}

public Usuario buscarUsuarioId(Long id) {
	return usuarioRepository.findById(id).get();
	
}


public void modificarObjeto(Usuario usuario) {
	 usuarioRepository.save(usuario);
	
}


public void updateUsuario(@Valid Usuario usuario) {
	if(usuarioRepository.existsById(usuario.getId())) {
		usuarioRepository.save(usuario);
	}
}
public long obtenerIndentificador(@Valid Usuario usuario) {
	long temporal;
	temporal = usuario.getId();
	return temporal;
	}	


public Usuario findByEmail(String email) {
	return usuarioRepository.findByEmail(email);
	}
//insertar usuario
public Usuario registroUsuario(Usuario usuario) {
	//se hash la password luego se sobreescribe
	String hashed = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
	usuario.setPassword(hashed);
	return usuarioRepository.save(usuario);
	}

public boolean loginUsuario(String nombre, String password) {
	Usuario usuario = usuarioRepository.findByNombre(nombre);
	if(usuario == null) return false;
	else {
		//para comparar password recordar que la wea estan encriptadas
			if(BCrypt.checkpw(password, usuario.getPassword())) {
				return true;
			}
			else return false;
		}	
	}

public Usuario findByNombre(String nombre) {
	return usuarioRepository.findByNombre(nombre);
	
}


}
