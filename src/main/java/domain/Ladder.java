package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import util.BooleanGenerator;
import util.RandomBooleanGenerator;

public class Ladder {

    private static final BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
    private List<Line> lines;

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
}
