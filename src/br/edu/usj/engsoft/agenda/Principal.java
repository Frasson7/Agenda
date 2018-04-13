package br.edu.usj.engsoft.agenda;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Principal {

	static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

	public static Integer lerInteiro() throws Exception {
		Integer valor = null;
		while (valor == null) {
			try {
				valor = Integer.parseInt(entrada.readLine());
			} catch (NumberFormatException e) {
				System.out.print(">>> N�o entendi. Por favor, digite um n�mero inteiro: ");
			}
		}
		return valor;
	}

	public static void main(String[] args) throws Exception {
		Agenda agenda = new Agenda();
		System.out.println("Seja bem vindo � Agenda!");
		while (true) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("Menu principal:");
			System.out.println("1 - Mostrar agenda");
			System.out.println("2 - Marcar evento");
			System.out.print(">>> Digite uma op��o (deixe em branco para sair): ");
			String op��o = entrada.readLine();
			if (op��o.isEmpty()) {
				return;
			} else if (op��o.equals("1")) {
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("1 - Mostrar agenda:");

				agenda.mostrarAgenda();
			} else if (op��o.equals("2")) {
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("2 - Marcar evento:");

				System.out.print("T�tulo: ");
				String t�tulo = entrada.readLine();

				System.out.print("Dia in�cio: ");
				Integer diaIn�cio = lerInteiro();
				System.out.print("M�s in�cio: ");
				Integer m�sIn�cio = lerInteiro();
				System.out.print("Ano in�cio: ");
				Integer anoIn�cio = lerInteiro();
				Data dataIn�cio = new Data();
				dataIn�cio.setDia(diaIn�cio);
				dataIn�cio.setM�s(m�sIn�cio);
				dataIn�cio.setAno(anoIn�cio);

				System.out.print("Dia fim: ");
				Integer diaFim = lerInteiro();
				System.out.print("M�s fim: ");
				Integer m�sFim = lerInteiro();
				System.out.print("Ano fim: ");
				Integer anoFim = lerInteiro();
				Data dataFim = new Data(diaFim, m�sFim, anoFim);

				Evento e = new Evento(t�tulo, dataIn�cio, dataFim);
				if (agenda.adicionarEvento(e)) {
					System.out.println(">>> Evento marcado com sucesso!");
				} else {
					System.out.println(">>> Evento em conflito!");
				}
			} else {
				System.out.println(">>> H�?! N�o entendi...");
			}
		}
	}

}
