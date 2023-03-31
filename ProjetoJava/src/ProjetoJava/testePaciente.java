package ProjetoJava;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import projeto.util.Cores;

public class testePaciente {

	public static void main(String[] args) { 
		int opcao; 
		boolean repeticao = true;
		int idade;
		double peso, altura;
		Scanner leia = new Scanner(System.in); 
		int indice1; 
		
		List<Paciente> pacientes = new ArrayList<>();
		
		
		while(repeticao == true) {
			
			System.out.println(Cores.TEXT_CYAN_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "========================================================");
			System.out.println("                                                        ");
			System.out.println("                CONTROLE DE PACIENTES                   ");
			System.out.println("                                                        ");
			System.out.println("========================================================");
			System.out.println("                                                        ");
			System.out.println("              1 - Cadastro de Novo Paciente             ");
			System.out.println("              2 - Exibir lista de Pacientes             ");
			System.out.println("              3 - Editar dados do Paciente              ");
			System.out.println("              4 - Apagar dados do Paciente              ");
			System.out.println("              5 - Buscar Paciente                       ");
			System.out.println("              6 - Calcular IMC                          ");
			System.out.println("              0 - Sair                                  ");
			System.out.println("                                                        ");
			System.out.println("========================================================");
			System.out.println("Entre com a opção desejada ou digite 0 para sair:       ");
			System.out.println("                                                        "/*+ Cores.TEXT_RESET*/);
			
			

			while(true) {		
				try {
					opcao = leia.nextInt();
					break; 
					
				} catch(InputMismatchException e) {
					System.out.println(Cores.TEXT_RED_BOLD_BRIGHT +Cores.ANSI_BLACK_BACKGROUND+"valor invalido, tente novamente com uma das opções do menu: " + Cores.TEXT_RESET + Cores.TEXT_CYAN_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
					leia.nextLine();
			}
				}
			
			if (opcao == 0) {
				System.out.println(
						Cores.TEXT_GREEN_BRIGHT+ Cores.ANSI_BLACK_BACKGROUND + "\nObrigado por utilizar nosso programa!");
				leia.close();
				System.exit(0);}
			
			switch(opcao) {
			
			case 1:
				boolean loop = true;
				int op;
				while (loop == true) {

				    System.out.println("Nome do paciente: ");
				    String nome = leia.next();
				    System.out.println("Qual tipo sanguineo?");
				    String tipoSanguineo = leia.next();
				    System.out.println("Qual o sexo?");
				    String genero = leia.next();

				    while (true) {
				        try {
				            System.out.println("Qual a idade do paciente?");
				            idade = leia.nextInt();
				            break; // sai do loop 
				        } catch (InputMismatchException e) {
				        	System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Valor inválido: digite um valor numérico!" + Cores.TEXT_RESET + Cores.TEXT_CYAN_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
				            leia.nextLine(); // limpa o scanner 
				        }
				    }
				    while (true) {
				        try {
				            System.out.println("Qual o peso do paciente?");
				            peso = leia.nextDouble();
				            break; 
				        } catch (InputMismatchException e) {
				        	System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Valor inválido: digite um valor numérico!"+ Cores.TEXT_RESET + Cores.TEXT_CYAN_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
				            leia.nextLine(); 
				        }
				    }

				    
				    while (true) {
				        try {
				            System.out.println("Qual a altura do paciente?");
				            altura = leia.nextDouble();
				            break; 
				        } catch (InputMismatchException e) {
				        	System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Valor inválido: digite um valor numérico!"+ Cores.TEXT_RESET + Cores.TEXT_CYAN_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
				            leia.nextLine(); 
				        }
				    }
				    pacientes.add(new Paciente(nome, tipoSanguineo, genero, idade, peso, altura));
			        System.out.println("Paciente adicionado com sucesso!");

				    System.out.println("Deseja adicionar outro paciente? ");
				    System.out.println("[1] Sim \n[2] Não");
				    
				    while(true) {		
						try {
							op = leia.nextInt();
							break; 
							
						} catch(InputMismatchException e) {
							System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Valor inválido: escolha uma opção do menu!"+ Cores.TEXT_RESET + Cores.TEXT_CYAN_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
							leia.nextLine();
					}
						}

				    if (op == 1) {
				        loop = true;
				    } else if (op == 2) {
				        loop = false;
				    } else {
				    	System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Valor inválido: escolha uma opção do menu!"+ Cores.TEXT_RESET + Cores.TEXT_CYAN_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
				        op = leia.nextInt();
				    }
				}

				break;
			case 2: //larissa 
				
				if (pacientes.isEmpty()){
					System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "A lista está vazia.                                     "+ Cores.TEXT_RESET + Cores.TEXT_CYAN_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
					}
				else {
					for(Paciente i:pacientes) {
						System.out.println((pacientes.indexOf(i) + 1) + "° paciente");
						i.visualizar(); }
				}	
				break;
			
			case 3: 
				
				
				while(true) {		
					try {
						System.out.println("Deseje o indice que deseja editar: ");
						indice1 = leia.nextInt();
						break; 
					} catch(InputMismatchException e) {
						System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Valor inválido: digite um valor numérico!"+ Cores.TEXT_RESET + Cores.TEXT_CYAN_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
						leia.nextLine();
						continue;
				}
					}
				
				indice1 = indice1 - 1;

				if(indice1 > pacientes.size() || pacientes.isEmpty()) {
					System.out.println("\nO paciente não existe!");
				}
				else if (pacientes.size() > indice1) {
					System.out.println("O que deseja editar?        ");
					System.out.println("1. Nome \n2. Idade \n3. genero \n4. Peso \n5. Altura \n6. Tipo sanguineo  ");
					
					int op1 = leia.nextInt();
					
					switch(op1) {
					
					case 1: 
						System.out.println("Novo nome: ");
						String novoNome = leia.next();
						pacientes.get(indice1).setNome(novoNome);
						
						break;
					case 2:
						System.out.println("Nova idade: ");
						int novaIdade = leia.nextInt();
						pacientes.get(indice1).setIdade(novaIdade);
				
						break; 
					case 3:
						System.out.println("Novo genero: ");
						String novoGenero = leia.next();
						pacientes.get(indice1).setGenero(novoGenero);
						
						break; 
					case 4: 
						double novoPeso;
					    while (true) {
					        try {
					        	System.out.println("Novo peso: ");
					        	novoPeso = leia.nextDouble();
					            break; 
					        } catch (InputMismatchException e) {
					        	System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Valor inválido: digite um valor numérico!"+ Cores.TEXT_RESET + Cores.TEXT_CYAN_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
					            leia.nextLine(); 
					        }
					    }
						pacientes.get(indice1).setPeso(novoPeso);
						break; 
					case 5: 
						
						double novaAltura;
					    while (true) {
					        try {
					        	System.out.println("Nova altura: ");
					        	novaAltura = leia.nextDouble();
					            break; 
					        } catch (InputMismatchException e) {
					        	System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Valor inválido: digite um valor numérico!" + Cores.TEXT_RESET + Cores.TEXT_CYAN_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
					            leia.nextLine(); 
					        }
					    }
						
						pacientes.get(indice1).setAltura(novaAltura);
						
						break; 
					case 6: 
						System.out.println("Novo tipo sanguineo: ");
						String novoTipoSanguineo = leia.next();
						pacientes.get(indice1).setTipoSanguineo(novoTipoSanguineo);
						
						break; 	
					}
				}
				
				break;
				
			case 4: 
				
				System.out.println("\nDigite o indice do paciente que deseja remover: ");
				
				int index = leia.nextInt();
				index = index - 1;
				if(index < pacientes.size()) {
					pacientes.remove(index);	
				}
				else if (pacientes.size() <= index) {
					System.out.println("\nEste paciente não existe!");
				}
		
				break;
				
			case 5: 
				
				// Buscar paciente
				System.out.println("\nDigite o nome do paciente que desejar encontar: ");
				String buscarNome = leia.next();
				boolean Encontrado = false;
				for (int i = 0; i < pacientes.size(); i++) {
					Paciente paciente = pacientes.get(i);
					if (paciente.getNome().equalsIgnoreCase(buscarNome)) {
						System.out.println("\nPaciente encontrado: ");
						System.out.println((i+1) + "° paciente: " );
						paciente.visualizar();
						Encontrado = true;
					}
					
					}
				if (!Encontrado) {
					System.out.println("Paciente " + buscarNome + " não foi encontrado: ");
					break;
				}
				
				break;
				
			case 6:
				// calcular imc
				int iPaciente;
				while (true) {
			        try {
			        	System.out.println("Indice do paciente: ");
			        	iPaciente = leia.nextInt();
			        	//Paciente paciente = pacientes.get(iPaciente - 1 );
	
			            break; 
			        } catch (InputMismatchException e) {
			        	System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND+"Valor inválido: digite um valor numérico!"+ Cores.TEXT_RESET + Cores.TEXT_CYAN_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
			            leia.nextLine(); 
			        }}
				iPaciente = iPaciente - 1;
					
				if(iPaciente > pacientes.size() || pacientes.isEmpty()) {
					System.out.println("\nO paciente não existe!");
				}
				else if (pacientes.size() > iPaciente) {
					pacientes.get(iPaciente).calcularImc(iPaciente);
				
				}
			break; 
			case 0: // larissa
				System.out.println("\nVolte sempre!");
				repeticao = false;
				break;
				default: 
					System.out.println("Valor invalido, tente uma das opções do menu."+ Cores.TEXT_RESET + Cores.TEXT_CYAN_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
					break;
				
			}
			
			
		}
		

	}

	}