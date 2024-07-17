package chess.piece;

import boardgame.Board;
import boardgame.position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
	
	private ChessMatch chessMatch;

	public Pawn(Board board, Color color,ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
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
			//#specialmove en passant whitte
			if(position.getRow() == 3)
			{
				position left = new position(position.getRow(), position.getColumn() -1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left)
				&& getBoard().piece(left) == chessMatch.getEnPassantVulnerable())
				{
					mat[left.getRow() - 1][left.getColumn()] = true;
				}
				position right = new position(position.getRow(), position.getColumn() +1);
				if(getBoard().positionExists(right) && isThereOpponentPiece(right)
				&& getBoard().piece(right) == chessMatch.getEnPassantVulnerable())
				{
					mat[right.getRow() - 1][right.getColumn()] = true;
				}
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
			//#specialmove en passant black
			if(position.getRow() == 4)
			{
				position left = new position(position.getRow(), position.getColumn() -1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left)
				&& getBoard().piece(left) == chessMatch.getEnPassantVulnerable())
				{
					mat[left.getRow() + 1][left.getColumn()] = true;
				}
				position right = new position(position.getRow(), position.getColumn() +1);
				if(getBoard().positionExists(right) && isThereOpponentPiece(right)
				&& getBoard().piece(right) == chessMatch.getEnPassantVulnerable())
				{
					mat[right.getRow() + 1][right.getColumn()] = true;
				}
			}
		}
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}
	

}
