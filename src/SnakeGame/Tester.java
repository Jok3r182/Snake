package SnakeGame;

import SnakeGame.Food.Apple;
import SnakeGame.Food.GoldenApple;
import SnakeGame.Snake.Snake;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Tester {
    private Map map = Map.getInstance();
    private Snake snake = new Snake(map);
    private Apple apple = new Apple(map);
    private Score score = new Score(apple);
    private GoldenApple goldenApple = new GoldenApple(map);
    private Level level = new Level(snake, map, apple, goldenApple, score);
    private Rules rules = new Rules(level);

    @Test
    public void shouldMoveInEveryDirection() {
        //Given
        snake.getPosition().setY(3);
        snake.getPosition().setX(3);

        //when
        snake.setPosition(level.getSnake().getPosition().down());
        snake.setPosition(level.getSnake().getPosition().left());
        snake.setPosition(level.getSnake().getPosition().down());
        snake.setPosition(level.getSnake().getPosition().right());
        snake.setPosition(level.getSnake().getPosition().up());

        //then
        assertEquals(true, snake.getPosition().getY() == 4 && snake.getPosition().getX() == 3);

    }

    @Test
    public void shouldFoodBeEaten() {
        //Given
        snake.getPosition().setX(0);
        snake.getPosition().setY(1);

        apple.getPosition().setX(1);
        apple.getPosition().setY(1);


        //when
        snake.setPosition(level.getSnake().getPosition().right());
        rules.foodIsEaten();

        //then
        assertEquals(true, rules.isFoodEaten());
        assertEquals(1, snake.getTailPositions().size());


    }

    @Test
    public void shouldHitTheWall() {
        //Given
        snake.getPosition().setY(map.width() - 2);
        snake.getPosition().setX(map.height() - 2);

        //when
        snake.setPosition(snake.getPosition().right());
        snake.setPosition(snake.getPosition().down());
        rules.mapCollision();

        //then
        assertEquals(true, rules.isGameOver());

    }

    @Test
    public void shouldHitTheTail() {
        //Given
        snake.addTail(new Position(2, 4));
        snake.addTail(new Position(2, 3));
        snake.addTail(new Position(2, 2));
        snake.addTail(new Position(3, 2));
        snake.getPosition().setY(3);
        snake.getPosition().setX(3);

        //when
        snake.setPosition(level.getSnake().getPosition().left());
        rules.tailIsHit();

        //then
        assertEquals(true, rules.isGameOver());
    }


}
