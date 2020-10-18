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
        level.setSnakePosition(3, 3);

        //when
        level.setSnakePosition(level.getSnakeRightPosition());
        level.setSnakePosition(level.getSnakeLeftPosition());
        level.setSnakePosition(level.getSnakeDownPosition());
        level.setSnakePosition(level.getSnakeRightPosition());
        level.setSnakePosition(level.getSnakeUpperPosition());

        //then
        assertEquals(true, snake.getPositionX() == 4 && snake.getPositionY() == 3);

    }

    @Test
    public void shouldFoodBeEaten() {
        //Given
        level.setSnakePosition(0, 1);
        level.setApplePosition(1, 1);


        //when
        level.setSnakePosition(level.getSnakeRightPosition());
        rules.foodIsEaten();

        //then
        assertEquals(true, rules.isFoodEaten());
        assertEquals(1, level.getTailPositions().size());


    }

    @Test
    public void shouldHitTheWall() {
        //Given
        level.setSnakePosition(map.height() - 2, map.width() - 2);

        //when
        level.setSnakePosition(snake.positionRight());
        level.setSnakePosition(snake.positionDown());
        rules.mapCollision();

        //then
        assertEquals(true, rules.isGameOver());

    }

    @Test
    public void shouldHitTheTail() {
        //Given
        level.addSnakeTail(new Position(2, 4));
        level.addSnakeTail(new Position(2, 3));
        level.addSnakeTail(new Position(2, 2));
        level.addSnakeTail(new Position(3, 2));
        level.setSnakePosition(3, 3);

        //when
        level.setSnakePosition(level.getSnakeLeftPosition());
        rules.tailIsHit();

        //then
        assertEquals(true, rules.isGameOver());
    }


    @Test
    public void isAppleSpawnedCorrectly() {
        //Given
        level.addSnakeTail(new Position(2, 2));

        //when
       level.setApplePosition(2, 2);

        //then
        assertEquals(true, rules.checkIfTailIsHit(level.getFoodCoordinateX(), level.getFoodCoordinateY()));
    }
}
