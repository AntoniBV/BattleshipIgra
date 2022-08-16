public class Battleship {

    private Display display;
    private Game game = new Game();
    private Input input;

    public Battleship() {
        display = new Display();
    }

    public void start() {
        display.printMenu();
        mainMenu();
    }

    public void mainMenu(){
        int choice;
        boolean exit = false;
        input = new Input();

        while(!exit) {
            display.printMainMenuOptions();
            System.out.println("Unesite svoj odabir");
            System.out.println();
            choice = input.getIntegerMenuOption();
            switch (choice){
                case 0:
                    game.gameLogic();

                    break;

                case 1:
                    exitGame();
                    break;
            }
        }
    }
    public void exitGame() {
        System.exit(0);
    }
}
