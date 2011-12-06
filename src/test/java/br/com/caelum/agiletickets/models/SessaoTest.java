package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SessaoTest {

	Sessao sessao;

	@Before
	public void inicializa() {
		sessao = new SessaoBuilder().comTotalIngressos(8)
									.comIngressosReservados(6)
									.constroi();
	}
	
	@Test
	public void deveVender1ingressoSeHa2vagas() throws Exception {
		
        sessao.setTotalIngressos(2);

        Assert.assertTrue(sessao.podeReservar(1));
	}

	@Test
	public void naoDeveVender3ingressoSeHa2vagas() throws Exception {
		
		sessao.setTotalIngressos(2);

		Assert.assertFalse(sessao.podeReservar(3));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		
		sessao.setTotalIngressos(5);

		sessao.reserva(3);
		Assert.assertEquals(2, sessao.getIngressosDisponiveis().intValue());
	}
	
	@Test
	public void deveVenderTodosIngressosDisponiveis() throws Exception {
		sessao.setTotalIngressos(2);
		
		Assert.assertTrue(sessao.podeReservar(2));
	}
	
	
	
}
