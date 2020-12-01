package br.com.projeto.gestaoImoveis.controller.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.projeto.gestaoImoveis.models.Genero;
import br.com.projeto.gestaoImoveis.models.Pessoas;
import br.com.projeto.gestaoImoveis.models.Usuario;
import br.com.projeto.gestaoImoveis.respository.PessoaRepository;
import br.com.projeto.gestaoImoveis.respository.UsuarioRepository;

public class PessoaForm {

	@NotNull(message = "Usuário é um valor obrigatório")
	private String NmUsuario;
	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	@NotEmpty
	private String sobrenome;
	@NotNull
	@NotEmpty
	private String cpf;
	@NotEmpty
	@NotNull
	private String dtNascimento;
	@NotNull
	private Genero genero;
	@NotEmpty
	@NotNull
	private String numTelefoneFixo;
	@NotEmpty
	@NotNull
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
		
		
		return new Pessoas(usuario.get(), this.nome, this.sobrenome,this.cpf, dataNascimento, this.genero, this.numTelefoneFixo,
				this.numCelular);
	}


}
