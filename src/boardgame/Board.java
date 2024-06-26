package boardgame;


public class Board {
	
	private int rows;
	private int columns;
	
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must ar least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

    public Piece piece(int rook, int position)
    {
    	if(!positionExists(rook, position))
    	{
    		throw new BoardException("Position not on the board");	
    	}
    	return pieces[rook][position];
    }
	public Piece piece(position position)
	{  
    	if(!positionExists(position))
    	{
    		throw new BoardException("Position not on the board");	
    	}
		return pieces[position.getRow()][position.getColumn()];
	}
	public void placePiece(Piece piece, position position)
	{
		if (thereIsPiece(position))
		{
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	private boolean positionExists(int row, int column)
	{
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	public boolean positionExists(position position)
	{
		return positionExists(position.getRow(), position.getColumn());
	}
	public boolean thereIsPiece(position position)
	{
    	if(!positionExists(position))
    	{
    		throw new BoardException("Position not on the board");	
    	}	 
	   return piece(position) != null;
	}

}
