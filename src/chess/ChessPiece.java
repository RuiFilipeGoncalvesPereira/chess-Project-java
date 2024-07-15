package chess;


import boardgame.Board;
import boardgame.Piece;
import boardgame.position;

public abstract class ChessPiece extends Piece {
	
	private Color color;
	private int moveCount; //é inteiro por padrão começa por 0

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public int getMoveCount()
	{
		return moveCount;
	}
	
	public void increaseMoveCount()
	{
		moveCount++;
	}
	
	public void decreaseMoveCount()
	{
		moveCount--;
	}
	
	public ChessPosition getChessPosition()
	{
		return ChessPosition.fromPosition(position);
	}
	
	protected boolean isThereOpponentPiece(position position)
	{
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
	

}
