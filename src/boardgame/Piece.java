package boardgame;

public class Piece {

	protected Position position;
	private Board board;
	
	// Inicializar somente o tabuleiro, pois a peça inicialmente não foi colocada
	// no tabuleiro ainda portanto é nula;
	public Piece(Board board) {
		this.board = board;
	}

	protected Board getBoard() {
		return board;
	}
}
