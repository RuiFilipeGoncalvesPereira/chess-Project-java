package chess.piece;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;
import boardgame.position;

public class Rook extends ChessPiece {
	
    public Rook(Board board, Color color)
    {
    	super(board, color);
    }
    
    @Override
    public String toString()
    {
    	return "R";
    }
    
	@Override
	public boolean[][] possibleMoves() {
		boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		position P = new position(0, 0);
		
		// above
		P.setValues(position.getRow() -1, position.getColumn());
		while (getBoard().positionExists(P) && !getBoard().thereIsPiece(P))
		{
			mat[P.getRow()][P.getColumn()]= true;
			P.setRow(P.getRow() -1);
		}
		if (getBoard().positionExists(P) && isThereOpponentPiece(P))
		{
			mat[P.getRow()][P.getColumn()]= true;
		}
		
		// left
		P.setValues(position.getRow(), position.getColumn() -1);
		while (getBoard().positionExists(P) && !getBoard().thereIsPiece(P))
		{
			mat[P.getRow()][P.getColumn()]= true;
			P.setColumn(P.getColumn() -1);
		}
		if (getBoard().positionExists(P) && isThereOpponentPiece(P))
		{
			mat[P.getRow()][P.getColumn()]= true;
		}
		
		// right
		P.setValues(position.getRow(), position.getColumn()+1);
		while (getBoard().positionExists(P) && !getBoard().thereIsPiece(P))
		{
			mat[P.getRow()][P.getColumn()]= true;
			P.setColumn(P.getColumn() +1);
		}
		if (getBoard().positionExists(P) && isThereOpponentPiece(P))
		{
			mat[P.getRow()][P.getColumn()]= true;
		}
		
		// below
		P.setValues(position.getRow() +1, position.getColumn());
		while (getBoard().positionExists(P) && !getBoard().thereIsPiece(P))
		{
			mat[P.getRow()][P.getColumn()]= true;
			P.setRow(P.getRow() +1);
		}
		if (getBoard().positionExists(P) && isThereOpponentPiece(P))
		{
			mat[P.getRow()][P.getColumn()]= true;
		}
		
		return mat;
	}
	
}
