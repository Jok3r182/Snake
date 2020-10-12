package SnakeGame.Controls;

import SnakeGame.Rules;

public class CommandFactory {


    public void createCommand(int key, Rules gamerules)
    {
        switch (key){
            case 'a':
                 new MoveLeft(gamerules).execute();
                    break;
            case 'd':
                new MoveRight(gamerules).execute();
                    break;
            case 's':
                new MoveDown(gamerules).execute();
                    break;
            case 'w':
                new MoveUp(gamerules).execute();
               break;
            case 'q':
                new ExitProgram(gamerules).execute();
                break;
        }
    }

}
