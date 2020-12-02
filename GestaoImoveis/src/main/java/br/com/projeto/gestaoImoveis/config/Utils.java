package br.com.projeto.gestaoImoveis.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	
	
	
	public static String converterDateEmStringFormatado(Date date){
		SimpleDateFormat formata  = new SimpleDateFormat("dd/MM/yyyy");
	
		return formata.format(date);
		
	}
	
	
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascimento = formataData.parse("11/03/2020");
		String dataString = formataData.format(dataNascimento);
		System.out.println("Data em String:" + dataString);
		System.out.println(formataData.format(dataNascimento));
		
		
	}

}
