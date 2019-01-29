package br.com.odontoWeb.domains.factory;

import br.com.odontoWeb.domains.dto.DtoCadastro;
import br.com.odontoWeb.domains.model.Dados;
import br.com.odontoWeb.domains.model.Paciente;
import br.com.odontoWeb.domains.model.Login;

public class FactoryCadastro {
	
	public static Paciente dtoParaPaciente(DtoCadastro dto) {

		Dados dados = new Dados();
		dados.setNome(dto.getPacienteNome());
		dados.setIdade(dto.getPacienteIdade());
		dados.setTelefone(dto.getPacienteTelefone());
		dados.setCpf(dto.getPacienteCpf());
		dados.setRua(dto.getPacienteRua());
		dados.setNumeroCasa(dto.getPacienteNumeroCasa());
		dados.setComplemento(dto.getPacienteComplemento());
		dados.setCep(dto.getPacienteCep());
		dados.setReferencia(dto.getPacienteReferencia());
		
		Login login = new Login();
		login.setUsuario(dto.getLoginUsuario());
		login.setSenha(dto.getLoginSenha());
		login.setRegra(dto.getLoginRegra());
		
		Paciente paciente = new Paciente();
		paciente.setDados(dados);
		paciente.setLogin(login);
		
		return paciente;
	}

	public static Login dtoParaUsuario(DtoCadastro dto) {
		Login login = new Login();
		login.setUsuario(dto.getLoginUsuario());
		login.setSenha(dto.getLoginSenha());
		login.setRegra(dto.getLoginRegra());
		return login;
	}
	
	public static DtoCadastro usuarioParaDto(Login login) {
		DtoCadastro dto = new DtoCadastro();
		dto.setLoginUsuario(login.getUsuario());
		dto.setLoginSenha(login.getSenha());
		dto.setLoginRegra(login.getRegra());
		return dto;
	}
	
	public static DtoCadastro pacienteParaDto(Paciente paciente) {
		DtoCadastro dto = new DtoCadastro();
		dto.setPacienteNome(paciente.getDados().getNome());
		dto.setPacienteIdade(paciente.getDados().getIdade());
		dto.setPacienteTelefone(paciente.getDados().getTelefone());
		dto.setPacienteCpf(paciente.getDados().getCpf());
		dto.setPacienteRua(paciente.getDados().getRua());
		dto.setPacienteNumeroCasa(paciente.getDados().getNumeroCasa());
		dto.setPacienteComplemento(paciente.getDados().getComplemento());
		dto.setPacienteCep(paciente.getDados().getCep());
		dto.setPacienteReferencia(paciente.getDados().getReferencia());
		return dto;
	}
}
