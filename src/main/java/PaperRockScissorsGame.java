import com.imc.game.IGame;
import com.imc.game.consoleapp.SingleUserConsoleAppGame;
import com.imc.util.exception.GameRuntimeException;
import com.imc.util.console.GameConsole;
import com.imc.util.console.IGameConsole;

public class PaperRockScissorsGame {
    public static void main(String[] args) {
        // TODO: Introduce DI
        IGameConsole gameConsole = new GameConsole();
        IGame game = new SingleUserConsoleAppGame(gameConsole);

        try {
            game.start();
        } catch (GameRuntimeException e) {
            // TODO: Implement logger
            e.printStackTrace();
        }
    }
}
