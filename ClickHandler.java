package actions;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Gui;

public class ClickHandler implements ActionListener{
	int i;
	int j;
	
	public ClickHandler(int i, int j) {
			this.i = i;
			this.j = j;
	}
	
	public void actionPerformed(ActionEvent event) {
		Color color = null;
		Gui.columnCheck[j]-=1;
		if (Gui.columnCheck[j] >=0) {
			Gui.clicked++;
		}
		try {
			if(Gui.clicked %2 == 0 && Gui.clicked < 42) {
				color = Color.YELLOW;
				Gui.player = "Yellow";
				Gui.buttons[Gui.columnCheck[j]][j].setBackground(Color.YELLOW);
			} else {
				color = Color.RED;;
				Gui.player = "Red";
				Gui.buttons[Gui.columnCheck[j]][j].setBackground(Color.RED);
			}
		} catch (Exception e) {
		}
		if(Gui.clicked >= 7 && checkWinner(color)) {
			Gui.endGame(Gui.player);
		} else if (Gui.clicked >=42){
			Gui.endGame("TIE");
		}
	}

		public boolean checkWinner(Color color) {
				try {
					//check across
					for(int row = 0; row< Gui.buttons.length; row++){
						for (int col = 0;col < Gui.buttons[0].length - 3;col++){
							if(Gui.buttons[row][col].getBackground().equals(color) && 
									Gui.buttons[row][col+1].getBackground().equals(color) && 
									Gui.buttons[row][col+2].getBackground().equals(color) && 
									Gui.buttons[row][col+3].getBackground().equals(color)){
								return true;
							}
						}			
					}
					//check down
					for(int row = 0; row< Gui.buttons.length-3; row++){
						for (int col = 0;col < Gui.buttons[0].length - 3;col++){
							if(Gui.buttons[row][col].getBackground().equals(color) && 
									Gui.buttons[row+1][col].getBackground().equals(color) && 
									Gui.buttons[row+2][col].getBackground().equals(color) && 
									Gui.buttons[row+3][col].getBackground().equals(color)){
								return true;
							}
						}			
					}
					//check diagonal down
					for(int row = 0; row< Gui.buttons.length; row++){
						for (int col = 0;col < Gui.buttons[0].length - 3;col++){
							if(Gui.buttons[row][col].getBackground().equals(color) && 
									Gui.buttons[row-1][col+1].getBackground().equals(color) && 
									Gui.buttons[row-2][col+2].getBackground().equals(color) && 
									Gui.buttons[row-3][col+3].getBackground().equals(color)){
								return true;
							}
						}			
					}
					//check diagonal up
					for(int row = 0; row< Gui.buttons.length-3; row++){
						for (int col = 0;col < Gui.buttons[0].length - 3;col++){
							if(Gui.buttons[row][col].getBackground().equals(color) && 
									Gui.buttons[row+1][col+1].getBackground().equals(color) && 
									Gui.buttons[row+2][col+2].getBackground().equals(color) && 
									Gui.buttons[row+3][col+3].getBackground().equals(color)){
								return true;
							}
						}			
					}
				} catch (ArrayIndexOutOfBoundsException x) {
					System.out.println("clicked too far somewhere");
				}
			return false;
		}
}
