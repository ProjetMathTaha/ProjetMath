package UI;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrequenceBinaire extends JPanel {
	
	
	public FrequenceBinaire(int nombreDeFrequences, int[] tabFrequence) {
		super();
		this.setLayout(new GridLayout(nombreDeFrequences, 1 ));
		for ( int i = 0 ; i < nombreDeFrequences ; i++ ) {
			this.add(new JLabel("frequence de '1' par couple de "+i+" = "+tabFrequence[i]));
		}
	}
}
