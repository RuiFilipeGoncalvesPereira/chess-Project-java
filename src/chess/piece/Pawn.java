package chess.piece;

import boardgame.Board;
import boardgame.position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		position P = new position(0, 0);
		
		if(getColor() == Color.WHITE)
		{
			P.setValues(position.getRow()-1, position.getColumn());
			if(getBoard().positionExists(P) && !getBoard().thereIsPiece(P))
			{
				mat[P.getRow()][P.getColumn()] = true;
			}
			P.setValues(position.getRow()-2, position.getColumn());
			position P2 = new position(position.getRow()-1, position.getColumn());
			if(getBoard().positionExists(P) && !getBoard().thereIsPiece(P) && getBoard().positionExists(P2) && !getBoard().thereIsPiece(P2) && getMoveCount() == 0)
			{
				mat[P.getRow()][P.getColumn()] = true;
			}
			P.setValues(position.getRow()-1, position.getColumn() - 1);
			if(getBoard().positionExists(P) && isThereOpponentPiece(P))
			{
				mat[P.getRow()][P.getColumn()] = true;
			}
			P.setValues(position.getRow()-1, position.getColumn() + 1);
			if(getBoard().positionExists(P) && isThereOpponentPiece(P))
			{
				mat[P.getRow()][P.getColumn()] = true;
			}
		}
		else
		{
			P.setValues(position.getRow() + 1, position.getColumn());
			if(getBoard().positionExists(P) && !getBoard().thereIsPiece(P))
			{
				mat[P.getRow()][P.getColumn()] = true;
			}
			P.setValues(position.getRow() + 2, position.getColumn());
			position P2 = new position(position.getRow()+1, position.getColumn());
			if(getBoard().positionExists(P) && !getBoard().thereIsPiece(P) && getBoard().positionExists(P2) && !getBoard().thereIsPiece(P2) && getMoveCount() == 0)
			{
				mat[P.getRow()][P.getColumn()] = true;
			}
			P.setValues(position.getRow() + 1, position.getColumn() - 1);
			if(getBoard().positionExists(P) && isThereOpponentPiece(P))
			{
				mat[P.getRow()][P.getColumn()] = true;
			}
			P.setValues(position.getRow() + 1, position.getColumn() + 1);
			if(getBoard().positionExists(P) && isThereOpponentPiece(P))
			{
				mat[P.getRow()][P.getColumn()] = true;
			}
		}
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}
	

}
