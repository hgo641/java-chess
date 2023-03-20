package chess.domain.piece.moveRule;

import static chess.domain.piece.moveRule.TestFixture.A1;
import static chess.domain.piece.moveRule.TestFixture.B2;
import static chess.domain.piece.moveRule.TestFixture.B3;
import static chess.domain.piece.moveRule.TestFixture.D4;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import chess.domain.piece.Color;
import chess.domain.piece.Piece;
import chess.domain.position.Position;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BishopMoveRuleTest {
    private final MoveRule moveRule = BishopMoveRule.getInstance();
    private Piece blackPiece;
    private Piece whitePiece;
    private Map<Position, Piece> board;

    @BeforeAll
    void setUp() {
        blackPiece = new Piece(moveRule, Color.BLACK);
        whitePiece = new Piece(moveRule, Color.WHITE);
    }

    @BeforeEach
    void initBoard() {
        board = new HashMap<>();
    }

    @Test
    void 비숍_움직임_실패() {
        board.put(A1, blackPiece);
        board.put(B3, whitePiece);

        assertThatThrownBy(() -> moveRule.move(A1, B3, board))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비숍은 대각선상으로만 움직일 수 있습니다.");
    }


    @Test
    void 비숍_움직임_실패_중간경로에_기물_존재() {
        board.put(B2, whitePiece);
        board.put(A1, whitePiece);
        board.put(D4, blackPiece);

        assertThatThrownBy(() -> moveRule.move(A1, D4, board))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경로상에 다른 기물이 있어 움직일 수 없습니다.");
    }
}