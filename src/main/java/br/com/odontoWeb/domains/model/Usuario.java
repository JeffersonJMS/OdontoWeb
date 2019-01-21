package br.com.odontoWeb.domains.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.odontoWeb.domains.enumerations.Regras;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document
public class Usuario {

	@Id
	private String id;
	
	@Indexed(unique = true)
	@NotBlank(message = "{usuario.login.notblank}")
	@Size(min = 4, max = 20, message = "{usuario.login.size}")
	private String login;
	
	@NotBlank(message = "{usuario.senha.notblank}")
	@Size(min = 4, max = 15, message = "{usuario.senha.size}")
	private String senha;
	
	@NotNull(message = "{user.regra}")
	private Regras regra;

}