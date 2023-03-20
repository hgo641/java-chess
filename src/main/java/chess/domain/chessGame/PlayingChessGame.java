package chess.domain.chessGame;

import chess.domain.Board;
import chess.domain.position.Position;
import java.util.Map;

public class PlayingChessGame implements ChessGame {
    private final Board board;
    private boolean isPlaying = true;

    public PlayingChessGame(Board board) {
        this.board = board;
    }

    @Override
    public Map<Position, String> move(String currentPositionSymbol, String nextPositionSymbol) { //b1
        Position currentPosition = Position.of(currentPositionSymbol);
        Position nextPosition = Position.of(nextPositionSymbol);
        return board.move(currentPosition, nextPosition);
    }

    @Override
    public ChessGame start() {
        throw new IllegalArgumentException("이미 플레이중인 게임입니다.");
    }

    @Override
    public void end() {
        isPlaying = false;
    }

    @Override
    public boolean isPlaying() {
        return isPlaying;
    }

    @Override
    public Map<Position, String> getPrintingBoard() {
        return board.getPrintingBoard();
    }
}