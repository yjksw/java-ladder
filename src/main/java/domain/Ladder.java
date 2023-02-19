package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import util.BooleanGenerator;
import util.RandomBooleanGenerator;

import static domain.Direction.LEFT;
import static domain.Direction.RIGHT;

public class Ladder {

    private static final BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
    private final List<Line> lines;

    public Ladder(int height, int width) {
        this.lines = makeLines(height, width);
    }

    private List<Line> makeLines(int height, int width) {
        List<Line> lines = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(width, booleanGenerator));
        }

        return Collections.unmodifiableList(lines);
    }

    public Map<Integer, List<Boolean>> drawing() {
        Map<Integer, List<Boolean>> drawing = new HashMap<>();
        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            drawing.put(i, line.drawing());
        }

        return drawing;
    }

    public int result(int indexOfName) {
        Map<Direction, Integer> currentPosition = Map.of(LEFT, indexOfName - 1, RIGHT, indexOfName);
        int currentHeight = 0;

        while (currentHeight < lines.size()) {
            currentPosition = decideMove(currentPosition, currentHeight);
            currentHeight++;
        }

        return currentPosition.get(RIGHT);
    }

    private Map<Direction, Integer> decideMove(Map<Direction, Integer> position, int height) {
        Line currentLine = lines.get(height);
        return currentLine.move(position);
    }
}
