package dev.nigredo.action_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dev.nigredo.swing.Window;

public class ConvertInClipboardActionListener implements ActionListener {

	Window window = null;

	public ConvertInClipboardActionListener(Window window) {
		this.window = window;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		new PasteFromClipBoardActionListener(window).actionPerformed(e);
		new ConvertButtonActionListener(window).actionPerformed(e);
		new CopyToClipBoardActionListener(window).actionPerformed(e);

	}

}
