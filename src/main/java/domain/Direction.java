package domain;

import java.util.Map;
import java.util.function.BiFunction;

public enum Direction {
    LEFT(Direction::moveLeft),
    RIGHT(Direction::moveRight),
    STILL(Direction::stayStill);

    public final BiFunction<Integer, Integer, Map<Direction, Integer>> nextPosition;

    Direction(BiFunction<Integer, Integer, Map<Direction, Integer>> nextPosition) {
        this.nextPosition = nextPosition;
    }

    private static Map<Direction, Integer> moveLeft(Integer currentLeft, Integer currentRight) {
        return Map.of(LEFT, currentLeft - 1, RIGHT, currentLeft);
    }

    private static Map<Direction, Integer> moveRight(Integer currentLeft, Integer currentRight) {
        return Map.of(LEFT, currentRight, RIGHT, currentRight + 1);
    }

    private static Map<Direction, Integer> stayStill(Integer currentLeft, Integer currentRight) {
        return Map.of(LEFT, currentLeft, RIGHT, currentRight);
    }
}
