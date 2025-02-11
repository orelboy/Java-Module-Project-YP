public class Formatter {
    static String round (double number){
        return String.format("%.2f", number);
    }

    static String declination (double number){
        double numberFloor = Math.floor(number);

        if (numberFloor == 0 || numberFloor >= 5 && numberFloor <= 19 ||
                numberFloor % 10 == 0 || numberFloor % 10 >= 5 && numberFloor % 10 <= 9||
                numberFloor >=100 && numberFloor % 100 >= 11 && numberFloor % 100 <= 14){
            return "рублей";
        }  else if (numberFloor == 1 || numberFloor % 10 == 1) {
            return "рубль";
        }else{
            return "рубля";
        }
    }

    public String show (double number){
        return round(number) + " " + declination(number);
    }
}
