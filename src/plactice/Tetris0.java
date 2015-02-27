package plactice;

import java.awt.*;
import javax.swing.*;

public class Tetris0 extends JFrame
{
	public static void main(String[] args)
	{
		Tetris0 frame = new Tetris0();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	public Tetris0()
	{
		setTitle("テトリス");
		//サイズ変更不可
		setResizable(false);
		
		//スコアパネル
		ScorePanel scorePanel = new ScorePanel();
		//次のブロックパネル
		NextBlockPanel nextBlockPanel = new NextBlockPanel();
		
		//右側パネル
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		
		rightPanel.add(scorePanel,BorderLayout.NORTH);
		rightPanel.add(nextBlockPanel, BorderLayout.CENTER);
		
		//メインパネルを作成してフレームに追加
		//メインパネルからスコア表示パネルを操作するためscorePanel,nextBlockPanelを渡すひつようあり！
		MainPanel mainPanel = new MainPanel(scorePanel, nextBlockPanel);
		
		this.add(mainPanel, BorderLayout.CENTER);
		this.add(rightPanel, BorderLayout.EAST);
		
		
		
		//パネルサイズに会わせてフレームサイズを自動設定
		pack();
		
	}
	
	
}
