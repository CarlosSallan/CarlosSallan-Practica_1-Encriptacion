package cript_object;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CriptCrear extends JFrame implements ActionListener{
	
	JTextField originalField;
	JTextField finalField;
	
	public CriptCrear(){
		this.setBounds(250, 150, 1000, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.decode("#d4b774"));
		
		//Label Original info
		JLabel originalLabel = new JLabel("Mensaje original: ");
		originalLabel.setBounds(10, 10, 100, 20);
		this.add(originalLabel);
		
		//Label Final info
		JLabel finalLabel = new JLabel("Mensaje final: ");
		finalLabel.setBounds(10, 30, 100, 20);
		this.add(finalLabel);
		
		//Textfield Original no editable
		originalField = new JTextField("/NO HAY DATOS/");
		originalField.setBounds(110, 10, 870, 20);
		originalField.setEditable(false);
		this.add(originalField);
		
		//Textfield Original no editable
		finalField = new JTextField("/NO HAY DATOS/");
		finalField.setBounds(110, 32, 870, 20);
		finalField.setEditable(false);
		this.add(finalField);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}