package com.proximus.pontointeligente.api.controllers;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.proximus.dadosabertos.models.ResponseDadosAbertosCamara;

@Controller
@RequestMapping("/api/deputados")
@CrossOrigin(origins = "*")//permitir requisiçoes vindos de dominios distintos
public class DeputadoController {
	private static String URL = "https://dadosabertos.camara.leg.br/api/v2/deputados?ordem=ASC&ordenarPor=nome";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String listaDeputados(Model model) {
		
		RestTemplate restTemplate = new RestTemplate();
        
    	ParameterizedTypeReference<ResponseDadosAbertosCamara> listOfString = new ParameterizedTypeReference<ResponseDadosAbertosCamara>() {};
    	ResponseEntity<ResponseDadosAbertosCamara> response= restTemplate.exchange(URL,HttpMethod.GET,null, listOfString);
			
		model.addAttribute("deputados", response.getBody().getDados());
		
        return "listaDeputados";
    }
	
}
