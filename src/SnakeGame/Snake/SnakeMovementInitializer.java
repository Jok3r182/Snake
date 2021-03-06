package SnakeGame.Snake;

public class SnakeMovementInitializer {
    private char command;
    private char tempCommand;
    private Snake snake;


    public SnakeMovementInitializer(Snake snake)
    {
        this.snake=snake;
    }
    public void InitializeMovement(char keypressed) {
        if (checkIfCorrectKeyWasPressed(keypressed)) {
            snakeMovement(keypressed);
        }
    }

    public char getCommand() {
        return command;
    }

    private Character snakeMovement(char keypressed)
    {
        if (snake.getTailPositions().size()==0)
        {
            command=keypressed;
        }
        else {
            command=checkIfSnakeCanMoveInReversedPosition(keypressed);
        }
        return command;
    }


    private boolean checkIfCorrectKeyWasPressed(char keypressed) {
        return keypressed == 'w' || keypressed == 's' || keypressed == 'a' || keypressed == 'd' || keypressed == 'q';
    }

    private Character checkIfSnakeCanMoveInReversedPosition(char keypressed)
    {
        tempCommand = keypressed;
        if (((command==0||(command == 'w' && tempCommand != 's') || (command == 's' && tempCommand != 'w')) || ((command == 'd' && tempCommand != 'a') || (command == 'a' && tempCommand != 'd')))) {
            command = tempCommand;
        }
        return command;
    }
}
