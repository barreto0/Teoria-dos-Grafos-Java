import java.util.ArrayList;
import java.util.List;

public class Grafo {
	List<Vertice> vertices = new ArrayList<Vertice>();
	List<Aresta> arestas = new ArrayList<Aresta>();
	List<Aresta> alcancaveis = new ArrayList<Aresta>();
	
	
	Grafo(List<Vertice> vertices){
		this.vertices = vertices;
		
	}
	
	public void inicializa() {
		for(int i =0;i<vertices.size();i++) {
			for(int j =0;j<vertices.size();j++) {
				Aresta aresta = new Aresta(vertices.get(i),vertices.get(j));
				aresta.calculaDistancia(vertices.get(i).getLatitude(), vertices.get(i).getLongitude(), vertices.get(j).getLatitude(), vertices.get(j).getLongitude());
				arestas.add(aresta);
				
			}
		}

	}
	
	public void alcancavel(double raio) {
		for(int i = 0;i<arestas.size();i++) {
			if(arestas.get(i).v.nome.equals("Usuario")) {
				if(arestas.get(i).distancia<=raio) {
					//System.out.println("alcançavel: "+arestas.get(i).w.nome+" distancia: "+arestas.get(i).distancia);
					alcancaveis.add(arestas.get(i));
				}
			}
		}
	}
	public void printaAlcancaveis() {
		System.out.println("Profissionais ao seu alcance: ");
		for(int i = 0;i<alcancaveis.size();i++) {
			if(alcancaveis.get(i).w.disp == true) {
				System.out.println(i+" "+" disponível "+alcancaveis.get(i).w.nome+" "+alcancaveis.get(i).w.profissao+" "+"está a "+alcancaveis.get(i).distancia+" kms de distância");
			}else {
				System.out.println(i+" "+" INDISPONÍVEL "+alcancaveis.get(i).w.nome+" "+alcancaveis.get(i).w.profissao+" "+"está a "+alcancaveis.get(i).distancia+" kms de distância");
			}
			
		}
		
	}
	
	public List<Aresta> profsAlcancaveis() {
		return alcancaveis;
	}

}
