package com.savioduarte.cadastroprodutos.model;

public class Produto {



	private String nome;
	private int quantidade;
	private double preco;
	private double totalPreco;
	

	public Produto(String nome, int quantidade, double preco, double totalPreco) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		this.totalPreco = totalPreco;
	}
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getTotalPreco() {
		return totalPreco;
	}
	public void setTotalPreco(double totalPreco) {
		this.totalPreco = totalPreco;
	}


	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", quantidade=" + quantidade + ", preco=" + preco + ", totalPreco="
				+ totalPreco + "]";
	}
	
	
}
