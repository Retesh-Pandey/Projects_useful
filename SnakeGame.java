import java.util.*;

public class SnakeGame {
    static int width = 20;
    static int height = 10;
    static char[][] board = new char[height][width];
    static LinkedList<int[]> snake = new LinkedList<>();
    static int[] food = new int[2];
    static String direction = "RIGHT";
    static boolean gameOver = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize snake
        snake.add(new int[]{0, 0});
        placeFood();

        while (!gameOver) {
            printBoard();
            System.out.println("Move (W=Up, S=Down, A=Left, D=Right): ");
            char move = scanner.next().toUpperCase().charAt(0);

            if (move == 'W') direction = "UP";
            else if (move == 'S') direction = "DOWN";
            else if (move == 'A') direction = "LEFT";
            else if (move == 'D') direction = "RIGHT";

            moveSnake();
        }

        System.out.println("💀 Game Over! Final length: " + snake.size());
        scanner.close();
    }

    static void placeFood() {
        Random rand = new Random();
        food[0] = rand.nextInt(height);
        food[1] = rand.nextInt(width);
    }

    static void moveSnake() {
        int[] head = snake.getFirst();
        int newRow = head[0];
        int newCol = head[1];

        if (direction.equals("UP")) newRow--;
        else if (direction.equals("DOWN")) newRow++;
        else if (direction.equals("LEFT")) newCol--;
        else if (direction.equals("RIGHT")) newCol++;

        // Check collisions
        if (newRow < 0 || newRow >= height || newCol < 0 || newCol >= width) {
            gameOver = true;
            return;
        }
        for (int[] part : snake) {
            if (part[0] == newRow && part[1] == newCol) {
                gameOver = true;
                return;
            }
        }

        // Add new head
        snake.addFirst(new int[]{newRow, newCol});

        // Check if food eaten
        if (newRow == food[0] && newCol == food[1]) {
            placeFood(); // grow snake
        } else {
            snake.removeLast(); // move forward
        }
    }

    static void printBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boolean printed = false;
                for (int[] part : snake) {
                    if (part[0] == i && part[1] == j) {
                        System.out.print("O ");
                        printed = true;
                        break;
                    }
                }
                if (!printed) {
                    if (food[0] == i && food[1] == j) System.out.print("X ");
                    else System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}

