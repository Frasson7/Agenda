package br.edu.usj.engsoft.agenda;

public class Evento {

	private String t�tulo;
	private Data dataIn�cio;
	private Data dataFim;
	
	public Evento() {
	}
	
	public Evento(String t�tulo, Data dataIn�cio, Data dataFim) {
		if (dataIn�cio.compareTo(dataFim) > 0)
			throw new IllegalArgumentException("Data in�cio maior que fim");
		
		this.t�tulo = t�tulo;
		this.dataIn�cio = dataIn�cio;
		this.dataFim = dataFim;
	}

	public Data getDataFim() {
		return dataFim;
	}

	public void setDataFim(Data dataFim) {
		if (dataIn�cio != null && 
				dataFim.compareTo(dataIn�cio) < 0)
			throw new IllegalArgumentException("Data fim menor que in�cio");
		this.dataFim = dataFim;
	}

	public Data getDataIn�cio() {
		return dataIn�cio;
	}

	public void setDataIn�cio(Data dataIn�cio) {
		if (dataFim != null &&
				dataIn�cio.compareTo(dataFim) > 0)
			throw new IllegalArgumentException("Data in�cio maior que fim");
		this.dataIn�cio = dataIn�cio;
	}

	public String getT�tulo() {
		return t�tulo;
	}

	public void setT�tulo(String t�tulo) {
		this.t�tulo = t�tulo;
	}

	public Boolean conflitaCom(Evento outroEvento) {
		return dataIn�cio.compareTo(outroEvento.dataFim) <= 0 
				&& dataFim.compareTo(outroEvento.dataIn�cio) >= 0;
	}

}
