package boardgame;

public abstract class Piece {

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
	
	public abstract boolean[][] possibleMoves();
	
	// Hook method
	// Método concreto que faz um gancho (utiliza) o método abstrato da subclasse
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	// Varrer a matriz pra ver se existe alguma posição que seja true, ou seja, que
	// a peca possa se mover. Quando a matriz é instanciada os valores default são false
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
