package gui;

import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import actions.ClickHandler;

public class Gui {
	
	public static JButton[][] buttons = new JButton[6][7];
	public static JButton[] settings = new JButton[2];
	public static int[] columnCheck = {6,6,6,6,6,6,6};
	public static String player = null;
	public int width = 700;
	public int height = 600;
	public static JFrame frame = new JFrame("Connect Four");
	public static JPanel gamePanel; 
	public static JPanel settingsPanel; 
	public static int clicked;

	public Gui() {
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false); 
		initButtons();
		frame.setVisible(true);
	}
	
	public static void initButtons() {
		gamePanel = new JPanel(new GridLayout(6,7));

		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons[i].length; j++) {
				JButton btn = new JButton();
				btn.setFont(new Font("Helvetica",Font.BOLD, 70));
				btn.setForeground(Color.LIGHT_GRAY);
				btn.addActionListener(new ClickHandler(i,j));
				gamePanel.add(btn);
				buttons[i][j] = btn;
			}
		}
		frame.getContentPane().removeAll();
		frame.add(gamePanel);

		frame.getContentPane().revalidate();
	}

	public static void endGame(String player) {
		JPanel endPanel = new JPanel(new GridLayout(2,1));
		if(player.equals("TIE")) {
			JLabel label = new JLabel("It's a tie!", SwingConstants.CENTER);
			endPanel.add(label);
		} else {
			JLabel label = new JLabel(player + " has won!", SwingConstants.CENTER);
			endPanel.add(label);
		}
		
		JButton btn = new JButton ("New Game?");
		
		endPanel.add(btn);
		
		frame.getContentPane().removeAll();
		frame.add(endPanel);
		frame.getContentPane().revalidate();

		btn.addActionListener((e)->{
			initButtons();
			clicked = 0;
			Arrays.fill(columnCheck, 6);
			});
				
	}
}

