package chess.domain;

import chess.domain.chessGame.ChessGame;

public class EndAction implements CommandAction{
    @Override
    public ChessGame execute(ChessGame chessGame) {
        return chessGame.end();
    }
}
