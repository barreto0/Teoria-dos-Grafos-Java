import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception{
		
		File arquivo = new File("/home/barreto/Documents/Programacao/eclipse-workspace/dados.txt"); 
		List<Integer> dados = new ArrayList<Integer>();
		Grafo grafo = new Grafo();
		  
		try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
			String str; 
			
			
			while ((str = br.readLine()) != null) {
				
				String[] tokens = str.split(",");
				
				if(str.contains(",")) {
					
					int vPartida = Integer.parseInt(tokens[0]);
					int vChegada = Integer.parseInt(tokens[1]);
					dados.add(vPartida);
					dados.add(vChegada);
					
				}else {
					int dado = Integer.parseInt(str);
					dados.add(dado);
					
				}
					
			}
			//System.out.println(dados); 

		}catch(IOException e) {
			System.out.println("Falha ao Abrir o Arquivo");
		}
		
		grafo.inicializa(dados.get(0));
			 
		for(int i = 3;i<dados.size();i+=2) {
			
			grafo.colocaAresta(dados.get(i), dados.get(i+1));
			
		}
		grafo.mostra(); 
		System.out.println();

		int partida = dados.get(1);
		int chegada = dados.get(2);
		System.out.println("Vértice de partida: "+ partida);
		System.out.println("Vértice de chegada: "+ chegada);
		System.out.println();
		CaminhosPossiveis p = new CaminhosPossiveis();
		System.out.println("Quantidade de caminhos possíveis: "+ p.contaCaminho(grafo, partida, chegada));
		CaminhoMaisCurto c = new CaminhoMaisCurto();
		c.melhorCaminho(grafo, partida, chegada);
		

	}

}
