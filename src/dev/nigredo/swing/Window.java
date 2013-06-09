package dev.nigredo.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField numberTextField;
	private JTextField numberAsStringTextField;
	private JButton convertButton;
	private JButton clearButton;
	private JButton pasteFromClipBoardButton;
	private JButton copyToClipBoardButton;
	private JButton convertInClipboardButton;
	
	public Window(String title) {

		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800, 100));

		JPanel p = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.setLayout(new FlowLayout());
		
		numberTextField = new JTextField();
		numberAsStringTextField = new JTextField();
		convertButton = new JButton("���������");
		clearButton = new JButton("��������");
		pasteFromClipBoardButton = new JButton("�������� �� ������ ������");
		copyToClipBoardButton = new JButton("���������� ������� � ����� ������");
		convertInClipboardButton = new JButton("��������� ����� � ������ ������");
		
		numberAsStringTextField.setEditable(false);

		p.setLayout(new GridLayout(3, 1));
		p.add(numberTextField);
		p.add(numberAsStringTextField);
		
		buttonPanel.add(convertButton);
		buttonPanel.add(clearButton);
		buttonPanel.add(pasteFromClipBoardButton);
		buttonPanel.add(copyToClipBoardButton);
		buttonPanel.add(convertInClipboardButton);

		p.add(buttonPanel);
		
		add(p);
	}

	public JTextField getNumberTextField() {
		return numberTextField;
	}

	public JTextField getNumberAsStringTextField() {
		return numberAsStringTextField;
	}

	public JButton getConvertButton() {
		return convertButton;
	}

	public JButton getClearButton() {
		return clearButton;
	}

	public JButton getPasteFromClipBoardButton() {
		return pasteFromClipBoardButton;
	}

	public JButton getCopyToClipBoardButton() {
		return copyToClipBoardButton;
	}

	public JButton getConvertInClipboardButton() {
		return convertInClipboardButton;
	}
}
