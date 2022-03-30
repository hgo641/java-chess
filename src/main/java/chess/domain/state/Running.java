package chess.domain.state;

import chess.domain.ChessBoard;
import chess.domain.Result;

public abstract class Running extends Started {

    protected Running(ChessBoard chessBoard) {
        super(chessBoard);
    }

    @Override
    public final State start() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final State end() {
        return new End(chessBoard);
    }

    @Override
    public final boolean isFinished() {
        return false;
    }

    @Override
    public final Result winner() {
        throw new UnsupportedOperationException();
    }
}