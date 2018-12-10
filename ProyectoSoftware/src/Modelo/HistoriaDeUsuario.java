package Modelo;

public class HistoriaDeUsuario extends Requisito {
	private String who;
	private String what;
	private String reason;

	public HistoriaDeUsuario() {
		super();
	}

	public String getWho() {
		return who;
	}

	public String getWhat() {
		return what;
	}

	public String getReason() {
		return reason;
	}
	public void setWho(String who){
		this.who=who;
	}
	public void setWhat(String what) {
		this.what=what;
	}
	public void setReason(String reason) {
		this.reason=reason;
	}

}
