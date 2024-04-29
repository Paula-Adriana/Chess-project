package chess;

import boardgame.Board;

public class ChessMatch {
	
	private Board board;

	public ChessMatch(Board board) {
		this.board = board;
	}

	public ChessMatch() {
		board = new Board(8, 8);
	}
	
	// Retorna uma matriz das peças referentes a essa partida. Fazer o downcast das
	// peças comuns 'piece' para as chesspiece. Enviar para a camada de aplicação
	// somente as peças referentes à partida de xadrez e não das peças nativas 'piece'.
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				//downcast
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
}
