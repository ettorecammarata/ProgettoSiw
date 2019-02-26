package model;

public class IndiceDiGradimento {
	
	private double sommaVoto;
	private Integer votoAttuale;	
	private Integer numeroVoti;
	
	
	public IndiceDiGradimento(double sommaVoto, Integer votoAttuale, Integer numeroVoti) {
		super();
		this.sommaVoto = sommaVoto;
		this.votoAttuale = votoAttuale;
		this.numeroVoti = numeroVoti;
	}
	public IndiceDiGradimento(Integer votoAttuale) {
		super();
	
		this.votoAttuale = votoAttuale;
		
	}
	
	public IndiceDiGradimento() {
		super();
	}



	public double getSommaVoto() {
		return sommaVoto;
	}
	public void setSommaVoto(double sommaVoto) {
		this.sommaVoto = sommaVoto;
	}
	public Integer getVotoAttuale() {
		return votoAttuale;
	}
	public void setVotoAttuale(Integer votoAttuale) {
		this.votoAttuale = votoAttuale;
	}
	public Integer getNumeroVoti() {
		return numeroVoti;
	}
	public void setNumeroVoti(Integer numeroVoti) {
		this.numeroVoti = numeroVoti;
	}
	
	
	
	
	
	

	


}
