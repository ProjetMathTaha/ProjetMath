package UI;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class testUI {

	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 800);
		f.setLayout(new GridLayout(1, 1));
		int[] tab = { 1 , 2 , 3};
		f.add(new FrequenceBinaire(3, tab));
		f.setVisible(true);
		f.pack();
	}

}
