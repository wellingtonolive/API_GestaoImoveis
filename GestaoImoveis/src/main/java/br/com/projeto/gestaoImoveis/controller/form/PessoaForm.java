package br.com.projeto.gestaoImoveis.controller.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.projeto.gestaoImoveis.models.Genero;
import br.com.projeto.gestaoImoveis.models.PerfilUsuario;
import br.com.projeto.gestaoImoveis.models.Pessoas;
import br.com.projeto.gestaoImoveis.models.Usuario;
import br.com.projeto.gestaoImoveis.respository.PessoaRepository;
import br.com.projeto.gestaoImoveis.respository.UsuarioRepository;

public class PessoaForm {

	@NotNull(message = "Não pode ser nulo")
	private String NmUsuario;
	@NotNull(message = "Não pode ser nulo")
	@NotEmpty(message = "Não pode ser vazio")
	private String nome;
	@NotNull(message = "Não pode ser nulo")
	@NotEmpty(message = "Sobrenome não pode ser em branco")
	private String sobrenome;
	@NotNull(message = "Não pode ser nulo")
	@NotEmpty(message = "Não pode ser vazio")
	private String cpf;
	@NotEmpty(message = "Não pode ser vazio")
	@NotNull(message = "Não pode ser nulo")
	private String dtNascimento;
	@NotNull(message = "Não pode ser nulo")
	private Genero genero;
	@NotNull(message = "Não pode ser nulo")
	private PerfilUsuario perfilUsuario;
	@NotEmpty(message = "Não pode ser vazio")
	@NotNull(message = "Não pode ser nulo")
	private String numTelefoneFixo;
	@NotEmpty(message = "Não pode ser vazio")
	@NotNull(message = "Não pode ser nulo")
	private String numCelular;

	public String getNmUsuario() {
		return NmUsuario;
	}

	public void setNmUsuario(String usuario) {
		this.NmUsuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
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

	public boolean validaPessoaPorCPF(PessoaRepository pessoaRepository) {
		Optional<Pessoas> pessoaPorCPF = pessoaRepository.findByCpf(cpf);
		if (pessoaPorCPF.isPresent()) {
			return true;
		}
		return false;
	}

	public Pessoas converterPessoa(UsuarioRepository usuarioRepository) throws ParseException {

		SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascimento = formataData.parse(this.dtNascimento);

		Optional<Usuario> usuario = usuarioRepository.findByNmUsuario(NmUsuario);

		return new Pessoas(usuario.get(), this.nome, this.sobrenome, this.cpf, dataNascimento, this.genero,
				this.perfilUsuario, this.numTelefoneFixo, this.numCelular);
	}

}
