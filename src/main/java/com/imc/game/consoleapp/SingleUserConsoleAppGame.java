package com.imc.game.consoleapp;

import com.imc.game.GameSession;
import com.imc.game.IGameSession;
import com.imc.game.exception.GameRuntimeException;
import com.imc.model.*;
import com.imc.util.IGameConsole;

public class SingleUserConsoleAppGame extends ConsoleAppGame implements IConsoleAppGame {
    public SingleUserConsoleAppGame(IGameConsole iGameConsole) {
        super(iGameConsole);
    }

    public void start() throws GameRuntimeException {
        this.gameConsole.writeToConsole("Let's play Rock-Paper-Scissors with computer");

        String playerName = this.gameConsole.readString("Player name : ");
        int nuOfRounds = this.gameConsole.readNumber("How many rounds do you want to play ? :");

        IComputerPlayer computer = new ComputerPlayer();
        IUser user = new User(playerName);

        startNewGameSessionWithComputer(user, computer, nuOfRounds);
    }

    /**
     * Start new console app game with computer
     *
     * @param user
     * @param computerPlayer
     * @param nuOfRounds
     */
    private void startNewGameSessionWithComputer(IUser user, IComputerPlayer computerPlayer, int nuOfRounds) {
        final String INVALID_SYMBOL = "Invalid Move";

        IGameSession gameSession = new GameSession(user, computerPlayer);
        int roundNo = 1;

        while (nuOfRounds >= roundNo) {
            this.gameConsole.writeToConsole("\n", "====== ROUND : " + roundNo + " ======");

            String userMove = getUserInput();

            if (!isValidUserMove(userMove)) {
                this.gameConsole.writeToConsole(INVALID_SYMBOL);
                continue;
            }

            if (userMove.equals(EXIT_CODE)) {
                break;
            }

            Symbol symbol = getSymbolFromInputCode(userMove);

            user.setNextMove(symbol);
            computerPlayer.setNextMove();

            Result result = gameSession.play();
            showResult(result);

            roundNo++;
        }
    }
}
