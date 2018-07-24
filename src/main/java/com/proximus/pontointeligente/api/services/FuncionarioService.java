package com.proximus.pontointeligente.api.services;

import java.util.Optional;

import com.proximus.pontointeligente.api.entities.Funcionario;

public interface FuncionarioService {
	
	/**
	 * Cadastra um novo funcionario na base de dados
	 * 
	 * @param funcionario
	 * @return Funcionario
	 */
	Funcionario persistir(Funcionario funcionario);
	
	/**
	 * Retorna um funcionário dado um CPF
	 * @param cpf
	 * @return Optional<Funcionario>
	 */
	Optional<Funcionario> buscarPorCpf(String cpf);

	/**
	 * Retorna um funcionário dado um email
	 * @param email
	 * @return Optional<Funcionario>
	 */
	Optional<Funcionario> buscarPorEmail(String email);

	/**
	 * Retorna um funcionário dado um ID
	 * @param id
	 * @return Optional<Funcionario>
	 */
	Optional<Funcionario> buscarPorId(Long id);
}
