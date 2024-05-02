package br.com.vvatte;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.vvatte.dao.IProdutoDAO;
import br.com.vvatte.dao.ProdutoDaoMock;
import br.com.vvatte.domain.Produto;
import br.com.vvatte.exceptions.DAOException;
import br.com.vvatte.exceptions.TipoChaveNaoEncontradaException;
import br.com.vvatte.services.IProdutoService;
import br.com.vvatte.services.ProdutoService;

public class ProdutoServiceTest {

	private IProdutoService produtoService;
	
	private Produto produto;
	
	public ProdutoServiceTest() {
		IProdutoDAO dao = new ProdutoDaoMock();
		produtoService = new ProdutoService(dao);
	}
	
	@Before
	public void init() {
		produto = new Produto();
		produto.setCodigo("A1");
		produto.setDescricao("Grão");
		produto.setNome("Arroz");
		produto.setValor(BigDecimal.TEN);
	}
	
	@Test
	public void pesquisar() throws DAOException {
		Produto produtor = this.produtoService.consultar(produto.getCodigo());
		Assert.assertNotNull(produtor);
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = produtoService.cadastrar(produto);
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluir() throws DAOException {
		produtoService.excluir(produto.getCodigo());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		produto.setNome("Vinicius");
		produtoService.alterar(produto);
		
		Assert.assertEquals("Vinicius", produto.getNome());
	}
}
