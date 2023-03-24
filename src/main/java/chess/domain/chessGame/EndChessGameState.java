package chess.domain.chessGame;

import chess.domain.board.Board;
import chess.domain.piece.Piece;
import chess.domain.position.Position;
import java.util.Map;

public class EndChessGameState implements ChessGameState {
    @Override
    public ChessGameState start() {
        throw new IllegalArgumentException("이미 종료된 게임입니다.");
    }

    @Override
    public void validateMove(String currentPosition, String nextPosition, Piece movingPiece) {
        throw new IllegalArgumentException("이미 종료된 게임입니다.");
    }

    @Override
    public ChessGameState end() {
        throw new IllegalArgumentException("이미 종료된 게임입니다.");
    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    public Map<Position, String> getPrintingBoard(Board board) {
        throw new IllegalArgumentException("이미 종료된 게임입니다.");
    }
}