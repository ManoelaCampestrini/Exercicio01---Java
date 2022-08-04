package exercicio01.entidades;

public class Roupa {
	// Atributos encapsulados
	private int id;
	private String modelo;
	private String cor;
	private String tecido;

	//Aparecer o consultar em String e não somente o endereço do database
	@Override
	public String toString() {
		return "Roupa [id=" + id + ", modelo=" + modelo + ", cor=" + cor + ", tecido=" + tecido + "]";
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTecido() {
		return tecido;
	}

	public void setTecido(String tecido) {
		this.tecido = tecido;
	}

	// Construtores e sobrecarga
	public Roupa() {
	}

	public Roupa(String modelo, String cor, String tecido) {
		this.modelo = modelo;
		this.cor = cor;
		this.tecido = tecido;
	}

}
