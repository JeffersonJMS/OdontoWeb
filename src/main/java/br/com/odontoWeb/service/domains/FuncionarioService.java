package br.com.odontoWeb.service.domains;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.odontoWeb.domains.dto.DtoMudarSenha;
import br.com.odontoWeb.domains.model.Login;
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

	public List<Login> buscarTodosFuncionarios(){
		return repository.findAll();
	}

	public Login buscarFuncionarioPorId(String id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException());
	}

	public Login criarFuncionario(Login login) {
		return repository.save(login);
	}

	public void deletarFuncionario(String id){
		repository.findById(id).orElseThrow(() -> new NotFoundException());
		repository.deleteById(id);
	}

	public Login modificarSenha(String id, DtoMudarSenha dto) throws BadRequestException{
		Login loginTemp = this.buscarFuncionarioPorId(id);
		if(loginTemp.getSenha().equals(dto.getAntigaSenha())) {
			loginTemp.setSenha(dto.getNovaSenha());
			return repository.save(loginTemp);
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
