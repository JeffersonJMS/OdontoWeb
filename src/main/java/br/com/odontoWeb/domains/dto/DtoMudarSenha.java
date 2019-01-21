package br.com.odontoWeb.domains.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DtoMudarSenha implements Serializable{

	private static final long serialVersionUID = 3989171674376792094L;

	private String antigaSenha;
	
	private String novaSenha;
}
