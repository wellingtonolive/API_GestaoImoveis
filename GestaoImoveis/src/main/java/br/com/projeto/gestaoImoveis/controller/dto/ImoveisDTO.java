package br.com.projeto.gestaoImoveis.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.projeto.gestaoImoveis.models.Imoveis;
import br.com.projeto.gestaoImoveis.models.TipoImovel;

public class ImoveisDTO {

	private Long id;
	private TipoImovel tipoImovel;
	private String descricao;

	public Long getId() {
		return id;
	}

	public TipoImovel getTipoImovel() {
		return tipoImovel;
	}

	public String getDescricao() {
		return descricao;
	}

	public ImoveisDTO(Long id, TipoImovel tipoImovel, String descricao) {
		this.id = id;
		this.tipoImovel = tipoImovel;
		this.descricao = descricao;
	}

	public ImoveisDTO(Imoveis imovel) {
		this.id = imovel.getID();
		this.tipoImovel = imovel.getTipoImovel();
		this.descricao = imovel.getDescricao();
	}

	public static List<ImoveisDTO> converter(List<Imoveis> lista) {
		return lista.stream().map(ImoveisDTO::new).collect(Collectors.toList());
	}

}
