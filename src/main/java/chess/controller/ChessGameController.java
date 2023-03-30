package chess.controller;

import chess.dao.ChessGameDao;
import chess.domain.chessGame.ChessGame;
import chess.domain.command.Command;
import chess.domain.command.CommandType;
import chess.domain.command.MoveCommand;
import chess.domain.piece.Color;
import chess.domain.piece.Piece;
import chess.domain.position.Position;
import chess.view.InputView;
import chess.view.OutputView;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ChessGameController {
    private final Map<CommandType, CommandAction> commandMapper;
    private final ChessGameDao chessGameDao = new ChessGameDao();

    public ChessGameController() {
        this.commandMapper = new EnumMap<>(CommandType.class);
        commandMapper.put(CommandType.START, this::start);
        commandMapper.put(CommandType.MOVE, this::move);
        commandMapper.put(CommandType.END, this::end);
        commandMapper.put(CommandType.STATUS, this::printScores);
    }

    public void play() {
        ChessGame chessGame = chessGameDao.select();

        if (chessGame.isEmpty()) {
            chessGame = new ChessGame();
            chessGameDao.save(chessGame);
        }

        OutputView.printStartMessage();
        do {
            executeCorrectCommand(chessGame);
        } while (chessGame.isPlaying());
    }

    private void executeCorrectCommand(ChessGame chessGame) {
        try {
            List<String> inputCommand = InputView.inputCommand();
            executeCommand(chessGame, inputCommand);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            executeCorrectCommand(chessGame);
        }
    }

    private void executeCommand(ChessGame chessGame, List<String> commands) {
        CommandType commandType = CommandType.getCommandType(commands);
        Command command = commandType.getCommand(commands);
        CommandAction commandAction = commandMapper.get(commandType);
        commandAction.execute(chessGame, command);
    }

    private void start(ChessGame chessGame, Command command) {
        chessGame.start();
        printBoard(chessGame);
    }

    private void move(ChessGame chessGame, Command command) {
        MoveCommand moveCommand = (MoveCommand) command;
        String currentPosition = moveCommand.getCurrentPosition();
        String nextPosition = moveCommand.getNextPosition();
        chessGame.move(currentPosition, nextPosition);
        if (chessGame.isEnd()) {
            printWinner(chessGame.getTurnName());
            return;
        }
        printBoard(chessGame);
        updateChessGameByMoveCommand(chessGame, moveCommand);
    }

    private void updateChessGameByMoveCommand(ChessGame chessGame, MoveCommand moveCommand) {
        Position currentPosition = Position.from(moveCommand.getCurrentPosition());
        Position nextPosition = Position.from(moveCommand.getNextPosition());
        updateChessGame(chessGame, currentPosition);
        updateChessGame(chessGame, nextPosition);
    }

    private void updateChessGame(ChessGame chessGame, Position position) {
        Piece piece = chessGame.findPieceByPosition(position);
        chessGameDao.update(chessGame, position, piece);
    }

    private void end(ChessGame chessGame, Command command) {
        chessGame.end();
    }

    private void printBoard(ChessGame chessGame) {
        OutputView.printBoard(chessGame.getPrintingBoard());
    }

    private void printScores(ChessGame chessGame, Command command) {
        Map<Color, Double> scores = chessGame.getScores();
        OutputView.printScores(scores);
    }

    private void printWinner(String winner) {
        OutputView.printWinner(winner);
    }
}

interface CommandAction {
    void execute(ChessGame chessGame, Command command);
}
