package br.com.qm.loja;

import java.util.List;
import java.util.Scanner;

import br.com.qm.loja.dao.EstoqueDAO;
import br.com.qm.loja.pojo.Estoque;

public class ProgramaPrincipal {

	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		EstoqueDAO estoqueDao = new EstoqueDAO();
		
		int opcao = 0;
		
		do {
			System.out.println("-- Menu Peças -- ");
			System.out.println("1 - inserir");
			System.out.println("2 - listar");
			System.out.println("3 - consultar");
			System.out.println("4 - remover");
			System.out.println("0 - sair");
			opcao = teclado.nextInt();
			
			switch (opcao) {
				
				case 1:
					System.out.println("- Inserção -");
					System.out.println("Digite o código da peça: ");
					int codBarra = teclado.nextInt();
					System.out.println("Digite o nome da peça: ");
					String nome = teclado.next();
					System.out.println("Digite o modelo do carro: ");
					String modeloCarro = teclado.next();
					System.out.println("Digite o fabricante do carro: ");
					String fabricante = teclado.next();
					System.out.println("Digite o preço de custo: ");
					Float precoCusto = teclado.nextFloat();
					System.out.println("Digite o preço de Venda: ");
					Float precoVenda = teclado.nextFloat();
					System.out.println("Digite a quantidade: ");
					int quantidadeEstoque = teclado.nextInt();
					System.out.println("Digite o categoria da peça: ");
					String categoria = teclado.next();
					
					
					
					 if (estoqueDao.inserePeca(new Estoque(codBarra, nome, modeloCarro, fabricante, precoCusto, precoVenda, quantidadeEstoque, categoria))) {
						 System.out.println("Peça inserido com sucesso!");
					 }
					 break;
				case 2:
					System.out.println("- Listagem -");
					List<Estoque> estoques = estoqueDao.listarPecas();
					for (Estoque estoque : estoques) {
						System.out.println(estoque);
					}
					break;
				case 3:
					System.out.println("- Consulta -");
					System.out.println("Digite a peça a ser consultada: ");
					int pecaConsulta = teclado.nextInt();
					
					Estoque pecaConsultado = estoqueDao.consultaPeca(pecaConsulta);
					
					if (pecaConsultado != null) {
						System.out.println(pecaConsultado);
					}
					break;
				case 4:
					System.out.println("- Remoção -");
					System.out.println("Digite a peça a ser removida: ");
					int pecaRemovida = teclado.nextInt();
					
					
					
					if (estoqueDao.removePeca(pecaRemovida)) {
						System.out.println("Carro removido!");
					}
					break;
				case 0:
					System.out.println("Obrigado!");
					break;
				default:
					System.out.println("Opção inválida!");
			
			}
			
			
			
		} while (opcao != 0);
		
		
		teclado.close();
		
		
	}
	
}
