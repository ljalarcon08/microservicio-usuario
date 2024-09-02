package com.example.la.usuario.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.la.common.usuario.entity.Rol;
import com.example.la.common.usuario.entity.Usuario;
import com.example.la.common.usuario.proyection.PaginaUsuario;
import com.example.la.common.usuario.proyection.UsuarioInterface;
import com.example.la.common.usuario.service.RolService;
import com.example.la.common.usuario.service.UsuarioService;
import com.example.la.usuario.domain.RequestImagen;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RolService rolService;
	
	@Autowired
	private BCryptPasswordEncoder bcryp;
	
	Logger logger=LoggerFactory.getLogger(getClass());
	
	@GetMapping("/email/{email}")
	public ResponseEntity<?> getUsuarioByEmail(@PathVariable String email) {
		return ResponseEntity.ok(usuarioService.findUsuarioByEmailNoPs(email));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUsuarioById(@PathVariable Long id){
		return ResponseEntity.ok(usuarioService.findUsuarioById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioInterface>> getAllUsuarios(){
		return ResponseEntity.ok((List<UsuarioInterface>)usuarioService.findAllUsuarios());
	}
	
	
	@GetMapping("/page")
	public ResponseEntity<?> getPageUsuario(@RequestParam int pagina,@RequestParam int largo){
		Pageable pageable=PageRequest.of(pagina, largo);
		Page<UsuarioInterface> page=usuarioService.findAllUsuariosPage(pageable);
		PaginaUsuario paginaUsuario=new PaginaUsuario();
		List<UsuarioInterface> lista = page.getContent();
		logger.info(""+lista.size());
		paginaUsuario.setUsuarios(page.getContent());
		//paginaUsuario.getUsuarios().addAll();
		paginaUsuario.setTotalRegistros(page.getTotalElements());
		
		return ResponseEntity.ok(paginaUsuario);
	}
	
	@GetMapping("/rol/{id}")
	public ResponseEntity<?> getRolesByIdUsuario(@PathVariable Long id){
		return ResponseEntity.ok(rolService.obtenerRolesPorId(id));
	}
	
	@GetMapping("/rol")
	public ResponseEntity<?> getRoles(){
		return ResponseEntity.ok(rolService.obtenerRoles());
	}
	
	/*@PostMapping("/crear")
	public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario){
		
		Usuario usuarioDB = usuarioService.crearUsuario(usuario);
		
		if(usuarioDB==null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		usuario.setPassword(null);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}*/
	
	@PostMapping("/rol")
	public ResponseEntity<?> crearRol(@RequestBody Rol rol){
		Rol rolNuevo = rolService.crearRol(rol);
		
		if(rolNuevo==null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(rolNuevo);
	}
	
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> actualizarUsuario(@PathVariable Long id,@RequestBody Usuario usuario){
		usuario.setId(id);
		logger.info("ROLES"+usuario.toString());
		if(usuario.getPassword()!=null && !usuario.getPassword().isEmpty()) {
			logger.info("SETPASSS");
			usuario.setPassword(bcryp.encode(usuario.getPassword()));
		}		
		
		Usuario usuarioAct=usuarioService.actualizarUsuario(usuario);
		if(usuarioAct!=null) {
			usuarioAct.setPassword(null);
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioAct);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PutMapping("/actualizarImagen/{id}")
	public ResponseEntity<?> actualizarImagen(@PathVariable Long id,@RequestBody RequestImagen request){
		Usuario usuarioAct=usuarioService.actualizaImagenUsuario(id, request.getImagen());
		if(usuarioAct!=null) {
			usuarioAct.setPassword(null);
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioAct);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PutMapping("/rol/actualizar/{id}")
	public ResponseEntity<?> actualizarRol(@PathVariable Long id,@RequestBody Rol rol){
		rol.setId(id);
		
		Rol rolNuevo=rolService.actualizarRol(rol);
		
		if(rolNuevo!=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(rolNuevo);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable Long id){
		usuarioService.eliminarUsuario(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@DeleteMapping("/rol/eliminar/{id}")
	public ResponseEntity<?> eliminarRol(@PathVariable Long id){
		rolService.eliminarRol(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
