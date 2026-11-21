
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GameCollection collection = new GameCollection();

        boolean running = true;

        while (running) {
            System.out.println("\n===== НАБІР НАСТІЛЬНИХ ІГОР =====");
            System.out.println("1. Вивести всі ігри");
            System.out.println("2. Змінити елемент масиву");
            System.out.println("3. Показати ігри дорожчі за задану ціну");
            System.out.println("4. Сортувати за зростанням ціни");
            System.out.println("5. Сортувати за спаданням ціни");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        collection.showAll();
                        break;

                    case 2:
                        System.out.print("Введіть індекс елемента (0-9): ");
                        int index = Integer.parseInt(scanner.nextLine());

                        System.out.print("Нова назва: ");
                        String name = scanner.nextLine();

                        System.out.print("Кількість ігор: ");
                        int count = Integer.parseInt(scanner.nextLine());

                        System.out.print("Нова ціна: ");
                        double price = Double.parseDouble(scanner.nextLine());

                        if (collection.modifyGame(index, name, count, price)) {
                            System.out.println("Елемент успішно змінено.");
                        } else {
                            System.out.println("Помилка: некоректні дані або індекс.");
                        }
                        break;

                    case 3:
                        System.out.print("Введіть мінімальну ціну: ");
                        double minPrice = Double.parseDouble(scanner.nextLine());

                        collection.showGamesMoreExpensiveThan(minPrice);
                        break;

                    case 4:
                        collection.sortAscending();
                        System.out.println("Масив відсортовано за зростанням.");
                        collection.showAll();
                        break;

                    case 5:
                        collection.sortDescending();
                        System.out.println("Масив відсортовано за спаданням.");
                        collection.showAll();
                        break;

                    case 0:
                        running = false;
                        System.out.println("Програму завершено.");
                        break;

                    default:
                        System.out.println("Невірний пункт меню.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Помилка: введіть коректне числове значення.");
            }
        }

        scanner.close();
    }
}
