package org.ciberfarma.repository;

import org.ciberfarma.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	//CRUD ---> JpaRepository
	
	Usuario findByCorreoAndClave(String correo, String clave);
	// select * from tb_usuarios where correo = ? and clave = ?
	
	
}
