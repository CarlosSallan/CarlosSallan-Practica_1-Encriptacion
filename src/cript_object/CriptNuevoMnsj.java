package cript_object;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CriptNuevoMnsj extends JFrame implements ActionListener{
	
	JTextField msjField;
	JButton ButFinal;
	
	public CriptNuevoMnsj(){
		this.setBounds(250, 150, 450, 250);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.decode("#d97187"));
		
		//Textfield
		msjField = new JTextField();
		msjField.setBounds(20, 20, 400, 25);
		this.add(msjField);
		
		//Boton Finalizar
		ButFinal = new JButton("Finalizar");
		ButFinal.setBounds(150, 75, 150, 40);
		ButFinal.addActionListener(this);
		this.add(ButFinal);
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ButFinal) {
			if(!msjField.getText().equals("")) {
				
				CriptObject objeto = new CriptObject(msjField.getText());
				
				CriptInterfaz cript = new CriptInterfaz(objeto);
				this.dispose();
			}
		}
	}
}
