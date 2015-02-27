package plactice;

public class SquareBlock extends Block {

	public SquareBlock(Field field)
	{
		super(field);
		
		// □□□□
        // □■■□
        // □■■□
        // □□□□
		block[1][1] = 1;
        block[1][2] = 1;
        block[2][1] = 1;
        block[2][2] = 1;
        
        imageNo = Block.SQUARE;
	}

}
