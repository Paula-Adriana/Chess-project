package boardgame;

public class Board {

	private int rows;
	private int columns;
	
	//Matriz das peças
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		// A matriz é instanciada com uma quantidade de linhas e coluna informada.
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece (int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	public Piece piece (Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	// Método que colocará a peça em determinada posição
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		// Se a posição da peça for null quer dizer que não existe peça nessa posição a ser removida
		if (piece(position) == null) {
			return null;
		}
		// Removendo a peça
		// aux recebe a posição da peça no tabuleiro recebendo null
		Piece aux = piece(position);
		aux.position = null;
		// A matriz de peças nesta posição que estamos removendo a peça tb receberá null
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	// As vezes será mais fácil a verificação se a posição existe pela linha e coluna
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	// Verifica se a posição existe no tabuleiro
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	// Verifica se há uma peça em determinada posição
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
}
