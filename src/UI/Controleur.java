package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur implements ActionListener {

	Modele modele;
	Vue vue;
	
	public Controleur(Vue vue) {
		this.vue = vue;
		this.modele = new Modele();
		this.modele.genererDonnee();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.vue.afficherDonnee(this.modele.getDonnee());
	}

}
