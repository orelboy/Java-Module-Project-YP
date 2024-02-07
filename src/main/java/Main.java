import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вас приветствует 'Калькулятор счета'\n" +
                "Эта приложение позволит вывести список товаров и сумму для каждого из друзей.\n" +
                "Контакты для связи с автором: https://t.me/orelboy / danil.ciplenkov@yandex.ru\n");

        AccountCalculator accountCalculator = new AccountCalculator();
        int peopleAmount = accountCalculator.setPeopleAmount();
        ArrayList<Product> products = accountCalculator.createList();
        accountCalculator.showList(peopleAmount, products);
    }
}