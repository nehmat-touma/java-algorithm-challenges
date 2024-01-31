package Lab1;

import java.util.ArrayList;

public class Main {

	public static void main (String []args) {

		// Three couples total -> six objects

		// initialization

		ArrayList <Man> men = new ArrayList <Man>();
		ArrayList <Woman> women = new ArrayList <Woman>();

		Man m1=new Man();
		Man m2=new Man();
		Man m3=new Man();
		
		men.add(m1);
		men.add(m2);
		men.add(m3);

		Woman w1=new Woman();
		Woman w2=new Woman();
		Woman w3=new Woman();
		
		women.add(w1);
		women.add(w2);
		women.add(w3);
		
		ArrayList <Woman> men_pref1 = new ArrayList <Woman>();
		ArrayList <Woman> men_pref2 = new ArrayList <Woman>();
		ArrayList <Woman> men_pref3 = new ArrayList <Woman>();

		ArrayList <Man> woman_pref1 = new ArrayList <Man>();
		ArrayList <Man> woman_pref2 = new ArrayList <Man>();
		ArrayList <Man> woman_pref3 = new ArrayList <Man>();

		
		men_pref1.add(w3);
		men_pref1.add(w2);
		men_pref1.add(w1);
		m1.setMen_pref(men_pref1);

		men_pref2.add(w1);
		men_pref2.add(w2);
		men_pref2.add(w3);
		m2.setMen_pref(men_pref2);

		men_pref3.add(w2);
		men_pref3.add(w3);
		men_pref3.add(w1);
		m3.setMen_pref(men_pref3);

		woman_pref1.add(m3);
		woman_pref1.add(m2);
		woman_pref1.add(m1);
		w1.setMen_pref(woman_pref1);

		woman_pref1.add(m1);
		woman_pref1.add(m3);
		woman_pref1.add(m2);
		w2.setMen_pref(woman_pref2);

		woman_pref1.add(m2);
		woman_pref1.add(m3);
		woman_pref1.add(m1);
		w3.setMen_pref(woman_pref3);


		// method call
		GaleShapley g=new GaleShapley();
		g.gale_shapley_marriage(men,women);

	}

}
