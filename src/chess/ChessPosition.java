package chess;


import boardgame.position;

public class ChessPosition{
  

	private char column;
	private int row;
	
	public ChessPosition(char column, int row)
	{
		if(column < 'a' || column > 'h' || row < 1 || row > 8)
		{
			throw new ChessException("Error instantiating ChessPosition. Valida values are beetwen a and 8");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}
	public int getRow() {
		return row;
	}
	protected position toPosition()
	{
		return new position(8 - row,column - 'a');
	}
    protected static ChessPosition fromPosition(position position)
    {
    	return new ChessPosition((char)('a'+ position.getColumn()), 8 - position.getRow());
    }
	
    @Override
    public String toString()
    {
    	return "" + column + row;
    }
}
