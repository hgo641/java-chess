package chess.domain.piece;

import java.util.Arrays;

public enum Form {

    BLACK_PAWN(new Pawn(Color.BLACK), "♟"),
    BLACK_ROOK(new Rook(Color.BLACK), "♜"),
    BLACK_KNIGHT(new Knight(Color.BLACK), "♞"),
    BLACK_BISHOP(new Bishop(Color.BLACK), "♝"),
    BLACK_QUEEN(new Queen(Color.BLACK), "♛"),
    BLACK_KING(new King(Color.BLACK), "♚"),

    WHITE_PAWN(new Pawn(Color.WHITE), "♙"),
    WHITE_ROOK(new Rook(Color.WHITE), "♖"),
    WHITE_KNIGHT(new Knight(Color.WHITE), "♘"),
    WHITE_BISHOP(new Bishop(Color.WHITE), "♗"),
    WHITE_QUEEN(new Queen(Color.WHITE), "♕"),
    WHITE_KING(new King(Color.WHITE), "♔"),
    ;

    private static final String NONE_PIECE_FORM = ".";

    private final Piece piece;
    private final String form;

    Form(final Piece piece, final String form) {
        this.piece = piece;
        this.form = form;
    }

    public static String getForm(final Piece other) {
        return Arrays.stream(Form.values())
                .filter(form -> form.piece.equals(other))
                .map(form -> form.form)
                .findFirst()
                .orElse(NONE_PIECE_FORM);
    }
}