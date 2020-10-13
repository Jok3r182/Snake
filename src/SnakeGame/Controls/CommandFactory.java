package SnakeGame.Controls;

import SnakeGame.Rules;

public class CommandFactory {


    public Command createCommand(int key, Rules gamerules) {

        switch (key) {
            case 'a':
                return new MoveLeft(gamerules);
            case 'd':
                return new MoveRight(gamerules);
            case 's':
                return new MoveDown(gamerules);
            case 'w':
                return new MoveUp(gamerules);
            case 'q':
                return new ExitProgram(gamerules);
            default:
                return new UnwantedCommand();
        }

    }

}
