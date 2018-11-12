package com.zz;

public class Doc {
	private static final int VAT = 22;
	
	public String docnum;
	public String getDocnum() {
		return docnum;
	}

	public void setDocnum(String docnum) {
		this.docnum = docnum;
	}

	public float getImp() {
		return imp;
	}

	public void setImp(float imp) {
		this.imp = imp;
	}

	public float getVat() {
		return vat;
	}

	public void setVat() {
		this.vat = (this.imp/100) * VAT;
	}

	public float getTot() {
		return tot;
	}

	public void setTot() {
		this.tot = this.imp + this.vat;
	}

	public float imp;
	public float vat;
	public float tot;
	
	public Doc(String d, float i, float v, float t)
	{
		this.docnum = d;
		this.imp = i;
		this.vat = v;
		this.tot = t;
	}

}
