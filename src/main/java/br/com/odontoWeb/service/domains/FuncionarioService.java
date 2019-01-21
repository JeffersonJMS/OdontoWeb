package br.com.odontoWeb.service.domains;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.odontoWeb.domains.dto.DtoMudarSenha;
import br.com.odontoWeb.domains.model.Usuario;
import br.com.odontoWeb.exceptions.BadRequestException;
import br.com.odontoWeb.exceptions.NotFoundException;
import br.com.odontoWeb.repository.FuncionarioRepository;
@Validated
@Service
public class FuncionarioService{

	FuncionarioRepository repository;
	
	@Autowired
	public FuncionarioService(FuncionarioRepository repository) {
		this.repository = repository;
	}

	public List<Usuario> buscarTodosFuncionarios(){
		return repository.findAll();
	}

	public Usuario buscarFuncionarioPorId(String id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException());
	}

	public Usuario criarFuncionario(Usuario usuario) {
		return repository.save(usuario);
	}

	public void deletarFuncionario(String id){
		repository.findById(id).orElseThrow(() -> new NotFoundException());
		repository.deleteById(id);
	}

	public Usuario modificarSenha(String id, DtoMudarSenha dto) throws BadRequestException{
		Usuario usuarioTemp = this.buscarFuncionarioPorId(id);
		if(usuarioTemp.getSenha().equals(dto.getAntigaSenha())) {
			usuarioTemp.setSenha(dto.getNovaSenha());
			return repository.save(usuarioTemp);
		}
		throw new BadRequestException();
	}
	
	public FuncionarioRepository getRepository() {
		return repository;
	}

	public void setRepository(FuncionarioRepository repository) {
		this.repository = repository;
	}
	
	
}
