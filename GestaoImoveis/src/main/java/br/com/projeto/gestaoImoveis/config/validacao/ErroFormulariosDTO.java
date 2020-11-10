package br.com.projeto.gestaoImoveis.config.validacao;

public class ErroFormulariosDTO {

	private String campo;
	private String erro;

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}

	public ErroFormulariosDTO(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

}
