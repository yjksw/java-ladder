package view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    private static final String COLUMN = "|";
    private static final String EMPTY_ROW = "      ";
    private static final String ROW = "------";
    public static final String GAME_RESULT = "실행결과";
    public static final int NAME_SPACE = 7;

    public void drawLadder(List<String> names, List<String> results, Map<Integer, List<Boolean>> ladderDrawing) {
        System.out.println(withPaddings(names));

        String ladder = ladderDrawing.values().stream()
            .map(this::drawing)
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.println(ladder);
        System.out.println(withPaddings(results));
    }

    private String drawing(List<Boolean> line) {
       return line.stream()
           .map(bridge -> COLUMN + drawBridge(bridge))
           .collect(Collectors.joining("", EMPTY_ROW, COLUMN));
    }

    private String drawBridge(Boolean bridge) {
        if (bridge) {
            return ROW;
        }

        return EMPTY_ROW;
    }

    private String withPaddings(List<String> outputs) {
        return outputs.stream()
            .map(this::addPadding)
            .collect(Collectors.joining(""));
    }

    private String addPadding(String s) {
        int padSize = NAME_SPACE - s.length();
        return " ".repeat(padSize) + s;
    }

    public void printResult(Map<String, String> result) {
        System.out.println(GAME_RESULT);

        String gameResult = result.keySet()
                .stream()
                .map(key -> key + " : " + result.get(key))
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.println(gameResult);
    }

    public void printResult(String result) {
        System.out.println(GAME_RESULT);
        System.out.println(result);
    }

    public void printError(String message) {
        System.out.println("ERROR: " + message);
    }
}
