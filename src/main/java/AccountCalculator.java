import java.util.ArrayList;
import java.util.Scanner;
public class AccountCalculator {

    public int start() {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("На скольких человек необходимо разделить счёт?");

            if(scanner.hasNextInt()) {
                int peopleAmount = scanner.nextInt();
                if (peopleAmount <= 1){
                    showErrorMessage(Integer.toString(peopleAmount));
                } else {
                    return peopleAmount;
                }
            } else {
                showErrorMessage(scanner.nextLine());
            }
        }
    }

    public ArrayList<Product> dataImput () {
        ArrayList<Product> products = new ArrayList<>();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите название товара");
            String nameProduct = scanner.nextLine();

            while (true){
                System.out.println("Введите стоимость товара");
                if (scanner.hasNextDouble()) {
                    double priceProduct = scanner.nextDouble();
                    Product product = new Product(nameProduct, priceProduct);
                    products.add(product);
                    System.out.println("Товар успешно добавлен в калькулятор");
                    System.out.println("Текущая сумма товаров - " + sum(products));//считать текущую общую сумму всех товаров
                    break;
                } else {
                    showErrorMessage(scanner.nextLine());
                }
            }

            System.out.println("Хотите добавить ещё один товар? да / завершить");
            String command = scanner.next();
              if (command.equalsIgnoreCase("Завершить")) {
                  break;
              }
        }
        return products;
    }
    // считать текущую общую сумму всех товаров
    private double sum (ArrayList<Product> products){
        double sum = 0;
        for (Product product : products){
            sum += product.price;
        }
        return sum;
    }

    // метод вывода списка товаров
    public void showList (int peopleAmount, ArrayList<Product> products){
        System.out.println("Добавленные товары:\n");
        for (Product product: products){
            System.out.println(product.name + "  " + product.price);
        }
        double amountPerPerson = sum(products)/peopleAmount;
        Formatter formatter = new Formatter();
        System.out.println("Каждый человек должен заплатить -> " + formatter.show(amountPerPerson));
    }

    private void showErrorMessage(String input) {

        System.out.println("Ошибка: '" + input + "' -  некорректное значение для подсчёта");
    }
}
