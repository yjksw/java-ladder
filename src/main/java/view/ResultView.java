package view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    private static final String column = "|";
    private static final String emptyRow = "     ";
    private static final String row = "-----";
    public static final int NAME_SPACE = 6;

    public void drawLadder(List<String> names, Map<Integer, List<Boolean>> ladderDrawing) {
        System.out.println(namesWithPadding(names));

        String ladder = ladderDrawing.values().stream()
            .map(this::drawing)
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.println(ladder);
    }

    private String drawing(List<Boolean> line) {
       return line.stream()
           .map(bridge -> column + drawBridge(bridge))
           .collect(Collectors.joining("", emptyRow, column));
    }

    private String drawBridge(Boolean bridge) {
        if (bridge) {
            return row;
        }

        return emptyRow;
    }

    private String namesWithPadding(List<String> names) {
        return names.stream()
            .map(this::addPadding)
            .collect(Collectors.joining(""));
    }

    private String addPadding(String s) {
        int padSize = NAME_SPACE - s.length();
        return " ".repeat(padSize) + s;
    }
}
