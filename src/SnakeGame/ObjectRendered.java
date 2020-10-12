package SnakeGame;

import java.awt.*;
import java.io.IOException;

public interface ObjectRendered {
    void renderObject(Graphics graphics, Level level) throws IOException;
}
