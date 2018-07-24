package com.proximus.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proximus.pontointeligente.api.entities.Funcionario;
import com.proximus.pontointeligente.api.repositories.FuncionarioRepository;
import com.proximus.pontointeligente.api.services.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

	private static final Logger log = LoggerFactory.getLogger(FuncionarioServiceImpl.class);
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario persistir(Funcionario funcionario) {
		log.info("Persistindo empresa: {}", funcionario);
		return this.funcionarioRepository.save(funcionario);
	}
	
	public Optional<Funcionario> buscarPorEmail(String email) {
		log.info("Buscando uma empresa para o Email: {}", email);
		return Optional.ofNullable(funcionarioRepository.findByEmail(email));
	}	
	
	public Optional<Funcionario> buscarPorId(Long id) {
		log.info("Buscando uma empresa para o ID: {}", id);
		return Optional.ofNullable(funcionarioRepository.findById(id).orElse(null));
	}

	public Optional<Funcionario> buscarPorCpf(String cpf) {
		log.info("Buscando uma empresa para o CPF: {}", cpf);
		return Optional.ofNullable(funcionarioRepository.findByCpf(cpf));
	}

}
