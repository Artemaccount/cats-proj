import model.Cat;

public class Application {
    public static void main(String[] args) {
        Cat john = new Cat(10, 4, 10, "John", "meow");
        Cat barsik = new Cat();
        barsik.setCat(10, 3, 8, "Барсик", "мяу");
        printNameAndWeight(barsik);
        barsik.liveAnotherDay();
        isMeowEquals(john.getMeow(), barsik.getMeow());
        System.out.println("Всего кисульков: " + Cat.getObjCount());
    }

    private static void printNameAndWeight(Cat cat) {
        System.out.println("Имя: " + cat.getName() + " / " + "Вес: " + cat.getWeight() + " кг");
    }

    private static void isMeowEquals(String meowFirst, String meowSecond) {
        if (meowFirst.equals(meowSecond)) {
            System.out.println("Кисульки мяукают одинаково");
        } else {
            System.out.println("Кисульки мяукают по-разному");
        }
    }
}
