package ladder;

import ladder.strategy.RandomValueBuildStrategy;
import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Application {
    private static final String ALL_PARTICIPANT = "all";

    public static void main(String[] args) {
        Players players = InputView.inputNames();
        Items items = InputView.inputItems(players.getNumberOfPlayers());
        LadderHeight height = InputView.inputHeight();

        LadderBuilder ladderBuilder = new LadderBuilder(new RandomValueBuildStrategy());
        Ladder ladder = ladderBuilder.build(height, players.getNumberOfPlayers());

        OutputView.printLadderGame(players, ladder, items);

        LadderResult ladderResult = ladder.play();
        List<String> result = ladderResult.match(items);

        String participant;

        do {
            participant = InputView.inputParticipant(players);
            OutputView.printResult(players, result, participant);
        } while (!participant.equals(ALL_PARTICIPANT));
    }
}
