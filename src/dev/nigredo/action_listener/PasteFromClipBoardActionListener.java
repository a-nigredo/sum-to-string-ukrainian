package dev.nigredo.action_listener;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dev.nigredo.swing.Window;

public class PasteFromClipBoardActionListener implements ActionListener {

	Window window = null;

	public PasteFromClipBoardActionListener(Window window) {
		this.window = window;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		Transferable clipboardContent = Toolkit.getDefaultToolkit()
				.getSystemClipboard().getContents(this);

		JTextField numberField = window.getNumberTextField();

		try {

			String dataInClipboard = (String) clipboardContent
					.getTransferData(DataFlavor.stringFlavor);

			numberField.setText(dataInClipboard);
			numberField.setBorder(BorderFactory.createEmptyBorder());

		} catch (UnsupportedFlavorException | IOException e) {

			Component frame = (Component) event.getSource();

			JOptionPane.showMessageDialog(frame,
					"Ошибка вставки из буфера обмена.", "Ошибка буфера обмена",
					JOptionPane.ERROR_MESSAGE);

			numberField.setText("");
		}
	}

}
