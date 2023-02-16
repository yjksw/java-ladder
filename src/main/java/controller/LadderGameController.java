package controller;

import domain.LadderGame;
import java.util.List;
import view.InputView;
import view.ResultView;

public class LadderGameController {

    private final InputView inputView;
    private final ResultView resultView;

    public LadderGameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        List<String> names = inputView.readNames();
        int height = inputView.readHeight();

        LadderGame ladderGame = new LadderGame(names, height);
        resultView.drawLadder(names, ladderGame.ladderDrawing());
    }

}
