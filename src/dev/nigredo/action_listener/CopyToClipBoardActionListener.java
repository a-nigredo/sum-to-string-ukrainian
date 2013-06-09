package dev.nigredo.action_listener;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dev.nigredo.swing.Window;

public class CopyToClipBoardActionListener implements ActionListener {

	Window window = null;

	public CopyToClipBoardActionListener(Window window) {
		this.window = window;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		String fieldData = window.getNumberAsStringTextField().getText();

		if (!fieldData.equals("")) {
			StringSelection data = new StringSelection(fieldData);
			clipboard.setContents(data, data);
		}

	}

}
