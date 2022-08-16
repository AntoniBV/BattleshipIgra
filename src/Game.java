import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Ship> shipsPlayer1 = new ArrayList<>();
    private List<Ship> shipsPlayer2 = new ArrayList<>();
    List<Board> boards;

    public void gameLogic() {
        Input board1 = new Input();
        boards = board1.getBoards();
        Board boardPlayer1 = boards.get(0);
        Board boardPlayer2 = boards.get(1);
        for (int i = 0; i < 2; i++) {
            Ship one = board1.createShip(0);
            while (one.isPlacementOk(one, shipsPlayer1, boardPlayer1) == false) {
                one = board1.createShip(0);
            }
            shipsPlayer1.add(one);
        }
        for (int i = 0; i < 2; i++) {
            Ship one = board1.createShip(1);
            while (one.isPlacementOk(one, shipsPlayer2, boardPlayer1) == false) {
                one = board1.createShip(1);
            }
            shipsPlayer2.add(one);
        }
        Player player1 = new Player(shipsPlayer1, boardPlayer2);
        Player player2 = new Player(shipsPlayer1, boardPlayer2);
        boolean gameOn = true;
        Display display = new Display();
        System.out.println("Ploca igraca broj 1");
        display.printBoard(boardPlayer1);
        System.out.println("-----------------------------------------");
        System.out.println("Ploca igraca broj 2");
        display.printBoard(boardPlayer2);
        int numberOfShipsPlayer1 = player1.numberOfSquaruesOfShips(shipsPlayer1);
        int numberOfShipsPlayer2 = player1.numberOfSquaruesOfShips(shipsPlayer2);
        while (gameOn) {
            int[] ShootCoordinates;
            ShootCoordinates = board1.shoot(0);
            if (player2.handleShot(ShootCoordinates[0], ShootCoordinates[1])) {
                display.printBoard((player2.getBoard()));
                numberOfShipsPlayer2--;
            } else {
                display.printBoard(player2.getBoard());
            }
            if (numberOfShipsPlayer2 == 0) {
                display.printBoard(player2.getBoard());
                System.out.println("Igrac broj 1 je pobjedio!");
                break;
            }
            ShootCoordinates = board1.shoot(1);
            if (player1.handleShot(ShootCoordinates[0], ShootCoordinates[1])) {
                display.printBoard((player1.getBoard()));
                numberOfShipsPlayer1--;
            } else {
                display.printBoard(player1.getBoard());
            }

            if (numberOfShipsPlayer1 == 0) {
                display.printBoard(player1.getBoard());
                System.out.println("Igrac broj 2 je pobjedio!");
                break;
            }
        }
    }
}