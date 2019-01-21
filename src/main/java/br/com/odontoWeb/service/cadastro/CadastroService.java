package br.com.odontoWeb.service.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.odontoWeb.domains.dto.DtoCadastro;
import br.com.odontoWeb.domains.factory.FactoryCadastro;
import br.com.odontoWeb.domains.model.Paciente;
import br.com.odontoWeb.domains.model.Usuario;
import br.com.odontoWeb.service.domains.FuncionarioService;
import br.com.odontoWeb.service.domains.PacienteService;

@Service
public class CadastroService {

	PacienteService pacienteservice;
	FuncionarioService usuarioService;

	@Autowired
	public CadastroService(PacienteService pacienteservice, FuncionarioService usuarioService) {
		this.pacienteservice = pacienteservice;
		this.usuarioService = usuarioService;
	}

	public DtoCadastro cadastrar(DtoCadastro dto) {
		
		if (dto.getUsuarioRegra().isAdmin()) {
			Usuario usuario = FactoryCadastro.dtoParaUsuario(dto);
			usuarioService.criarFuncionario(usuario);
			
		} else if (dto.getUsuarioRegra().isFuncionario()) {
			Usuario usuario = FactoryCadastro.dtoParaUsuario(dto);
			usuarioService.criarFuncionario(usuario);
			
		} else if (dto.getUsuarioRegra().isPaciente()) {
			Paciente paciente = FactoryCadastro.dtoParaPaciente(dto);
			pacienteservice.criarPaciente(paciente);
		}
		return dto;
	}

	public PacienteService getPacienteservice() {
		return pacienteservice;
	}

	public void setPacienteservice(PacienteService pacienteservice) {
		this.pacienteservice = pacienteservice;
	}

	public FuncionarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(FuncionarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
}