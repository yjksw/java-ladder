package domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import util.BooleanGenerator;

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
}
