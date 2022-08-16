import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);
    private List<Board> boards = new ArrayList<>();
    int choice;
    List<Integer> CoordinatesAndShipType = new ArrayList<>();

    public List<Board> getBoards() {
        generateBoard();
        return boards;
    }

    public void generateBoard() {
        System.out.println("Upisi X duzinu");
        int x = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Upisi Y duzinu");
        int y = scanner.nextInt();
        Board board1 = new Board(x,y);
        Board board2 = new Board(x,y);
        boards.add(board1);
        boards.add(board2);
    }

    public Input() {

    }

    public int getIntegerMenuOption() {
        choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private List<Integer> AskCoordForShipAndType(){
        this.CoordinatesAndShipType = new ArrayList<>();
        System.out.println("Upisi X duzinu");
        int row = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Upisi Y duzinu");
        int col = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Odaberi vrstu broda: \n" + "1. NOSAC \n" + "2. KRSTARICA \n" + "3. BORBENI BROD \n" + "4. RAZARAC \n" + "5. PODMORNICA \n");
        int shipType = scanner.nextInt();
        CoordinatesAndShipType.add(row);
        CoordinatesAndShipType.add(col);
        CoordinatesAndShipType.add(shipType);
        return CoordinatesAndShipType;
    }

    public Ship createShip(int player) {
        int GamePlayer = player +1;
        Square shipPart;
        Ship ship;
        System.out.println("Igrac broj " + GamePlayer + " postavlja brod");
        CoordinatesAndShipType = AskCoordForShipAndType();
        int row = CoordinatesAndShipType.get(0);
        int col = CoordinatesAndShipType.get(1);
        int shipType = CoordinatesAndShipType.get(2);
        shipPart = new Square(row,col, SquareStatus.SHIP);
        ship = new Ship( new ArrayList<>(),ShipType.values()[shipType-1]);
        boards.get(player).buildShip(shipPart,ship);
        return ship;
    }

    public int[] shoot(int player){

        int GamePlayer = player +1;
        System.out.println("Igrac broj " + GamePlayer + " je na redu");
        System.out.println("Upisi Y");
        int row = scanner.nextInt();
        System.out.println("Upisi X");
        int col = scanner.nextInt();
        return new int[]{row,col};
    }
}
