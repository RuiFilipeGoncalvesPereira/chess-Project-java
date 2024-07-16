package chess.piece;

import boardgame.Board;
import boardgame.position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece{
	
	public Bishop(Board board, Color color)
    {
    	super(board, color);
    }
    
    @Override
    public String toString()
    {
    	return "B";
    }
    
	@Override
	public boolean[][] possibleMoves() {
		boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		position P = new position(0, 0);
		
		// nw
		P.setValues(position.getRow() -1, position.getColumn()-1);
		while (getBoard().positionExists(P) && !getBoard().thereIsPiece(P))
		{
			mat[P.getRow()][P.getColumn()]= true;
			P.setValues(P.getRow() -1, P.getColumn() -1 );
		}
		if (getBoard().positionExists(P) && isThereOpponentPiece(P))
		{
			mat[P.getRow()][P.getColumn()]= true;
		}
		
		// ne
		P.setValues(position.getRow() - 1, position.getColumn() +1);
		while (getBoard().positionExists(P) && !getBoard().thereIsPiece(P))
		{
			mat[P.getRow()][P.getColumn()]= true;
			P.setValues(P.getRow() -1, P.getColumn() +1 );
		}
		if (getBoard().positionExists(P) && isThereOpponentPiece(P))
		{
			mat[P.getRow()][P.getColumn()]= true;
		}
		
		// se
		P.setValues(position.getRow() + 1, position.getColumn() +1);
		while (getBoard().positionExists(P) && !getBoard().thereIsPiece(P))
		{
			mat[P.getRow()][P.getColumn()]= true;
			P.setValues(P.getRow() + 1, P.getColumn() + 1);
		}
		if (getBoard().positionExists(P) && isThereOpponentPiece(P))
		{
			mat[P.getRow()][P.getColumn()]= true;
		}
		
		// sw
		P.setValues(position.getRow() +1, position.getColumn()-1);
		while (getBoard().positionExists(P) && !getBoard().thereIsPiece(P))
		{
			mat[P.getRow()][P.getColumn()]= true;
			P.setValues(P.getRow() + 1, P.getColumn() - 1);
		}
		if (getBoard().positionExists(P) && isThereOpponentPiece(P))
		{
			mat[P.getRow()][P.getColumn()]= true;
		}
		
		return mat;
	}

}
