import java.awt.*;
import java.awt.event.*;
import java.awt.Frame;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;
import java.io.*;
import javax.swing.*;
import java.awt.Color;
import javax.swing.table.*;

public class LeaderBoard extends JFrame
{
static String text = "";
private static int LineCount = 0;
static String[][]LeaderBoardArray = new String[5][5];



	public LeaderBoard() 
			{
				super("Fleet Destroyer Engine");
			}

	public void CreateLeaderBoard()
		{
			GetLeaderBoardValues();
			String [] columnNames = {"Position", "UserName", "Wins", "Loses", "Experience"};
			Object [][] Data = {
								{1, LeaderBoardArray[0][0],LeaderBoardArray[0][1], LeaderBoardArray[0][2], LeaderBoardArray[0][3]},
								{2, LeaderBoardArray[1][0],LeaderBoardArray[0][1], LeaderBoardArray[0][2], LeaderBoardArray[0][3]},
								{3, LeaderBoardArray[2][0],LeaderBoardArray[0][1], LeaderBoardArray[0][2], LeaderBoardArray[0][3]},
								{4, LeaderBoardArray[3][0],LeaderBoardArray[0][1], LeaderBoardArray[0][2], LeaderBoardArray[0][3]},
								{5, LeaderBoardArray[4][0],LeaderBoardArray[0][1], LeaderBoardArray[0][2], LeaderBoardArray[0][3]},
								};
			
			DefaultTableModel Model = new DefaultTableModel(Data,columnNames) 
			{
				@Override
				public boolean isCellEditable(int row, int column) 
				{
					return false;
				}
				
			};					

			JTable Table = new JTable(Model);
			this.add(new JScrollPane(Table));
			this.setTitle("Table ");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
			//this.setSelectionBackground(Color.BLUE);
			//this.setSelectionForeground(Color.BLACK);
			this.pack();
			this.setVisible(true);
			this.setPreferredSize(new Dimension(150,100));
			//GetLeaderBoardValues();
			
			
		}
		
	public void GetLeaderBoardValues() 
		{
		try 
			{
				FileReader File = new FileReader("C:\\Users\\Sai Yarram\\Documents\\GitHub\\battleship\\LeaderBoard.txt");
				BufferedReader Reader = new BufferedReader(File);
				String text = "";
				String line = Reader.readLine();
				while (line!= null)
					{
						text= line;
						GetLeaderBoardValues(text,LineCount);
						line = Reader.readLine();
						LineCount++;
						//System.out.println(text);
					}
				for(int i=0; i<=4;i++)
				{
					for(int j=0;j<=4;j++)
					{
						
					System.out.print(LeaderBoardArray[i][j] + "   ");
					}		
					System.out.println("");
				}
				
				
				Reader.close();
			}
		catch(FileNotFoundException ex){System.out.println("Unable to open file ");}
		catch(IOException ex){System.out.println("Error reading file");}
		}
		
	public static void GetLeaderBoardValues(String text, int LineCount)
	{
		String str = text;
		
		String[] Split = str.split(" ");
		int i = LineCount;
		for(int j=0;j<=4;j++)
		{
			LeaderBoardArray[i][j] = Split[j];			
		}
		
		
	}

public static void main(String[] args) throws Exception {
			 SwingUtilities.invokeLater(new Runnable()
			{
				public void run()
				{
					new LeaderBoard().CreateLeaderBoard();

				}

			});
	 

		}
	

}