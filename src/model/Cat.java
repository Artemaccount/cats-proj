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
        if (canDoIt()) {
            this.satiety--;
            System.out.print(this.getName() + ": *играет*" + "||" + "сытость: " + this.satiety);
            System.out.println();
            return true;
        }
        return false;
    }

    public boolean sleep() {
        if (canDoIt()) {
            this.satiety--;
            System.out.print(this.getName() + ": *спит*" + "||" + "сытость: " + this.satiety);
            System.out.println();
            return true;
        }
        return false;
    }

    public boolean chaseMouse() {
        if (canDoIt()) {
            this.satiety--;
            System.out.print(this.getName() + ": *ловит мышь*" + "||" + "сытость: " + this.satiety);
            System.out.println();
            return true;
        }
        return false;
    }

    public boolean goForAWalk() {
        if (canDoIt()) {
            this.satiety--;
            System.out.print(this.getName() + ": *гуляет*" + "||" + "сытость: " + this.satiety);
            System.out.println();
            return true;
        }
        return false;
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
        boolean isFull = true;
        for (int i = 1; i < 25; i++) {
            System.out.print(i + ")");
            if (isFull) {
                int choice = new Random().nextInt(4);
                switch (choice) {
                    case 0 -> isFull = play();
                    case 1 -> isFull = sleep();
                    case 2 -> isFull = chaseMouse();
                    case 3 -> isFull = goForAWalk();
                }
            } else if (!isFull) {
                isFull = eat();
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

    private boolean canDoIt() {
        if (this.satiety <= 0) {
            System.out.println(this.getName() + ": Я хочу есть!");
            return false;
        } else {
            return true;
        }
    }
}
