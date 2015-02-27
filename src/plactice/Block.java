package plactice;

import java.awt.*;

public class Block {
	
	//ブロックのサイズ
	public static final int ROW = 4;
	public static final int COL = 4;
	
	//1マスのサイズ
	private static final int TILE_SIZE = Field.TILE_SIZE;
	
	//移動方向
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int DOWN = 2;
	
	//ブロックの名前
	public static final int BAR = 0;
	public static final int Z_SHAPE = 1;
	public static final int SQUARE = 2;
	public static final int L_SHAPE = 3;
	public static final int REVERSE_Z_SHAPE = 4;
	public static final int T_SHAPE = 5;
	public static final int REVERSE_L_SHAPE = 6;
	public static final int WALL = 7;
	
	//ブロックの形を格納
	protected int[][] block = new int[ROW][COL];
	
	//イメージ番号
	protected int imageNo;
	
	//位置（単位：マス）
	protected Point pos;
	
	//フィールド参照
	protected Field field;
	

	public Block(Field field) 
	{
		this.field = field;
		
		init();
		
		imageNo = 6;
		pos = new Point(4, -4);		
		
	}
	
	//ブロックの初期化
	public void init()
	{
		for (int i = 0; i < ROW; i++)
		{
			for(int j = 0; j < COL; j++)
			{
				block[i][j] = 0;
			}
		}
	}
	
	//ブロックの描画
	public void draw(Graphics g, Image blockImage)
	{
		for (int i = 0; i < ROW; i++)
		{
			for (int j = 0; j < COL; j++)
			{
				if (block[i][j] == 1)
					// posの位置を基準とする点に注意！
					g.drawImage(blockImage,
								(pos.x+j) * TILE_SIZE,
								(pos.x+j) * TILE_SIZE,
								(pos.x+j) * TILE_SIZE + TILE_SIZE,
								(pos.x+j) * TILE_SIZE + TILE_SIZE,
								imageNo * TILE_SIZE,
								0,
								imageNo * TILE_SIZE + TILE_SIZE,
								TILE_SIZE,
								null);
			}
		}
	}
	
	//次のブロックパネル内にブロックを描画
	public void drawInPanel(Graphics g, Image blockImage)
	{
		for (int i = 0; i < ROW; i++)
			for (int j = 0; j < COL; j++)
				if (block[i][j] == 1)
					g.drawImage(blockImage,
							(j+1) * TILE_SIZE, 
							(j+1) * TILE_SIZE,
							(j+1) * TILE_SIZE + TILE_SIZE,
							(j+1) * TILE_SIZE + TILE_SIZE,
							imageNo * TILE_SIZE,
							0,
							imageNo * TILE_SIZE + TILE_SIZE,
							TILE_SIZE,
							null);
	}
	
	//dirの方向にブロックを移動
	public boolean move(int dir)
	{
		switch (dir)
		{
			//衝突しなければ位置を更新
		case LEFT :
			Point newPos = new Point(pos.x - 1, pos.y);
			if (field.isMovable(newPos, block)) pos = newPos;
			break;
		case RIGHT :
			newPos = new Point(pos.x + 1, pos.y);
			if (field.isMovable(newPos, block)) pos = newPos;
			break;
		case DOWN :
			newPos = new Point(pos.x, pos.y + 1);
			if (field.isMovable(newPos, block)) pos = newPos;
			else//	移動できない＝他のブロックとぶつかる＝固定する
				//	ブロックをフィールドに固定する
				field.fixBlock(pos,  block, imageNo);
				//	固定されたらtrueを返す
			return true;
		}
		return false;
		
	}
	
	//ブロックを回転させる
	public void turn()
	{
		int[][] turnedBlock = new int[ROW][COL];
		
		/**回転したブロック*/
		for (int i = 0; i < ROW; i++)
			for (int j = 0; j < COL; j++)
				turnedBlock[j][ROW - 1 -i] = block[i][j];
		
		//回転可能か調べる
		if (field.isMovable(pos,  turnedBlock)) {
			block = turnedBlock;
		}
	}

}
