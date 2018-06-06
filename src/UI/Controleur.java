package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Calcul.BBS;
import Calcul.CongruentielLineaire;

public class Controleur implements ActionListener {

	Vue vue;
	BBS bbs;
	CongruentielLineaire congruence;

	public Controleur(Vue vue) {
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton j = (JButton) e.getSource();

		if (j.getMnemonic() == 1) {
			this.congruence = new CongruentielLineaire(
					Integer.parseInt(this.vue.getParametresCongruenceLineaire().get("a").getText()),
					Integer.parseInt(this.vue.getParametresCongruenceLineaire().get("b").getText()),
					Integer.parseInt(this.vue.getParametresCongruenceLineaire().get("x0").getText()),
					Integer.parseInt(this.vue.getParametresCongruenceLineaire().get("m").getText()),
					Integer.parseInt(this.vue.getParametresCongruenceLineaire().get("nb").getText()));
			this.vue.afficherDonnee(this.congruence.genererSerie());
			this.vue.afficherStats(this.congruence.calculFrequenceDeZero(),
					this.congruence.calculerFrequenceDeZeroPar2(), this.congruence.calculDifferenceMoitie(),
					this.congruence.periodicite());
		} else {
			this.bbs = new BBS(Integer.parseInt(this.vue.getParametresBBS().get("x0").getText()),
					Integer.parseInt(this.vue.getParametresBBS().get("m").getText()),
					Integer.parseInt(this.vue.getParametresBBS().get("nb").getText()));
			this.vue.afficherDonnee(this.bbs.genererSerie());
			this.vue.afficherStats(this.bbs.calculFrequenceDeZero(), this.bbs.calculerFrequenceDeZeroPar2(),
					this.bbs.calculDifferenceMoitie(), this.bbs.periodicite());
		}
	}
}
