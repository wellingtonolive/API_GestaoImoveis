package br.com.projeto.gestaoImoveis.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Contrato {
	
	private Long ID;
	private Integer numeroContrato;
	private Date dtEmissao;
	private Date dtValidade;
	private Imoveis imovel;
	private Pessoas proprietario;
	private List<Pessoas> inquilino;
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
	public List<Pessoas> getInquilino() {
		return inquilino;
	}
	public void setInquilino(List<Pessoas> inquilino) {
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
