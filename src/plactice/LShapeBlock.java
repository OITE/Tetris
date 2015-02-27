package plactice;

public class LShapeBlock extends Block{

	public LShapeBlock(Field field) 
	{
		super(field);
		
		// □□□□
        // □■■□
        // □□■□
        // □□■□
		block[1][1] = 1;
        block[1][2] = 1;
        block[2][2] = 1;
        block[3][2] = 1;
        
        imageNo = Block.L_SHAPE;	
		
	}

}
