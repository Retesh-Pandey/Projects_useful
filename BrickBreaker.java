import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BrickBreaker extends Application {
    private double paddleX = 250;
    private double ballX = 300, ballY = 300;
    private double ballDX = 2, ballDY = -2;
    private final double PADDLE_WIDTH = 100, PADDLE_HEIGHT = 15;
    private final double BALL_RADIUS = 10;

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(600, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Scene scene = new Scene(new StackPane(canvas));
        stage.setScene(scene);
        stage.setTitle("Brick Breaker Game");
        stage.show();

        // Paddle movement
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT) paddleX -= 20;
            if (e.getCode() == KeyCode.RIGHT) paddleX += 20;
        });

        // Game loop
        new javafx.animation.AnimationTimer() {
            @Override
            public void handle(long now) {
                // Move ball
                ballX += ballDX;
                ballY += ballDY;

                // Bounce off walls
                if (ballX <= 0 || ballX >= canvas.getWidth() - BALL_RADIUS) ballDX *= -1;
                if (ballY <= 0) ballDY *= -1;

                // Bounce off paddle
                if (ballY + BALL_RADIUS >= canvas.getHeight() - PADDLE_HEIGHT &&
                    ballX + BALL_RADIUS >= paddleX &&
                    ballX <= paddleX + PADDLE_WIDTH) {
                    ballDY *= -1;
                }

                // Clear screen
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

                // Draw paddle
                gc.setFill(Color.BLUE);
                gc.fillRect(paddleX, canvas.getHeight() - PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT);

                // Draw ball
                gc.setFill(Color.RED);
                gc.fillOval(ballX, ballY, BALL_RADIUS, BALL_RADIUS);
            }
        }.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
