package Lab1;

import java.util.ArrayList;

public class Woman {

	private ArrayList <Man> men_pref = new ArrayList <Man>();
	private boolean has_partner;
	private int counter; // counts the number of women he already proposed to
	private Man partner;
	
	
	public Man getPartner() {
		return partner;
	}
	public void setPartner(Man partner) {
		this.partner = partner;
	}
	public boolean isHas_partner() {
		return has_partner;
	}
	public ArrayList<Man> getMen_pref() {
		return men_pref;
	}
	public void setMen_pref(ArrayList<Man> men_pref) {
		this.men_pref = men_pref;
	}
	public boolean has_partner() {
		return has_partner;
	}
	public void setHas_partner(boolean has_partner) {
		this.has_partner = has_partner;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	
	
	
}
