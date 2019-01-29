package br.com.odontoWeb.domains.dto;

import java.io.Serializable;

import br.com.odontoWeb.domains.enumerations.Regras;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DtoCadastro implements Serializable{

	private static final long serialVersionUID = -1831435089800184383L;

	private String pacienteNome;
	
	private byte pacienteIdade;
	
	private int pacienteTelefone;
	
	private String pacienteCpf;
	
	private String pacienteRua;
	
	private int pacienteNumeroCasa;
	
	private String pacienteComplemento;
	
	private int pacienteCep;
	
	private String pacienteReferencia;
	
	private String loginUsuario;
	
	private String loginSenha;
	
	private Regras loginRegra;
	
}
