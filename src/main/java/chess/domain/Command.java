package chess.domain;

import chess.domain.chessGame.ChessGame;

public interface CommandAction {
    ChessGame execute(ChessGame chessGame);
}
