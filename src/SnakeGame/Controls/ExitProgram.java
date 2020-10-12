package SnakeGame.Controls;

import SnakeGame.Rules;

public class ExitProgram implements Command{
    private Rules gameRules;

    public ExitProgram(Rules gameRules)
    {
        this.gameRules=gameRules;
    }

    @Override
    public void execute() {

        gameRules.exitGame();

    }
}

