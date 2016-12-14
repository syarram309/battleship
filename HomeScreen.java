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
import java.io.*;
import java.util.*;
import sun.audio.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;


public class HomeScreen extends JFrame {
    public static void main(String[] args) {
        new HomeScreen();
		Music();
    }
     
    private Image image;
	JButton GameStart = new JButton("Start Game");
	JButton LeaderBoard = new JButton("Leaderboard");
	JButton Options = new JButton("Options");
	JButton Help = new JButton("Help");
	
	
     
    public HomeScreen() {
        image = new ImageIcon("C:\\Users\\Sai Yarram\\Documents\\GitHub\\battleship\\HomeScreen.JPG").getImage();
        
        JPanel container = new MyBackground();
		container.setLayout(null);
		Color lightBlue= new Color(0,204,255,255);
		
		GameStart.setBounds(160,80,200,100);
		GameStart.setOpaque(false);
		GameStart.setContentAreaFilled(false);
		GameStart.setBorderPainted(true);
		GameStart.setFont(new Font("Serif", Font.BOLD, 24));
		GameStart.setForeground(lightBlue);
		GameStart.setBorder(BorderFactory.createLineBorder(lightBlue, 2));
		
		LeaderBoard.setBounds(160,181,200,100);
		LeaderBoard.setOpaque(false);
		LeaderBoard.setContentAreaFilled(false);
		LeaderBoard.setBorderPainted(true);
		LeaderBoard.setFont(new Font("Serif", Font.BOLD, 24));
		LeaderBoard.setForeground(lightBlue);
		LeaderBoard.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		Options.setBounds(160,281,200,100);
		Options.setOpaque(false);
		Options.setContentAreaFilled(false);
		Options.setBorderPainted(true);
		Options.setFont(new Font("Serif", Font.BOLD, 24));
		Options.setForeground(lightBlue);
		Options.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));	
        
		Help.setBounds(160,381,200,100);
		Help.setOpaque(false);
		Help.setContentAreaFilled(false);
		Help.setBorderPainted(true);
		Help.setFont(new Font("Serif", Font.BOLD, 24));
		Help.setForeground(lightBlue);
		Help.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		
		add(container);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
		container.add(GameStart);
		container.add(LeaderBoard);
		container.add(Options);
		container.add(Help);
        setVisible(true);
		setResizable(false);
		
		GameStartEvent();
		LeaderBoardEvent();
		OptionsEvent();
		HelpEvent();
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
			
		public void GameStartEvent(){
				GameStart.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent enter) {
						
						File file = new File("loggedinplayers");

						try {
							Scanner scanner = new Scanner(file);
							int lineNum = 0;
							while (scanner.hasNextLine()) {
								String line = scanner.nextLine();
								lineNum++;
								}
							if(lineNum > 1){							
								//GameEngine.main(null);
								dispose();
							}else{
							JOptionPane.showMessageDialog(null,"Waiting For Opponent To Connect...","Connecting...", 1);
							}
							
						}catch(FileNotFoundException e) { 
							//handle this
						}	
				}
				
			});
		}	
			
		public void LeaderBoardEvent(){
				LeaderBoard.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent leaderboard) {
						JOptionPane.showMessageDialog(null,"System Under Construction","ERROR #404", 2);
					}
				});
			}	
			
		public void OptionsEvent(){
				Options.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent options) {
						JOptionPane.showMessageDialog(null,"System Under Construction","ERROR #404", 2);
					}		
				});
			}
		public void HelpEvent(){
				Help.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent help) {
					//HelpScreen.main(null);	
					}
				});
			}
		
}

			
			