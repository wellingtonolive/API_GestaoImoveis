package br.com.projeto.gestaoImoveis.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pessoas")
public class Pessoas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	@OneToOne
	private Usuario user;
	private String nome;
	private String sobrenome;
	private String cpf;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date dtNascimento;
	@Enumerated(EnumType.STRING)
	private Genero genero;
	private String numTelefoneFixo;
	private String numCelular;
	@Enumerated(EnumType.STRING)
	private PerfilUsuario perfilUsuario;
	@OneToOne
	private Endereco endereco;
	@OneToMany
	private List<Imoveis> imoveis;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getNumTelefoneFixo() {
		return numTelefoneFixo;
	}

	public void setNumTelefoneFixo(String numTelefoneFixo) {
		this.numTelefoneFixo = numTelefoneFixo;
	}

	public String getNumCelular() {
		return numCelular;
	}

	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}

	public PerfilUsuario getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	

	public List<Imoveis> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<Imoveis> imoveis) {
		this.imoveis = imoveis;
	}

	public Pessoas() {

	}

	public Pessoas(Usuario user, String nome, String sobrenome, String cpf, Date dtNascimento, Genero genero,
			PerfilUsuario perfilUsuario, String numTelefoneFixo, String numCelular) {
		this.user = user;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
		this.genero = genero;
		this.perfilUsuario = perfilUsuario;
		this.numTelefoneFixo = numTelefoneFixo;
		this.numCelular = numCelular;

	}

}
