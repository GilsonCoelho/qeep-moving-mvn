package br.com.qm.loja.pojo;

public class Estoque {
	
	private int codBarra;
	private String nome;
	private String modeloCarro;
	private String fabricante;
	private Float precoCusto;
	private Float precoVenda;
	private int quantidadeEstoque;
	private String categoria;
	
	public Estoque() {		
	}	
	
	public Estoque(int codBarra, String nome, String modeloCarro, String fabricante, Float precoCusto, Float precoVenda,
			int quantidadeEstoque, String categoria) {
		
		this.codBarra = codBarra;
		this.nome = nome;
		this.modeloCarro = modeloCarro;
		this.fabricante = fabricante;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.quantidadeEstoque = quantidadeEstoque;
		this.categoria = categoria;
	}



	public int getCodBarra() {
		return codBarra;
	}



	public void setCodBarra(int codBarra) {
		this.codBarra = codBarra;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getModeloCarro() {
		return modeloCarro;
	}



	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}



	public String getFabricante() {
		return fabricante;
	}



	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}



	public Float getPrecoCusto() {
		return precoCusto;
	}



	public void setPrecoCusto(Float precoCusto) {
		this.precoCusto = precoCusto;
	}



	public Float getPrecoVenda() {
		return precoVenda;
	}



	public void setPrecoVenda(Float precoVenda) {
		this.precoVenda = precoVenda;
	}



	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}



	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	@Override
	public String toString() {
		return "Estoque [codBarra=" + codBarra + ", nome=" + nome + ", modeloCarro=" + modeloCarro + ", fabricante="
				+ fabricante + ", precoCusto=" + precoCusto + ", precoVenda=" + precoVenda + ", quantidadeEstoque="
				+ quantidadeEstoque + ", categoria=" + categoria + "]";
	}

	
	
	
	


}
