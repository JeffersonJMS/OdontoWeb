package br.com.odontoWeb.service.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.odontoWeb.domains.dto.DtoCadastro;
import br.com.odontoWeb.domains.factory.FactoryCadastro;
import br.com.odontoWeb.domains.model.Paciente;
import br.com.odontoWeb.domains.model.Login;
import br.com.odontoWeb.service.domains.FuncionarioService;
import br.com.odontoWeb.service.domains.PacienteService;

@Service
public class CadastroService {

	PacienteService pacienteService;
	FuncionarioService usuarioService;

	@Autowired
	public CadastroService(PacienteService pacienteService, FuncionarioService usuarioService) {
		this.pacienteService = pacienteService;
		this.usuarioService = usuarioService;
	}

	public DtoCadastro cadastrar(DtoCadastro dto) {
		
		if (dto.getLoginRegra().isAdmin()) {
			Login login = FactoryCadastro.dtoParaUsuario(dto);
			usuarioService.criarFuncionario(login);
			
		} else if (dto.getLoginRegra().isFuncionario()) {
			Login login = FactoryCadastro.dtoParaUsuario(dto);
			usuarioService.criarFuncionario(login);
			
		} else if (dto.getLoginRegra().isPaciente()) {
			Paciente paciente = FactoryCadastro.dtoParaPaciente(dto);
			pacienteService.criarPaciente(paciente);
		}
		return dto;
	}

	public PacienteService getPacienteservice() {
		return pacienteService;
	}

	public void setPacienteservice(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}

	public FuncionarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(FuncionarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
}