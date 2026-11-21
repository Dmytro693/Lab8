
public class GameCollection {

    private BoardGameSet[] games;

    // Ініціалізація масиву з 10 об'єктів
    public GameCollection() {
        games = new BoardGameSet[10];

        games[0] = new Chess("Шахи Classic", 1, 800, "дерев'яна");
        games[1] = new Monopoly("Монополія", 1, 1200, 6);
        games[2] = new Chess("Шахи Premium", 1, 2500, "магнітна");
        games[3] = new Monopoly("Монополія Junior", 1, 650, 4);
        games[4] = new Chess("Шахи Travel", 1, 500, "складна");
        games[5] = new Monopoly("Монополія Deluxe", 1, 1800, 6);
        games[6] = new Chess("Шахи Tournament", 1, 3200, "дерев'яна");
        games[7] = new Monopoly("Монополія City", 1, 950, 5);
        games[8] = new Chess("Шахи Mini", 1, 400, "пластикова");
        games[9] = new Monopoly("Монополія World", 1, 2200, 6);
    }

    // Виведення всього масиву
    public void showAll() {
        for (int i = 0; i < games.length; i++) {
            System.out.println("\nІндекс: " + i);
            games[i].showInfo();
        }
    }

    // Модифікація обраного елемента
    public boolean modifyGame(int index, String name,
                             int numberOfGames, double price) {

        if (index < 0 || index >= games.length) {
            return false;
        }

        if (name == null || name.trim().isEmpty()
                || numberOfGames <= 0 || price < 0) {
            return false;
        }

        games[index].setName(name);
        games[index].setNumberOfGames(numberOfGames);
        games[index].setPrice(price);

        return true;
    }

    // Виведення ігор, ціна яких більша за задану
    public void showGamesMoreExpensiveThan(double minPrice) {
        boolean found = false;

        for (BoardGameSet game : games) {
            if (game.getPrice() > minPrice) {
                game.showInfo();
                System.out.println("----------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Ігор за цією умовою не знайдено.");
        }
    }

    // Сортування за зростанням ціни
    public void sortAscending() {
        for (int i = 0; i < games.length - 1; i++) {
            for (int j = 0; j < games.length - 1 - i; j++) {
                if (games[j].getPrice() > games[j + 1].getPrice()) {
                    BoardGameSet temp = games[j];
                    games[j] = games[j + 1];
                    games[j + 1] = temp;
                }
            }
        }
    }

    // Сортування за спаданням ціни
    public void sortDescending() {
        for (int i = 0; i < games.length - 1; i++) {
            for (int j = 0; j < games.length - 1 - i; j++) {
                if (games[j].getPrice() < games[j + 1].getPrice()) {
                    BoardGameSet temp = games[j];
                    games[j] = games[j + 1];
                    games[j + 1] = temp;
                }
            }
        }
    }

    public int getSize() {
        return games.length;
    }
}
