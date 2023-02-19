package domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import util.BooleanGenerator;

import static domain.Direction.LEFT;
import static domain.Direction.RIGHT;
import static java.lang.Boolean.TRUE;

public class Line {

    private final List<Boolean> line;

    public Line(int width, BooleanGenerator booleanGenerator) {
        this.line = makeLine(width, booleanGenerator);
    }

    private List<Boolean> makeLine(int width, BooleanGenerator booleanGenerator) {
        boolean bridgeExists = false;
        List<Boolean> line = new LinkedList<>();

        for (int i = 0; i < width; i++) {
            bridgeExists = makeBridge(booleanGenerator, bridgeExists);
            line.add(bridgeExists);
        }

        return Collections.unmodifiableList(line);
    }

    private boolean makeBridge(BooleanGenerator booleanGenerator, boolean bridgeExists) {
        if (bridgeExists) {
            return false;
        }

        return booleanGenerator.get();
    }

    public List<Boolean> drawing() {
        return line;
    }

    public Map<Direction, Integer> move(Map<Direction, Integer> position) {
        Direction move = position.keySet().stream()
                .filter(direction -> isMovingDirection(position, direction))
                .findAny()
                .orElse(Direction.STILL);

        return move.nextPosition.apply(position.get(LEFT), position.get(RIGHT));
    }

    private boolean isMovingDirection(Map<Direction, Integer> position, Direction direction) {
        try {
            return line.get(position.get(direction)) == TRUE;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
}
