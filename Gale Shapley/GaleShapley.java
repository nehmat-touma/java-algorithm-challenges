package Lab1;
import java.util.ArrayList;


public class GaleShapley {


	public void gale_shapley_marriage(ArrayList<Man> men, ArrayList<Woman> women) {
		// takes array lists of the men and women

		int formedcouples = 0;
		int i=0;

		while(formedcouples<men.size()) {

			Man our_man= men.get(i);

			if (our_man.has_partner()) {
				if(i==men.size()-1)
					i=0;
				else
					i++;

				continue;
			}

			else {// the man is single

				// only loop for the women we didn't check yet
				for (int j=our_man.getCounter();j<our_man.getMen_pref().size();j++) {  

					Woman first_on_list=our_man.getMen_pref().get(our_man.getCounter());

					if (first_on_list.has_partner()){
						// the first woman on his list he hasn't proposed to is taken
						// we check if she prefers him over his current partner

						if (first_on_list.getMen_pref().indexOf(our_man)<
								first_on_list.getMen_pref().indexOf(first_on_list.getPartner()))
							// if our man now is preferred by this woman 
						{
							// partner him up with her
							first_on_list.getPartner().setHas_partner(false); // her partner is now single
							first_on_list.setPartner(our_man); // we partner our man with the woman
							our_man.setPartner(first_on_list);
							our_man.setHas_partner(true);


						}

						our_man.setCounter(our_man.getCounter()+1);  // increment counter so we dont check for her anymore
					}
					else { // the first woman on his list is single, he partners with her
						our_man.setHas_partner(true);
						our_man.setPartner(first_on_list);
						// man is now taken
						first_on_list.setHas_partner(true);
						first_on_list.setPartner(our_man);
						// woman is now taken
						our_man.setCounter(our_man.getCounter()+1);  //increment counter

						formedcouples++;
					}
				}
			}

			if(i==men.size()-1)
				i=0;
			else
				i++;
		}

		for (int j=0;j<men.size();j++)
			System.out.println("Man " + (j+1) + "'s partner is " + "Woman "+ (women.indexOf(men.get(j).getPartner())+1)) ;

	}



}






