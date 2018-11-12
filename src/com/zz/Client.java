package com.zz;

public class Client {
	public String name;
	public String cf;
	public String piva;
	
	public Client(String name, String cf, String piva)
	{
		this.name = name;
		this.cf = cf;
		this.piva = piva;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getPiva() {
		return piva;
	}

	public void setPiva(String piva) {
		this.piva = piva;
	}
}
