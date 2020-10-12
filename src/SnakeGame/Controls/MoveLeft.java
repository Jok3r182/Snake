package SnakeGame.Controls;

import SnakeGame.Rules;

public class MoveLeft implements Command {

    private Rules gameRules;

    public MoveLeft(Rules gameRules)
    {
        this.gameRules=gameRules;
    }

    @Override
    public void execute() {

        gameRules.moveLeft();

    }
}
