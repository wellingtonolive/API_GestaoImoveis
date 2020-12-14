package br.com.projeto.gestaoImoveis.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Imoveis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	@Enumerated(EnumType.STRING)
	private TipoImovel tipoImovel;
	private String descricao;
	@ManyToOne
	private Pessoas proprietario;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
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

	public Pessoas getProprietario() {
		return proprietario;
	}

	public void setProprietario(Pessoas proprietario) {
		this.proprietario = proprietario;
	}

	public Imoveis() {

	}

	public Imoveis(Long iD, TipoImovel tipoImovel, String descricao, Pessoas proprietario) {
		this.tipoImovel = tipoImovel;
		this.descricao = descricao;
		this.proprietario = proprietario;
	}

	public Imoveis(TipoImovel tipoImovel, String descricao, Pessoas proprietario) {
		this.tipoImovel = tipoImovel;
		this.descricao = descricao;
		this.proprietario = proprietario;
	}

}
