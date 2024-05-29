package boardgame;

//estendendo de Runtime para ser uma exceção que será tratada opcionalmente
public class BoardException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	// Construtor que receberá a mensagem e enviará para a classe RuntimeException
	public BoardException (String msg) {
		super(msg);
	}
}
