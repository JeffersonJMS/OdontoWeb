package br.com.odontoWeb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.odontoWeb.domains.model.Login;

@Repository
public interface FuncionarioRepository extends MongoRepository <Login, String>{

}
