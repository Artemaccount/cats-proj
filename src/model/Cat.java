package model;

import java.util.Random;

// Извините, но Kotik писать транслитом - рука не поднимается
public class Cat {

    private String meow;
    private int prettiness;
    private int weight;
    private String name;
    private static int objCount = 0;
    private int satiety;

    public String getMeow() {
        return meow;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public static int getObjCount() {
        return objCount;
    }

    public Cat(int prettiness, int satiety, int weight, String name, String meow) {
        this.prettiness = prettiness;
        this.satiety = satiety;
        this.weight = weight;
        this.name = name;
        this.meow = meow;
        objCount++;
    }

    public Cat() {
        objCount++;
    }

    public boolean play() {
        if (this.satiety <= 0) {
            System.out.println(this.getName() + ": Я хочу есть!");
            return false;
        }
        this.satiety--;
        System.out.print(this.getName() + ": *играет*" + "||" + "сытость: " + this.satiety);
        System.out.println();
        return true;
    }

    public boolean sleep() {
        if (this.satiety <= 0) {
            System.out.println(this.getName() + ": Я хочу есть!");
            return false;
        }
        this.satiety--;
        System.out.print(this.getName() + ": *спит*" + "||" + "сытость: " + this.satiety);
        System.out.println();
        return true;
    }

    public boolean chaseMouse() {
        if (this.satiety <= 0) {
            System.out.println(this.getName() + ": Я хочу есть!");
            return false;
        }
        this.satiety--;
        System.out.print(this.getName() + ": *ловит мышь*" + "||" + "сытость: " + this.satiety);
        System.out.println();
        return true;
    }

    public boolean goForAWalk() {
        if (this.satiety <= 0) {
            System.out.println(this.getName() + ": Я хочу есть!");
            return false;
        }
        this.satiety--;
        System.out.print(this.getName() + ": *гуляет*" + "||" + "сытость: " + this.satiety);
        System.out.println();
        return true;
    }

    public boolean eat() {
        return eat(2, "рыбку");
    }

    public boolean eat(int amount) {
        this.satiety = this.satiety + amount;
        System.out.print(this.getName() + ": *кушает*" + "||" + "сытость: " + this.satiety);
        System.out.println();
        return true;
    }

    public boolean eat(int amount, String food) {
        this.satiety = this.satiety + amount;
        System.out.print(this.getName() + ": *кушает " + food + "* ||" + "сытость: " + this.satiety);
        System.out.println();
        return true;
    }

    public void liveAnotherDay() {
        int choice;
        boolean goOn = true;
        for (int i = 0; i < 25; i++) {
            System.out.print(i + ")");
            if (goOn == true) {
                choice = randomInt();
                switch (choice) {
                    case 1:
                        goOn = play();
                        break;
                    case 2:
                        goOn = sleep();
                        break;
                    case 3:
                        goOn = chaseMouse();
                        break;
                    case 4:
                        goOn = goForAWalk();
                        break;
                }
            } else if (goOn == false) {
                goOn = eat();
            }
        }
    }

    public void setCat(int prettiness, int satiety, int weight, String name, String meow) {
        this.prettiness = prettiness;
        this.meow = meow;
        this.name = name;
        this.weight = weight;
        this.satiety = satiety;
    }

    private static int randomInt() {
        int min = 1;
        int max = 4;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        return i += min;
    }
}
