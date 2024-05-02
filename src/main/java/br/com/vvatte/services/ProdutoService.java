package br.com.vvatte.services;

import br.com.vvatte.dao.IProdutoDAO;
import br.com.vvatte.domain.Produto;
import br.com.vvatte.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
