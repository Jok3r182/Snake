package SnakeGame.Controls;

import SnakeGame.Rules;

public class MoveUp implements Command{
    private Rules gameRules;

    public MoveUp(Rules gameRules)
    {
        this.gameRules=gameRules;
    }

    @Override
    public void execute() {

        gameRules.moveUp();

    }
}
