package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Test;

public class SessaoTest {

	
	@Test
	public void deveVender1ingressoSeHa2vagas() throws Exception {
		
        Sessao sessao = new SessaoBuilder().comTotalIngressos(2).constroi();

        Assert.assertTrue(sessao.podeReservar(1));
	}

	@Test
	public void naoDeveVender3ingressoSeHa2vagas() throws Exception {
		
		Sessao sessao = new SessaoBuilder().comTotalIngressos(2).constroi();

		Assert.assertFalse(sessao.podeReservar(3));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		
		Sessao sessao = new SessaoBuilder().comTotalIngressos(5).comIngressosReservados(3).constroi();

		Assert.assertEquals(2, sessao.getIngressosDisponiveis().intValue());
	}
	
	@Test
	public void deveVenderTodosIngressosDisponiveis() throws Exception {
		
		Sessao sessao = new SessaoBuilder().comTotalIngressos(2).constroi();
		
		Assert.assertTrue(sessao.podeReservar(2));
	}
	
	
	
}
