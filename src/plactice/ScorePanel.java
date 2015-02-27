package plactice;

import java.awt.*;
import java.text.DecimalFormat;
import javax.swing.JPanel;

public class ScorePanel extends JPanel
{
	public static final int WIDTH = 96;
	public static final int HEIGHT = 16;
	
	private int score;
	public ScorePanel() 
	{
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	
	public void paitComponent(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(Color.YELLOW);
		DecimalFormat formatter = new DecimalFormat("000000");
		Font font = new Font("Ariel", Font.BOLD, 16);
		g.setFont(font);
		g.drawString(formatter.format(score), 16, 12);
	}
	
	public void setScore(int score)
	{
		this.score = score;
		repaint();
	}
	
	public void upScore(int d)
	{
		score += d;
		repaint();
	}

}
