import controller.LadderGameController;
import view.InputView;
import view.ResultView;

public class MainApplication {

    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController(new InputView(), new ResultView());
        ladderGameController.run();
    }
}
