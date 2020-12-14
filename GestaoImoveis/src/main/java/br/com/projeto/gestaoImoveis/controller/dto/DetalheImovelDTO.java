package br.com.projeto.gestaoImoveis.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.projeto.gestaoImoveis.models.Endereco;
import br.com.projeto.gestaoImoveis.models.Imoveis;
import br.com.projeto.gestaoImoveis.models.Pessoas;
import br.com.projeto.gestaoImoveis.models.TipoImovel;

public class DetalheImovelDTO {

	private Long id;
	private TipoImovel tipoImovel;
	private String descricao;
	private List<EnderecoDto> endereco = new ArrayList<EnderecoDto>();
	private PessoaDTO proprietarioDTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public List<EnderecoDto> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<EnderecoDto> endereco) {
		this.endereco = endereco;
	}

	public PessoaDTO getProprietarioDTO() {
		return proprietarioDTO;
	}

	public void setProprietarioDTO(PessoaDTO proprietarioDTO) {
		this.proprietarioDTO = proprietarioDTO;
	}

	public DetalheImovelDTO(Optional<Imoveis> imovel, List<Endereco> enderecoImovel) {

		this.id = imovel.get().getID();
		this.tipoImovel = imovel.get().getTipoImovel();
		this.descricao = imovel.get().getDescricao();
		enderecoImovel.stream().forEach(itemEndereco -> this.endereco.add(new EnderecoDto(itemEndereco)));

	}

	public DetalheImovelDTO(Optional<Imoveis> imovel, List<Endereco> enderecoImovel, Optional<Pessoas> proprietario) {
		this.id = imovel.get().getID();
		this.tipoImovel = imovel.get().getTipoImovel();
		this.descricao = imovel.get().getDescricao();
		enderecoImovel.stream().forEach(endereco2 -> this.endereco.add(new EnderecoDto(endereco2)));
		this.proprietarioDTO = new PessoaDTO(proprietario.get());

	}

	public DetalheImovelDTO(Imoveis imovel2) {
		this.id = imovel2.getID();
		this.tipoImovel = imovel2.getTipoImovel();
		this.descricao = imovel2.getDescricao();
	}

}
