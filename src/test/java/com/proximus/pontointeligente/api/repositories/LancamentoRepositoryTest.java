package com.proximus.pontointeligente.api.repositories;

import static org.junit.Assert.assertEquals;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.proximus.pontointeligente.api.entities.Empresa;
import com.proximus.pontointeligente.api.entities.Funcionario;
import com.proximus.pontointeligente.api.entities.Lancamento;
import com.proximus.pontointeligente.api.enums.PerfilEnum;
import com.proximus.pontointeligente.api.enums.TipoEnum;
import com.proximus.pontointeligente.api.utils.PasswordUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoRepositoryTest {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	private Long funcionarioId;
	
	@Before
	public void setUp() throws Exception{
		Empresa empresa = this.empresaRepository.save(obterDadosEmpresa());
		
		Funcionario funcionario = this.funcionarioRepository.save(obterDadosFuncionario(empresa));
		this.funcionarioId = funcionario.getId();
		
		this.lancamentoRepository.save(obterDadosLancamento(funcionario));
	}
	
	@After
	public void tearDown() {
		this.empresaRepository.deleteAll();
	}
	
	@Test
	public void testBuscarLancamentoPorFuncionarioId() {
		List<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId);
		
		assertEquals(1, lancamentos.size());
	}

	@Test
	public void testBuscarLancamentoPorFuncionarioIdPaginado() {
		PageRequest page = new PageRequest(0, 10);
		Page<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId, page);
		
		assertEquals(1, lancamentos.getTotalElements());
	}
	
	private Funcionario obterDadosFuncionario(Empresa empresa) throws NoSuchAlgorithmException{
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Fulano de tal");
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setSenha(PasswordUtils.gerarBCrypt("123"));
		funcionario.setCpf("12345678901");
		funcionario.setEmail("email@email.com");
		funcionario.setEmpresa(empresa);
		return funcionario;
	}

	private Empresa obterDadosEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Empresa de Exemplo");
		empresa.setCnpj("51463645000100");
		return empresa;
	}
	
	private Lancamento obterDadosLancamento(Funcionario funcionario) {
		Lancamento lancamento = new Lancamento();
		lancamento.setData(new Date());
		lancamento.setDescricao("Alguma descricao");
		lancamento.setTipo(TipoEnum.INICIO_ALMOCO);
		lancamento.setFuncionario(funcionario);
		return lancamento;
	}
}
