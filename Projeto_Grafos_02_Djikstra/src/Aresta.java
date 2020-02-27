public class Aresta {
	Vertice v;
	Vertice w;
	double distancia;
	
		
	Aresta(Vertice v, Vertice w){
		this.v = v;
		this.w = w;
		
	}
	
	public void calculaDistancia(double latitude1, double longitude1, double latitude2, double longitude2) {
		latitude1 = v.getLatitude();
		longitude1 = v.getLongitude();
		latitude2 = w.getLatitude();
		longitude2 = w.getLongitude();
		
		latitude1 = Math.toRadians(latitude1);
		longitude1 = Math.toRadians(longitude1);
		latitude2 = Math.toRadians(latitude2);
		longitude2 = Math.toRadians(longitude2);

        double raioTerra = 6378; //kms
        double distancia = raioTerra * Math.acos(Math.sin(latitude1)*Math.sin(latitude2) + Math.cos(latitude1)*Math.cos(latitude2)*Math.cos(longitude1 - longitude2));
        this.distancia = distancia;
        //System.out.println("distância entre "+v.getNome()+" e "+w.getNome()+": "+distancia+" km's");
        
    }

}
