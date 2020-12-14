package br.com.projeto.gestaoImoveis.controller.form;

import br.com.projeto.gestaoImoveis.models.Endereco;
import br.com.projeto.gestaoImoveis.models.Imoveis;
import br.com.projeto.gestaoImoveis.models.TipoImovel;
import br.com.projeto.gestaoImoveis.respository.EnderecoRepository;
import br.com.projeto.gestaoImoveis.respository.ImovelRepository;

public class ImovelFormAtualizar {

	private TipoImovel tipoImovel;
	private String descricao;

	public TipoImovel getTipoImovel() {
		return tipoImovel;
	}

	public void setTipoImovel(TipoImovel tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Imoveis atualizar(Long id, ImovelRepository imovelRepository) {
		Imoveis imovel = imovelRepository.getOne(id);

		imovel.setTipoImovel(this.tipoImovel);
		imovel.setDescricao(this.descricao);

		return imovel;
	}

	public Endereco atualizarEndereco(EnderecoRepository enderecoRepository) {
		return null;
	}

}
