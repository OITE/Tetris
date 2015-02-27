package plactice;

import java.awt.*;
import javax.swing.JPanel;

public class NextBlockPanel extends JPanel{
	
	public static final int WIDTH = 96;
	public static final int HEIGHT = 400;
	
	private Block nextBlock;
	private Image blockImage;
	

	public NextBlockPanel() 
	{
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0,  0,  WIDTH,  HEIGHT);
		
		if (nextBlock != null) nextBlock.drawInPanel(g, blockImage);
	}
	
	public void set(Block nextBlock, Image blockImage)
	{
		this.nextBlock = nextBlock;
		this.blockImage = blockImage;
		repaint();
	}

}
