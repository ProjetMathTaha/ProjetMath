package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur implements ActionListener {

	Modele modele;
	Vue vue;
	
	public Controleur(Vue vue) {
		this.vue = vue;
		this.modele = new Modele();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("CONTROLEUR | a= "+this.vue.getParametres().get("b").getText());
		this.modele.genererDonnee(		
				Integer.parseInt(this.vue.getParametres().get("a").getText()),
				Integer.parseInt(this.vue.getParametres().get("b").getText()), 
				Integer.parseInt(this.vue.getParametres().get("x0").getText()), 
				Integer.parseInt(this.vue.getParametres().get("m").getText()), 
				Integer.parseInt(this.vue.getParametres().get("nb").getText())
				);
		
		this.vue.afficherDonnee(this.modele.getDonnee());
		
		
		this.vue.afficherStats(this.modele.getFrequence(), this.modele.getFrequenceDoublets(), this.modele.getDifferenceMoitie(), this.modele.getPeriode());
		
	}

}
