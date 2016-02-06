package chatserver.gui;
import chatserver.domain.Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;

import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class ServerGui extends JFrame
{
	private Controller controller;
	private JPanel contentPane;
	private JTextField userTextField;
	private JList chatBox;
	private DefaultListModel addToChatBox;
	private DefaultListModel addToClientConnectedBox;
	private Image backgroundImage;
	private JButton btnKick;

	@SuppressWarnings("unchecked")
	public ServerGui() throws IOException
	{
            	setVisible(true);
		controller = Controller.getControllerInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(204, 255, 255));



		addToChatBox = new DefaultListModel();
		chatBox = new JList(addToChatBox);

		chatBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		chatBox.setBounds(6, 6, 339, 232);
		contentPane.add(chatBox);
	
		addToClientConnectedBox = new DefaultListModel();
		JList clientConnectedBox = new JList(addToClientConnectedBox);

		clientConnectedBox.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		clientConnectedBox.setBounds(357, 6, 127, 189);
		contentPane.add(clientConnectedBox);

		userTextField = new JTextField();
		userTextField.setBounds(6, 244, 339, 28);
		contentPane.add(userTextField);
		userTextField.setColumns(10);

		JButton btnSend = new JButton("Send");
		btnSend.setBounds(357, 245, 127, 29);
		contentPane.add(btnSend);
		
		btnKick = new JButton("Kick");
		btnKick.setBounds(357, 209, 127, 29);
		contentPane.add(btnKick);
		
	}
	

}

