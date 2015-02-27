package plactice;

public class BarBlock extends Block
{

	public BarBlock(Field field) 
	{
		super(field);
		
		// □■□□
        // □■□□
        // □■□□
        // □■□□
		block[0][1] = 1;
		block[1][1] = 1;
		block[2][1] = 1;
		block[3][1] = 1;
		
		imageNo = Block.BAR;
	}

}
