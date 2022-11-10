package cript_swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class CriptCrear extends JFrame implements ActionListener{
	JTextField mnsj_original;
	
	public CriptCrear() {
		this.setLayout(null);
		this.setBounds(700,200,1000,700);
		this.setLocationRelativeTo(null);
		Font font = new Font("Arial", Font.PLAIN, 14);
		this.setTitle("Encriptación.");
		Color  azulraro = new Color(255, 230, 247);
		getContentPane().setBackground(azulraro);
		
		//Textfield mensaje original
		mnsj_original = new JTextField();
		mnsj_original.setBounds(200, 150, 600, 30);
		this.add(mnsj_original);
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		
	}
}
