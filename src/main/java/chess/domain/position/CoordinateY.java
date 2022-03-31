package chess.domain.position;

import java.util.Arrays;
import java.util.Comparator;

import java.util.List;
import java.util.stream.Collectors;

public enum CoordinateY {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    ;

    private static final int ONE_STEP = 1;

    private final int order;

    CoordinateY(final int order) {
        this.order = order;
    }

    public static CoordinateY from(final int other) {
        return Arrays.stream(CoordinateY.values())
                .filter(coordinateY -> coordinateY.order == other)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("체스판 범위를 벗어납니다."));
    }

    public static List<CoordinateY> reversed() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing(CoordinateY::getOrder).reversed())
                .collect(Collectors.toUnmodifiableList());
    }

    public CoordinateY next(final CoordinateY to) {
        if (this == to) {
            return to;
        }
        int nextStep = getNextStep(this, to);
        return Arrays.stream(CoordinateY.values())
                .filter(coordinateY -> this.order + nextStep == coordinateY.order)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("체스판 범위를 벗어납니다."));
    }

    private int getNextStep(final CoordinateY from, final CoordinateY to) {
        if (to.order > from.order) {
            return ONE_STEP;
        }
        return -ONE_STEP;
    }

    public int getOrder() {
        return order;
    }
}