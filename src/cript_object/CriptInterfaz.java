package cript_object;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CriptInterfaz extends JFrame implements ActionListener{
	
	JTextField originalField;
	JTextField finalField;
	JButton ButNuevoMsj;
	JButton ButCesar;
	JButton ButMonoalfa;
	JButton ButNumeracion;
	JButton ButDescifrar;
	JTextField ClaveField;
	CriptObject objeto;
	
	
	public CriptInterfaz(CriptObject objeto){
		
		this.objeto = objeto;
		
		this.setBounds(250, 150, 1000, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.decode("#d97187"));
		
		//Label Original info
		JLabel originalLabel = new JLabel("Mensaje original: ");
		originalLabel.setBounds(10, 10, 100, 20);
		this.add(originalLabel);
		
		//Label Final info
		JLabel finalLabel = new JLabel("Mensaje final: ");
		finalLabel.setBounds(10, 30, 100, 20);
		this.add(finalLabel);
		
		//Textfield Original no editable
		originalField = new JTextField(this.objeto.getMensajeOriginal());
		originalField.setBounds(110, 10, 870, 20);
		originalField.setEditable(false);
		this.add(originalField);
		
		//Textfield Original no editable
		finalField = new JTextField(this.objeto.getMensajeFinal());
		finalField.setBounds(110, 32, 870, 20);
		finalField.setEditable(false);
		this.add(finalField);
		
		//Label Clave info
		JLabel ClaveLabel = new JLabel("Clave: ");
		ClaveLabel.setBounds(10, 200, 100, 20);
		this.add(ClaveLabel);
		
		//Textfield Clave no editable
		ClaveField = new JTextField();
		ClaveField.setBounds(110, 200, 150, 20);
		this.add(ClaveField);
		
		//Boton nuevo mensaje
		ButNuevoMsj = new JButton("Nuevo Mensaje.");
		ButNuevoMsj.setBounds(800, 70, 130, 35);
		ButNuevoMsj.addActionListener(this);
		this.add(ButNuevoMsj);
		
		//Boton cesar
		ButCesar = new JButton("Cifrar Cesar.");
		ButCesar.setBounds(275, 70, 130, 35);
		ButCesar.addActionListener(this);
		this.add(ButCesar);
		
		//Boton Monoalfa
		ButMonoalfa = new JButton("Cifrar Monoalfa.");
		ButMonoalfa.setBounds(490, 70, 130, 35);
		ButMonoalfa.addActionListener(this);
		this.add(ButMonoalfa);
		
		//Boton Numeracion
		ButNumeracion = new JButton("Cifrar Numeracion.");
		ButNumeracion.setBounds(60, 70, 130, 35);
		ButNumeracion.addActionListener(this);
		this.add(ButNumeracion);
		
		//Boton nuevo descifrar
		ButDescifrar = new JButton("Deshacer");
		ButDescifrar.setBounds(800, 120, 130, 35);
		ButDescifrar.addActionListener(this);
		this.add(ButDescifrar);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ButNuevoMsj) {
			CriptNuevoMnsj nuevoMsj = new CriptNuevoMnsj();
			nuevoMsj.setVisible(true);
			this.dispose();
		}else if(e.getSource() == ButDescifrar) {
			objeto.recTransformacion();
			ActualizarFrame();
			
		}else if(e.getSource() == ButCesar) {
			if(!(ClaveField.getText() == null)) {
				objeto.recTransformacion();
				int claveCesar = Integer.parseInt(ClaveField.getText());
				objeto.algCesar(claveCesar);
				ActualizarFrame();
			}
		}else if(e.getSource() == ButMonoalfa) {
			if(!(ClaveField.getText() == null)) {
				objeto.recTransformacion();
				objeto.algMonoalfa(ClaveField.getText());
				ActualizarFrame();
			}
			
		}else if(e.getSource() == ButNumeracion) {
			if(!(ClaveField.getText() == null)) {
				objeto.recTransformacion();
				objeto.algNumeracion(ClaveField.getText());
				ActualizarFrame();
			}
		}
		
		
	}
	
	private void ActualizarFrame() {
		finalField.setText(objeto.getMensajeFinal());
	}
}