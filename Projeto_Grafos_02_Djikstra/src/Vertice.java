
public class Vertice {
	int index;
	
	String nome, profissao;
	double latitude, longitude;
	boolean disp;
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setDisp(boolean disp) {
		this.disp = disp;
	}

	public String getNome() {
		return nome;
	}

	public String getProfissao() {
		return profissao;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public boolean isDisp() {
		return disp;
	}
	
	public String printa() {
		String str = String.valueOf(disp);
		String qlqrCoisa = index+" "+nome+" "+latitude+" "+longitude+" "+profissao+" "+str;
		return qlqrCoisa;
	}
	
	public String printaFinal() {
		
		String qlqrCoisa = nome+" "+profissao;
		return qlqrCoisa;
	}
	
	public String printaOpcoes() {
		if(disp == true) {
			String profDisponivel = "disponível: "+nome+" - "+profissao+" ";
			return profDisponivel;
		}else {
			String profIndisponivel = "INDISPONÍVEL: "+nome+" - "+profissao+" ";
			return profIndisponivel;
		}
		
	}
	

}
