package SnakeGame.Controls;

import SnakeGame.Rules;

public class MoveRight implements Command{
    private Rules gameRules;

    public MoveRight(Rules gameRules)
    {
        this.gameRules=gameRules;
    }

    @Override
    public void execute() {

        gameRules.moveRight();

    }
}
