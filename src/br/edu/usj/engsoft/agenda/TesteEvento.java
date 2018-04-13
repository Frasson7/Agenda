package br.edu.usj.engsoft.agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteEvento {

	@Test
	void testaTitulo() {
		Evento e = new Evento();
		e.setT�tulo("X");
		assertEquals("X", e.getT�tulo());
	}
	
	@Test
	void testaConflitaCom_SemConflito() {
		Evento e1 = new Evento();
		e1.setT�tulo("E1");
		e1.setDataIn�cio(new Data(1, 1, 2000));
		e1.setDataFim(new Data(1, 1, 2000));
		
		Evento e2 = new Evento();
		e2.setT�tulo("E2");
		e2.setDataIn�cio(new Data(2, 1, 2000));
		e2.setDataFim(new Data(2, 1, 2000));
		
		assertFalse(e1.conflitaCom(e2));
	}
	
	@Test
	void testaConflitaCom_ComConflito() {
		Evento e1 = new Evento();
		e1.setT�tulo("E1");
		e1.setDataIn�cio(new Data(1, 1, 2000));
		e1.setDataFim(new Data(1, 1, 2000));
		
		Evento e2 = new Evento();
		e2.setT�tulo("E2");
		e2.setDataIn�cio(new Data(1, 1, 2000));
		e2.setDataFim(new Data(2, 1, 2000));
		
		assertTrue(e1.conflitaCom(e2));
	}
	
	@Test
	void testaSetDataInicioEFimTrocados1() {
		Evento e = new Evento();
		
		e.setDataIn�cio(new Data(2, 1, 2000));
		try {
			e.setDataFim(new Data(1, 1, 2000));
			fail("Deveria ter dado erro!");
		} catch (IllegalArgumentException ex) {
		}
	}
	
	@Test
	void testaSetDataInicioEFimTrocados2() {
		Evento e = new Evento();
		
		e.setDataFim(new Data(1, 1, 2000));
		try {
			e.setDataIn�cio(new Data(2, 1, 2000));
			fail("Deveria ter dado erro!");
		} catch (IllegalArgumentException ex) {
		}
	}


}
