package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static domain.Direction.RIGHT;

public class LadderGame {

    private final List<String> names;
    private final List<String> cases;
    private final Ladder ladder;
    private final Map<String, String> results;

    public LadderGame(List<String> names, List<String> cases, int height) {
        validateSize(names, cases);
        this.names = names;
        this.cases = cases;
        this.ladder = new Ladder(height, names.size() - 1);
        this.results = new HashMap<>();
    }

    private void validateSize(List<String> names, List<String> cases) {
        if (names.size() != cases.size()) {
            throw new IllegalArgumentException("이름과 결과는 동일한 개수여야 합니다.");
        }
    }

    public String result(String name) {
        validateName(name);
        return results.computeIfAbsent(name, this::calculateResult);
    }

    public Map<String, String> result() {
        for (String name : names) {
            validateName(name);
            results.computeIfAbsent(name, this::calculateResult);
        }

        return results;
    }

    public Map<Integer, List<Boolean>> ladderDrawing() {
        return ladder.drawing();
    }

    private void validateName(String name) {
        if (names.contains(name)) {
            return;
        }

        throw new IllegalArgumentException("존재하는 이름이 아닙니다.");
    }

    private String calculateResult(String name) {
        int indexOfCase = ladder.result(names.indexOf(name));
        return cases.get(indexOfCase);
    }
}
