package chess.domain;

import chess.domain.CommandAction;
import chess.domain.chessGame.ChessGame;
import chess.view.OutputView;

public class MoveAction implements CommandAction {
    OutputView outputView = new OutputView();
    private String currentPositionCommand;
    private String nextPositionCommand;

    @Override
    public ChessGame execute(ChessGame chessGame){
        ChessGame newChessGame = chessGame.move(currentPositionCommand, nextPositionCommand);
        outputView.printBoard(newChessGame.getPrintingBoard());
        return newChessGame;
    }

    public void setPositionCommand(String currentPositionCommand, String nextPositionCommand){
        this.currentPositionCommand = currentPositionCommand;
        this.nextPositionCommand = nextPositionCommand;
    }
}
