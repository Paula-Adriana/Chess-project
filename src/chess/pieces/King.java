package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}

	// Onde a peça rei estiver aparecerá no tabuleiro como "K"
	@Override
	public String toString() {
		return "K";
	}
}
