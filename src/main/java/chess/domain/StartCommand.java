package chess.domain;

import chess.domain.chessGame.ChessGame;
import chess.view.OutputView;

public class StartAction implements CommandAction{
    OutputView outputView = new OutputView();

    @Override
    public ChessGame execute(final ChessGame chessGame){
        ChessGame newChessGame = chessGame.start();
        outputView.printBoard(newChessGame.getPrintingBoard());
        return newChessGame;
    }
}
