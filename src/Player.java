import java.util.List;

public class Player {

    private List<Ship> ships;
    private Board board;
    private int remainingShips = 0;

    public Player(List<Ship> ships, Board board) {
        this.ships = ships;
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public int numberOfSquaruesOfShips(List<Ship> ships) {
        int sumOfAllSquares = 0;
        for(Ship ship : ships) {
            sumOfAllSquares+= ship.getShipType().label;
        }
        return sumOfAllSquares;
    }

    public boolean handleShot(int x, int y){

        for(Ship ship: ships) {
            for(Square square: ship.getFields()) {
                if(square.getY() == y && square.getX() == x && square.getSquareStatus().equals(SquareStatus.SHIP)) {
                    square.setSquareStatus(SquareStatus.HIT);
                    board.getSquare(x,y).setSquareStatus(SquareStatus.HIT);
                    return true;
                } else if(square.getY() == y && square.getX() == x && square.getSquareStatus().equals(SquareStatus.HIT)) {
                    square.setSquareStatus(SquareStatus.HIT);
                    board.getSquare(x,y).setSquareStatus(SquareStatus.HIT);
                    System.out.printf("Already hit");
                    return false;

                }
            }
        }
        board.getSquare(x, y).setSquareStatus(SquareStatus.MISSED);
        System.out.printf("Miss!");
        return false;
     }

}
