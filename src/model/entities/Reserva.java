package model.entities;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	private Integer nrQuarto;
	private Date entrada;
	private Date saida;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {		
	}

	public Reserva(Integer nrQuarto, Date entrada, Date saida) {
		this.nrQuarto = nrQuarto;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getNrQuarto() {
		return nrQuarto;
	}

	public void setNrQuarto(Integer nrQuarto) {
		this.nrQuarto = nrQuarto;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSaida() {
		return saida;
	}
	
	 // Usa o tipo "long" porque haverá cálculos de datas e é melhor.
	public long duracao() {	
		// Diferença em milissegundos
		long diff = saida.getTime() - entrada.getTime(); 		
		// Converte os milissegundos que esta na variavel "diff" para dias	}
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); 	
	}
	
	public void attDatas(Date entrada, Date saida) {
		this.entrada = entrada;
		this.saida = saida;
	}
	
	public String toSgtring() {
		return    "Quarto         : " + nrQuarto + "\n"
				+ "Data de entrada: " + sdf.format(entrada)+ "\n"
				+ "Data de saída  : " + sdf.format(saida)+ "\n"
				+ "Total de dias  : " + duracao() + " noites.";
	}
}
