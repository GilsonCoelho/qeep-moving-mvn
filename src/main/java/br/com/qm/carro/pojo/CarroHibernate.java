package br.com.qm.carro.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class CarroHibernate {
	
	@Id
	private String placa;
	private String cor;
	private String marca;
	private String modelo;
	private int ano;
	@Column(name = "vel_max")
	private float velMax;
			
	public CarroHibernate(String placa, String cor, String marca, String modelo, int ano, float velMax) {
		super();
		this.placa = placa;
		this.cor = cor;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.velMax = velMax;
	}

	public CarroHibernate() {
		
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public float getVelMax() {
		return velMax;
	}

	public void setVelMax(float velMax) {
		this.velMax = velMax;
	}

	@Override
	public String toString() {
		return "CarroHibernate [placa=" + placa + ", cor=" + cor + ", marca=" + marca + ", modelo=" + modelo + ", ano="
				+ ano + ", velMax=" + velMax + "]";
	}
	
	


}
