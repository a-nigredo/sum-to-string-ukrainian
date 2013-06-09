package dev.nigredo.action_listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

import dev.nigredo.NumberToUkrainianWords;
import dev.nigredo.swing.Window;

public class ConvertButtonActionListener implements ActionListener {

	Window window = null;
	
	public ConvertButtonActionListener(Window window){
		this.window = window;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		JTextField numberField = window.getNumberTextField();
		JTextField numberAsStringField = window.getNumberAsStringTextField();
		
		String numberValue = numberField.getText().replace(" ", "");

		Pattern p = Pattern.compile("[0-9]{1,}");
		Matcher m = p.matcher(numberValue);

		if (m.matches()) {
			
			String numberAsString = NumberToUkrainianWords.toWords(new BigDecimal(numberValue));
			numberAsStringField.setText(numberAsString);
			numberField.setBorder(BorderFactory.createEmptyBorder());
			
		} else {
			Border redBorder = BorderFactory.createLineBorder(Color.red);
			numberField.setBorder(redBorder);
			numberAsStringField.setText("");
		}
		
	}

}
