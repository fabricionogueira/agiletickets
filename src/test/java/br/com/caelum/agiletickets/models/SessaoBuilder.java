package br.com.caelum.agiletickets.models;

import org.joda.time.DateTime;

public class SessaoBuilder {
	
	private Sessao instancia;
	
	private Estabelecimento criaEstabelecimento () {
		Estabelecimento e = new Estabelecimento();
		e.setNome("Casa de show");
		e.setEndereco("Rua 1");
		return e;
	}
	
	private Espetaculo criaEspetaculo() {
		Espetaculo e = new Espetaculo();
		e.setNome("Show");
		e.setDescricao("Show");
		e.setTipo(TipoDeEspetaculo.SHOW);
		e.setEstabelecimento(this.criaEstabelecimento());
		return e;
	}
	
	public SessaoBuilder() {
		instancia = new Sessao();
		instancia.setInicio(new DateTime());
		instancia.setDuracaoEmMinutos(120);
		instancia.setIngressosReservados(0);
		instancia.setTotalIngressos(1000);
		instancia.setEspetaculo(this.criaEspetaculo());
	}
	
	public SessaoBuilder comTotalIngressos(Integer totalIngresso) {
		instancia.setTotalIngressos(totalIngresso);
		return this;
	}

	public SessaoBuilder comIngressosReservados(Integer ingressosReservados) {
		instancia.setIngressosReservados(ingressosReservados);
		return this;
	}
	
	public Sessao constroi() {
		return instancia;
	}
	
}
