package com.nttdata.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	//spring reconoce automaticamente los find si estas buen escritos
	Usuario findByEmail(String email);
	Usuario findByNombre(String nombre);
	
	List<Usuario> findAll();
	
}
