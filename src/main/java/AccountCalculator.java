import java.util.ArrayList;
import java.util.Scanner;
public class AccountCalculator {
    public int setPeopleAmount() {
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

    public ArrayList<Product> createList() {
        ArrayList<Product> products = new ArrayList<>();
        String nameProduct;
        double priceProduct;
        while (true) {
            nameProduct = addProductName();
            priceProduct = addProductPrice();
            Product product = new Product(nameProduct, priceProduct);
            products.add(product);
            System.out.println("Товар успешно добавлен в калькулятор");
            Formatter formatter = new Formatter();
            System.out.println("Текущая сумма товаров - " + formatter.show(sum(products)));
            System.out.println("Хотите добавить ещё один товар? да / завершить");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.next();
            if (command.equalsIgnoreCase("Завершить")) {
                break;
            }
        }
        return products;
    }

    private String addProductName () {
        String nameProduct;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите название товара");
            nameProduct = scanner.nextLine();
            if (nameProduct.isEmpty()) {
                showErrorMessage("null");
            } else {
                break;
            }
        }
        return nameProduct;
    }

    private Double addProductPrice (){
        double priceProduct;
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите стоимость товара");
            if (scanner.hasNextDouble()) {
                priceProduct = scanner.nextDouble();
                if(priceProduct>=0){
                    break;
                } else {
                    showErrorMessage(Double.toString(priceProduct));
                }
            } else {
                    showErrorMessage(scanner.nextLine());
            }
        }
        return priceProduct;
    }

    private double sum (ArrayList<Product> products){
        double sum = 0;
        for (Product product : products){
            sum += product.price;
        }
        return sum;
    }

    public void showList (int peopleAmount, ArrayList<Product> products){
        System.out.println("Добавленные товары:\n");
        Formatter formatter = new Formatter();
        for (Product product: products){
            System.out.println(product.name + "  " + formatter.show(product.price));
        }
        double amountPerPerson = sum(products)/peopleAmount;
        System.out.println("\nКаждый человек должен заплатить -> " + formatter.show(amountPerPerson));
    }

    private void showErrorMessage(String input) {
        System.out.println("Ошибка: '" + input + "' -  некорректное значение для подсчёта");
    }
}
