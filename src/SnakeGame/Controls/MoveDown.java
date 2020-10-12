package SnakeGame.Controls;

import SnakeGame.Rules;

public class MoveDown implements Command{
    private Rules gameRules;

    public MoveDown(Rules gameRules)
    {
        this.gameRules=gameRules;
    }

    @Override
    public void execute() {
        gameRules.moveDown();
    }
}
