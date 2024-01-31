package Lab1;

import java.util.ArrayList;

public class Man {
	
	private ArrayList <Woman> men_pref = new ArrayList <Woman>();
	private boolean has_partner;
	private int counter; // counts the number of women he already proposed to
	private Woman partner;
	
	
	public Woman getPartner() {
		return partner;
	}
	public void setPartner(Woman partner) {
		this.partner = partner;
	}
	public boolean isHas_partner() {
		return has_partner;
	}
	public ArrayList<Woman> getMen_pref() {
		return men_pref;
	}
	public void setMen_pref(ArrayList<Woman> men_pref) {
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
	
	public String toString() {
		return this + "'s partner is " + partner;
	}
	
	
}
