package Objetos;

public class Lugares {
	private String num;
	private String tipo; //se é estudante, trampador, idoso
	private String ocupado;
	private String cpf;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getOcupado() {
		return ocupado;
	}
	public void setOcupado(String ocupado) {
		this.ocupado = ocupado;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
