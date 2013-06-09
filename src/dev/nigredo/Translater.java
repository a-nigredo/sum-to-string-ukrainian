package dev.nigredo;

import dev.nigredo.action_listener.ClearButtonActionListener;
import dev.nigredo.action_listener.ConvertButtonActionListener;
import dev.nigredo.action_listener.ConvertInClipboardActionListener;
import dev.nigredo.action_listener.CopyToClipBoardActionListener;
import dev.nigredo.action_listener.PasteFromClipBoardActionListener;
import dev.nigredo.swing.Window;

public class Translater {
	
	private static Window application;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		application = new Window("Translater");

		application.getConvertButton().addActionListener(new ConvertButtonActionListener(application));
		application.getClearButton().addActionListener(new ClearButtonActionListener(application));
		application.getPasteFromClipBoardButton().addActionListener(new PasteFromClipBoardActionListener(application));
		application.getCopyToClipBoardButton().addActionListener(new CopyToClipBoardActionListener(application));
		application.getConvertInClipboardButton().addActionListener(new ConvertInClipboardActionListener(application));
		
		application.pack();
		application.setVisible(true);
	}
	
}
