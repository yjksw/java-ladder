package domain;

import java.util.List;
import java.util.Map;
import util.BooleanGenerator;

public class LadderGame {

    private final List<String> names;
    private final Ladder ladder;

    public LadderGame(List<String> names, int height) {
        this.names = names;
        this.ladder = new Ladder(height, names.size() - 1);
    }

    public Map<Integer, List<Boolean>> ladderDrawing() {
        return ladder.drawing();
    }
}
