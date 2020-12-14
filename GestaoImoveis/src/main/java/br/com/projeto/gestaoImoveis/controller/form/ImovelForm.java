package br.com.projeto.gestaoImoveis.controller.form;

import java.util.Optional;

import br.com.projeto.gestaoImoveis.models.Endereco;
import br.com.projeto.gestaoImoveis.models.Imoveis;
import br.com.projeto.gestaoImoveis.models.Pessoas;
import br.com.projeto.gestaoImoveis.models.TipoImovel;
import br.com.projeto.gestaoImoveis.respository.PessoaRepository;

public class ImovelForm {

	private String cpfProprietário;
	private TipoImovel tipoImovel;
	private String descricao;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;
	private String cidade;
	private String estado;

	
	public String getCpfProprietário() {
		return cpfProprietário;
	}

	public void setCpfProprietário(String cpfProprietário) {
		this.cpfProprietário = cpfProprietário;
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean buscaPessoaPorCPF(PessoaRepository pessoaRepository) {
		Optional<Pessoas> pessoaPorCPF = pessoaRepository.findByCpf(cpfProprietário);
		if (pessoaPorCPF.isPresent()) {
			return true;
		}
		return false;
	}

	public Imoveis converterImovel(PessoaRepository pessoaRepository) {
		
		Optional<Pessoas> proprietario = pessoaRepository.findByCpf(cpfProprietário);
		

		return new Imoveis(this.tipoImovel,this.descricao,proprietario.get());
	}

	public Endereco converterEndereco(Imoveis imovel) {
		
		return new Endereco(imovel,this.logradouro,this.numero,this.complemento,this.cep,this.cidade,this.estado);
	}
	
	
	

}
