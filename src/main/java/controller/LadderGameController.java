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
        List<String> results = inputView.readResults();
        int height = inputView.readHeight();

        LadderGame ladderGame = new LadderGame(names, results, height);
        resultView.drawLadder(names, results, ladderGame.ladderDrawing());

        gameResult(ladderGame);
    }

    private void gameResult(LadderGame ladderGame) {
        while(true) {
            String name = inputView.askResult();
            if (name.equals("all")) {
                resultView.printResult(ladderGame.result());
                continue;
            }

            resultView.printResult(ladderGame.result(name));
        }
    }

    public void error(String message) {
        resultView.printError(message);
    }
}
