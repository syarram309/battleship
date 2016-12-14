import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;




public class InitialScreen extends JFrame {
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
	InitialScreen initial =	new InitialScreen();
	}
	
	private Image image;
	JButton LogInB = new JButton("Log In");
	JButton NewUserB = new JButton("New User");
	Color Grey = new Color(192,192,192);
	
	public InitialScreen() {
		image = new ImageIcon("C:\\Users\\Sai Yarram\\Documents\\GitHub\\battleship\\EZ.gif").getImage();
		
		JPanel container = new MyBackground();
		container.setLayout(null);
		LogInB.setBounds(250,220,300,70);
		LogInB.setBorderPainted(true);
		LogInB.setFont(new Font("Serif", Font.BOLD, 24));
		LogInB.setForeground(Grey);
		LogInB.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		NewUserB.setBounds(250,295,300,70);
		NewUserB.setBorderPainted(true);
		NewUserB.setFont(new Font("Serif", Font.BOLD, 24));
		NewUserB.setForeground(Grey);
		NewUserB.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			
		
		container.add(LogInB);
		container.add(NewUserB);
		
		add(container);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		//loginEvent();
		//signupEvent();
		
	}
	
	/*public void loginEvent(){
					LogInB.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent login) {
							LogIn.main(null);
							dispose();
						}
					
				});
			}
				public void signupEvent(){
					NewUserB.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent newuser) {
							SignUp.main(null);
							dispose();
						}
					
				});
			}*/
			
	public class MyBackground extends JPanel {
		
		public MyBackground() {
			setBackground(new Color(0, true));
		}
		
		@Override
		public void paintComponent(Graphics g) {
			//Paint background first
			g.drawImage (image, 0, 0, getWidth (), getHeight (), this);
			
			//Paint the rest of the component. Children and self etc.
			super.paintComponent(g);
		}
	}
	
}