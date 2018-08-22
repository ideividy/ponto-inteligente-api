package com.proximus.dadosabertos.models;
import javax.xml.bind.JAXBException;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ClienteJava {
 
    private static String URL = "https://dadosabertos.camara.leg.br/api/v2/deputados?ordem=ASC&ordenarPor=nome";
 
    public static void main(String[] args) throws JAXBException {
 
        	//RestTemplate restTemplate = new RestTemplate();
        	//Deputado obj = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Deputado.class);
        	
        	RestTemplate restTemplate = new RestTemplate();
            
        	/*HttpHeaders headers = new HttpHeaders();
        	headers.setContentType(MediaType.APPLICATION_JSON);*/

        	
        	ParameterizedTypeReference<ResponseDadosAbertosCamara> listOfString = new ParameterizedTypeReference<ResponseDadosAbertosCamara>() {};
        	ResponseEntity<ResponseDadosAbertosCamara> response= restTemplate.exchange(URL,HttpMethod.GET,null, listOfString);

        	
        	for (Deputado deputado : response.getBody().getDados()) {
				System.out.println(deputado.toString());
			}
        	
            
            System.out.println("");
            
            /*List<Deputado> lista = response.getBody();
            
            for (Deputado deputado : lista) {
				System.out.println("Deputado: " + deputado.toString());
				
			}*/
        
    }
    
}