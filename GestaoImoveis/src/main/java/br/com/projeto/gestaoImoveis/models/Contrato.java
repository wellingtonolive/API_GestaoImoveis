package br.com.projeto.gestaoImoveis.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Contrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	private Integer numeroContrato;
	private Date dtEmissao;
	private Date dtValidade;
	@OneToOne
	private Imoveis imovel;
	@OneToOne
	private Pessoas proprietario;
	@OneToOne
	private Pessoas inquilino;
	private BigDecimal valorAluguel;
	private BigDecimal valorDeposito;
	
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public Integer getNumeroContrato() {
		return numeroContrato;
	}
	public void setNumeroContrato(Integer numeroContrato) {
		this.numeroContrato = numeroContrato;
	}
	public Date getDtEmissao() {
		return dtEmissao;
	}
	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}
	public Date getDtValidade() {
		return dtValidade;
	}
	public void setDtValidade(Date dtValidade) {
		this.dtValidade = dtValidade;
	}
	public Imoveis getImovel() {
		return imovel;
	}
	public void setImovel(Imoveis imovel) {
		this.imovel = imovel;
	}
	public Pessoas getProprietario() {
		return proprietario;
	}
	public void setProprietario(Pessoas proprietario) {
		this.proprietario = proprietario;
	}
	public Pessoas getInquilino() {
		return inquilino;
	}
	public void setInquilino(Pessoas inquilino) {
		this.inquilino = inquilino;
	}
	public BigDecimal getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(BigDecimal valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	public BigDecimal getValorDeposito() {
		return valorDeposito;
	}
	public void setValorDeposito(BigDecimal valorDeposito) {
		this.valorDeposito = valorDeposito;
	}
	
	

}
