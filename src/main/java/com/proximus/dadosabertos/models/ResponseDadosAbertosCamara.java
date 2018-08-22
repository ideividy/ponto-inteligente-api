package com.proximus.dadosabertos.models;

public class ResponseDadosAbertosCamara {
	private Deputado[] dados;
	private Object[] links;

	public Deputado[] getDados() {
		return dados;
	}

	public void setDados(Deputado[] dados) {
		this.dados = dados;
	}

	public Object[] getLinks() {
		return links;
	}

	public void setLinks(Object[] links) {
		this.links = links;
	}

}
