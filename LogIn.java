import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import sun.audio.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;



public class LogIn extends JFrame {
	static Player currentUser = new Player();
	static boolean found = false;
	static boolean loggedin = false;
	

    public static void main(String[] args) {
		new LogIn();
    }
    private Image image;
	
	JButton loginButton = new JButton("Login");
	JPanel loginScreen = new JPanel();
	JTextField userField = new JTextField(10);
	JPasswordField passwordField = new JPasswordField(10);
	JLabel loginLabel = new JLabel("Username");
	JLabel passwordLabel = new JLabel("Password");
	Color Grey = new Color(192,192,192);
	
    public LogIn() {
    image = new ImageIcon("C:\\Users\\Sai Yarram\\Documents\\GitHub\\battleship\\LogIN.JPG").getImage();
    
	
	JPanel container = new MyBackground();
	container.setLayout(null);
	
	userField.setBounds(330,100,135,25);
	userField.setFont(new Font("Serif", Font.BOLD, 24));
	userField.setBackground(Grey);
	userField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	
	passwordField.setBounds(330,130,135,25);
	passwordField.setFont(new Font("Serif", Font.BOLD, 24));
	passwordField.setBackground(Grey);
	passwordField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	
	loginButton.setBounds(170,165,290,35);
	//loginButton.setOpaque(false);
	//loginButton.setContentAreaFilled(false);
	loginButton.setBorderPainted(true);
	loginButton.setFont(new Font("Serif", Font.BOLD, 24));
	loginButton.setForeground(Grey);
	loginButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	
	loginLabel.setBounds(170,100,145,25);
	loginLabel.setFont(new Font("Serif", Font.BOLD, 24));
	loginLabel.setBackground(Color.BLACK);
	loginLabel.setForeground(Color.BLACK);
	loginLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	
	passwordLabel.setBounds(170,130,145,25);
	passwordLabel.setFont(new Font("Serif", Font.BOLD, 24));
	passwordLabel.setBackground(Grey);
	passwordLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	
	
	container.add(userField);
	container.add(passwordField);
	container.add(passwordLabel);
	container.add(loginLabel);
	container.add(loginButton);
	
	
	add(container);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setSize(600, 600);
    setVisible(true);
	setResizable(false);
	loginEvent();
	Music();
    }
	
	public void loginEvent(){
			loginButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String username = userField.getText().toLowerCase();
					String password = passwordField.getText();
					 found = PlayerDatabase.runme(username,password);
					 
					if(found && !alreadyLoggedIn(username)){
						Player.setCurrentUser(username);
						PlayerDatabase.login(username);
						loggingin(username);
						JOptionPane.showMessageDialog(null,"Login Verified");
						HomeScreen home = new HomeScreen();
						home.setVisible(true);
						dispose();
						
					}else if(!found){
						userField.setText("");
						passwordField.setText("");
						userField.requestFocus();
					    JOptionPane.showMessageDialog(null,"Wrong Username / Password","ERROR", 2);

						
				}else if(alreadyLoggedIn(username)){
					PlayerDatabase.alreadyloggedin(username);

					userField.setText("");
					passwordField.setText("");
					userField.requestFocus();
				    JOptionPane.showMessageDialog(null,"ERROR! ACCOUNT ALREADY SIGNED IN","ERROR", 0);

				}
			}
		});
	}

	public static boolean alreadyLoggedIn(String name){
			loggedin = false;
			String username = name;
			File file = new File("loggedinplayers");
			Scanner scan;
			try {
				scan = new Scanner(file);
			
			while (scan.hasNext()) {
			    String line = scan.next();
			    if(line.equals(username)) { 
			    loggedin = true;
			    }
			}
			scan.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return loggedin;
		}

	public static void loggingin(String name){
			String username = name;
			FileWriter writer;
			try {
				writer = new FileWriter("loggedinplayers", true);
				writer.write(username + "\n");
				writer.close();		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public static void endofgamelog(){
			FileWriter writer,p1writer,p2writer,p3writer;
			try {
				writer = new FileWriter("loggedinplayers");
				writer.write("");
				
				p1writer = new FileWriter("player_one's_ships");
				p1writer.write("");
				
				p2writer = new FileWriter("player_two's_ships");
				p2writer.write("");
				
				p3writer = new FileWriter("firecoordinant");
				p3writer.write("");
				
				writer.close();		
				p1writer.close();
				p2writer.close();
				p3writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}	
	
	public static void Music(){
				try {
				File Music = new File("C:\\Users\\Sai Yarram\\Documents\\GitHub\\battleship\\Background.wav");
				 AudioInputStream audioIn = AudioSystem.getAudioInputStream(Music);
				 Clip clip = AudioSystem.getClip();
				 clip.open(audioIn);
				 clip.loop(5);
				 
				 }
				 
				 catch (UnsupportedAudioFileException e) {
					 e.printStackTrace();
				  } catch (IOException e) {
					 e.printStackTrace();
				  } catch (LineUnavailableException e) {
					 e.printStackTrace();
				  }
				
			}
	
	
	
	
	
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
