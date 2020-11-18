package br.com.projeto.gestaoImoveis.config;


public class Utils {


	public static void main(String[] args) {

		
		String email = null;
		
		email = "desenvolvimentosoftwares11@gmail.com";
		String code = gerandoHash(email);
		System.out.println(code);
		
		System.out.println(quebrandoHash(code));

	}

	private static String quebrandoHash(String code) {
		return new String(java.util.Base64.getDecoder().decode(code));
	}
	

	private static String gerandoHash(String email) {
		return new String(java.util.Base64.getEncoder().encode(email.getBytes()));

	}

}
