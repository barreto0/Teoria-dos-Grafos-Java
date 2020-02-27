/*
----Trabalho T2---------------------------------------------------------------------------------------------------
	
----Disciplina: Teoria dos Grafos---------------------------------------------------------------------------------
	
----Professor: Pergentino-----------------------------------------------------------------------------------------
	
----Aluno/Autor: Gabriel Antônio de Vasconcellos Barreto----------------------------------------------------------
	
----Matrícula: 1622082022-----------------------------------------------------------------------------------------

*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) {


		File arquivo = new File("/home/barreto/Documents/Programacao/eclipse-workspace/projeto_t2_dados.txt"); 
		//List<String> dados = new ArrayList<String>();
		List<Vertice> vertices = new ArrayList<Vertice>();
		Vertice usuario = new Vertice();
		usuario.setNome("Usuario");
		usuario.setLatitude(-15.836073);
		usuario.setLongitude(-47.912019);
		usuario.setProfissao("user");
		usuario.setDisp(true);
		vertices.add(usuario);


		List<Vertice> escolhaProfissionais = new ArrayList<Vertice>();


		try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
			String str; 

			while ((str = br.readLine()) != null) {
				Vertice vertice = new Vertice();

				String[] tokens = str.split(";");

				String nome = tokens[0];
				//dados.add(nome);
				vertice.setNome(nome);
				String coord = tokens[1];
				if(coord.contains(",")) {
					String[] latlong = coord.split(",");
					//String latitude = latlong[0];
					//String longitude = latlong[1];
					//dados.add(latitude);
					//dados.add(longitude);
					double latitude = Double.parseDouble(latlong[0]);
					double longitude = Double.parseDouble(latlong[1]);
					vertice.setLatitude(latitude);
					vertice.setLongitude(longitude);
				}
				String profissao = tokens[2];
				vertice.setProfissao(profissao);
				//dados.add(profissao);
				boolean disp = Boolean.parseBoolean(tokens[3]);
				vertice.setDisp(disp);
				//dados.add(disp);
				//dados.add(coord);
				//vertice.printa();
				vertices.add(vertice);

			}


		}catch(IOException e) {
			System.out.println("Falha ao Abrir o Arquivo");
		}
		Grafo grafo = new Grafo(vertices);
		grafo.inicializa();


		Scanner input2 = new Scanner(System.in);
		double raioMax;
		System.out.println("Insira o raio máximo (em quilômetros): ");
		raioMax = Double.parseDouble(input2.nextLine());
		//input2.close();

		grafo.alcancavel(raioMax);
		//	grafo.printaAlcancaveis();



		int opcao=-1;
		do {
			grafo.printaAlcancaveis();
			System.out.println();
			System.out.println("################### Digite 0 para sair ou finalizar a escolha de Profissonais ########################");
			System.out.println();
			System.out.println("Insira o número correspondente ao usuário que deseja escolher: ");
			System.out.println();
			System.out.println("Profissionais Escolhidos: ");
			for(int i =0;i<escolhaProfissionais.size();i++) {
				System.out.println(escolhaProfissionais.get(i).printaOpcoes());
			}	
			Scanner input = new Scanner(System.in);
			opcao = Integer.parseInt(input.nextLine());
			if(opcao == 0) {
				System.out.println("ENCERRADO");
				break;
			}
			if(grafo.profsAlcancaveis().get(opcao).w.disp == false) {
				System.out.println("Profissional Indisponível");
			}else {

				escolhaProfissionais.add(grafo.profsAlcancaveis().get(opcao).w);
			}


		}while(opcao!=0);

		
		escolhaProfissionais.add(0, usuario);

		for(int i =0;i<escolhaProfissionais.size();i++) {
			escolhaProfissionais.get(i).setIndex(i);
			System.out.println(escolhaProfissionais.get(i).getIndex()+" "+ escolhaProfissionais.get(i).printaOpcoes());
		}

		Grafo vai = new Grafo(escolhaProfissionais);
		vai.inicializa();
		for(int i = 0;i<vai.vertices.size();i++) {
			vai.vertices.get(i).printa();
		}

		//////////////////////////////////////////////////////////////////////////////////////////////////

		int V = vai.vertices.size();	
		List<List<Node>> novoGrafo = new ArrayList<List<Node>>(); 


		for (int i = 0; i < V; i++) { 
			List<Node> conteudo = new ArrayList<Node>(); 
			novoGrafo.add(conteudo); 
		} 

		for(int i = 0;i<vai.arestas.size();i++) {
			Node node = new Node(vai.arestas.get(i).w.getIndex(),vai.arestas.get(i).distancia);

			if(vai.arestas.get(i).distancia !=0 && vai.arestas.get(i).distancia > 9.503960609436035E-5) { //bug lascado
				novoGrafo.get(vai.arestas.get(i).v.getIndex()).add(node);	
			}
		}


		for(int i = 0;i<novoGrafo.size();i++) {
		//	System.out.println(i+" "+ novoGrafo.get(i));

		}
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		List<Integer> visitados = new ArrayList<Integer>();
		List<Double> distancia = new ArrayList<Double>();
		List<Integer> controleIndex = new ArrayList<Integer>();
		double ordenado[] = new double[V]; 
		int origem =0;


		for(int i = 0;i<V;i++) {
			

			if(controleIndex.isEmpty()) {
				origem = i;
				visitados.add(i);
			}else {

				origem = controleIndex.get(i-1);
				visitados.add(controleIndex.get(i-1));
				if(visitados.contains(origem)) {
					for(int j = 0;j<novoGrafo.get(origem).size();j++) {
						if(!visitados.contains(novoGrafo.get(origem).get(j).node) && !distancia.contains(novoGrafo.get(origem).get(j).peso)){
							origem = novoGrafo.get(origem).get(j).node;
							
							
						}
					}
				}
			}
			
				
				
			Djikstra dpq = new Djikstra(V); 
			dpq.dijkstra(novoGrafo, origem); 

			List<Double> dpqDistList = new ArrayList<Double>();

			//System.out.println("Caminho mais curto da origem: "); 
			for (int j = 0; j < dpq.distancia.length; j++) {
				if(dpq.distancia[j]!=0) {
					dpqDistList.add(dpq.distancia[j]);
				}

				//System.out.println("Distância de "+ origem + " até " + j + " é " + dpq.distancia[j]); 

			} 
			
			

			//System.out.println(dpqDistList);
			int minIndex = dpqDistList.indexOf(Collections.min(dpqDistList));
			//System.out.println(Collections.min(dpqDistList));
			controleIndex.add(minIndex+1);
			//System.out.println(controleIndex);



			ordenado = dpq.distancia;

			Arrays.sort(ordenado);


			for(int k = 0;k<ordenado.length;k++) {
				
				//System.out.println(ordenado[k]);
			}

			
			
			for(int l = 1;l<ordenado.length;l++) { 
				if(!distancia.contains(ordenado[l])) {
					distancia.add(ordenado[l]); 

					break;
				}else { 
					distancia.add(ordenado[l+1]);

					break; 
				}
			}


		}

		System.out.println();   
		System.out.println();  
		//System.out.println(visitados);
		//System.out.println(distancia);
		//System.out.println(controleIndex);

		for(int i = 0; i<escolhaProfissionais.size();i++) {
			for(int j = 0; j<visitados.size();j++) {
				if(escolhaProfissionais.get(i).index == visitados.get(j)) {
					System.out.print(escolhaProfissionais.get(j).printaFinal());
					System.out.print(" -> ");
				}
			}
		}
		System.out.print(" Usuario ");
		System.out.println(); 
		double custoTotal = 0;
		for(int i = 0;i<distancia.size();i++) {
			custoTotal = custoTotal + distancia.get(i);
		}

		System.out.println("Distância Total percorrida pelo usuário saindo e voltando para casa:  "+custoTotal+" km's");

	}
}
