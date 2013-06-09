package dev.nigredo.action_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import dev.nigredo.swing.Window;

public class ClearButtonActionListener implements ActionListener {

	Window window = null;
	
	public ClearButtonActionListener(Window window){
		this.window = window;
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JTextField numberField = window.getNumberTextField();
		
		window.getNumberAsStringTextField().setText("");
		numberField.setText("");
		numberField.setBorder(BorderFactory.createEmptyBorder());
	}

}
