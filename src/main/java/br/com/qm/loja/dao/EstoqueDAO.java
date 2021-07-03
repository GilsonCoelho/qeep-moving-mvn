package br.com.qm.loja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.qm.conn.ConnectionFactory;
import br.com.qm.loja.pojo.Estoque;

public class EstoqueDAO {
	
	private Connection conn;
	
	public EstoqueDAO(){
		this.conn = new ConnectionFactory().getConnection();
	}
	
public boolean inserePeca(Estoque estoque) {
		
		String sql = "INSERT INTO loja_de_pecas.peca"
				+ "	(cod_barras, nome, modelo_carro, fabricante, preco_custo, preco_venda, quantidade, categoria_peca)"
				+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, estoque.getCodBarra());
			stmt.setString(2, estoque.getNome());
			stmt.setString(3, estoque.getModeloCarro());
			stmt.setString(4, estoque.getFabricante());
			stmt.setFloat(5, estoque.getPrecoCusto());
			stmt.setFloat(6, estoque.getPrecoVenda());
			stmt.setInt(7, estoque.getQuantidadeEstoque());
			stmt.setString(8, estoque.getCategoria());
			
			stmt.execute();			
			stmt.close();
		} catch (SQLException e) {
			System.err.println("Erro ao cadastra uma peça!");
			System.err.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	public boolean removePeca(int codBarra) {
		
		String sql = "delete from loja_de_pecas.peca where cod_barras = ?";
		PreparedStatement stmt;
		int qtdLinhas = 0;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, codBarra);
			
			qtdLinhas = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			System.err.println("Erro ao remover uma peça!");
			System.err.println(e.getMessage());
		}
		
		
		return qtdLinhas > 0;
	}
	
	public Estoque consultaPeca(int codBarra) {
		
		String sql = "select * from loja_de_pecas.peca where cod_barras = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, codBarra);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				
				Estoque estoque = new Estoque();
				
				estoque.setCodBarra(rs.getInt("cod_barras"));
				estoque.setNome(rs.getString("nome"));
				estoque.setModeloCarro(rs.getString("modelo_carro"));
				estoque.setFabricante(rs.getString("fabricante"));
				estoque.setPrecoCusto(rs.getFloat("preco_custo"));
				estoque.setPrecoVenda(rs.getFloat("preco_venda"));
				estoque.setQuantidadeEstoque(rs.getInt("quantidade"));
				estoque.setCategoria(rs.getString("categoria_peca"));
				
				
				stmt.close();
				return estoque;
			}
			
			
			
		} catch (SQLException e) {
			System.err.println("Erro ao consultar um carro!");
			System.err.println(e.getMessage());
		}
		
		
		
		return null;
	}
	public List<Estoque> listarPecas() {
		
		List<Estoque> estoques = new ArrayList<Estoque>();
		String sql = "select * from loja_de_pecas.peca";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {				
				Estoque estoque = new Estoque();
				
				estoque.setCodBarra(rs.getInt("cod_barras"));
				estoque.setNome(rs.getString("nome"));
				estoque.setModeloCarro(rs.getString("modelo_carro"));
				estoque.setFabricante(rs.getString("fabricante"));
				estoque.setPrecoCusto(rs.getFloat("preco_custo"));
				estoque.setPrecoVenda(rs.getFloat("preco_venda"));
				estoque.setQuantidadeEstoque(rs.getInt("quantidade"));
				estoque.setCategoria(rs.getString("categoria_peca"));
				
				estoques.add(estoque);
			}
			
			stmt.close();
		} catch (SQLException e) {
			System.err.println("Erro ao listar peças!");
			System.err.println(e.getMessage());
		}
		
		
		
		return estoques;
	}
	
//	public List<Estoque> listarPecas() {
//		
//		List<Estoque> estoques = new ArrayList<Estoque>();
//		String sql = "select * from loja_de_pecas.peca";
//		
//		try {
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			ResultSet rs = stmt.executeQuery();
//			
//			while (rs.next()) {				
//				Estoque estoque = new Estoque();
//				
//				estoque.setCodBarra(rs.getInt("codBarra"));
//				estoque.setNome(rs.getString("nome"));
//				estoque.setModeloCarro(rs.getString("modeloCarro"));
//				estoque.setFabricante(rs.getString("fabricante"));
//				estoque.setPrecoCusto(rs.getFloat("precoCusto"));
//				estoque.setPrecoVenda(rs.getFloat("precoVenda"));
//				estoque.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
//				estoque.setCategoria(rs.getString("categoria"));
//				
//				estoques.add(estoque);
//			}
//			
//			stmt.close();
//		} catch (SQLException e) {
//			System.err.println("Erro ao listar peças!");
//			System.err.println(e.getMessage());
//		}
//		
//		
//		
//		return estoques;
//	}



}
