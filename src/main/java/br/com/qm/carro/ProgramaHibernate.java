package br.com.qm.carro;

import java.util.List;
import java.util.Scanner;

import br.com.qm.carro.dao.CarroDAO;
import br.com.qm.carro.dao.CarroHibernateDAO;
import br.com.qm.carro.pojo.Carro;
import br.com.qm.carro.pojo.CarroHibernate;



public class ProgramaHibernate {

	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		CarroHibernateDAO carroDao = new CarroHibernateDAO();
		
		int opcao = 0;
		
		do {
			System.out.println("-- Menu Carros -- ");
			System.out.println("1 - inserir");
			System.out.println("2 - listar");
			System.out.println("3 - consultar");
			System.out.println("4 - remover");
			System.out.println("0 - sair");
			opcao = teclado.nextInt();
			
			switch (opcao) {
				
				case 1:
					System.out.println("- Inserção -");
					System.out.println("Digite a placa do carro: ");
					String placa = teclado.next();
					System.out.println("Digite a cor do carro: ");
					String cor = teclado.next();
					System.out.println("Digite a marca do carro: ");
					String marca = teclado.next();
					System.out.println("Digite o modelo do carro: ");
					String modelo = teclado.next();
					
					
					 if (carroDao.insereCarro(new CarroHibernate(placa, cor, marca, modelo,1970,110F))) {
						 System.out.println("Carro inserido com sucesso!");
					 }
					 break;
				case 2:
					System.out.println("- Listagem -");
					List<CarroHibernate> carros = carroDao.listarCarros();
					for (CarroHibernate carro : carros) {
						System.out.println(carro);
					}
					break;
				case 3:
					System.out.println("- Consulta -");
					System.out.println("Digite a placa a ser consultada: ");
					String placaConsulta = teclado.next();
					
					CarroHibernate carroConsultado = carroDao.consultaCarro(placaConsulta);
					
					if (carroConsultado != null) {
						System.out.println(carroConsultado);
					}
					break;
				case 4:
					System.out.println("- Remoção -");
					System.out.println("Digite a placa a ser removida: ");
					String placaRemovida = teclado.next();
					
					
					
					if (carroDao.removeCarro(placaRemovida)) {
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
