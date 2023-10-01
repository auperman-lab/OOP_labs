package lab1;

public class Main {

    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.brand("bmw");

        myCar.printIsMoving();

        myCar.speed = 20;
        myCar.printSpeed();
        myCar.isMoving = true;
        myCar.printIsMoving();


        myCar.checkSpeed(40);


        myCar.accelerate(30);
        myCar.printSpeed();
        myCar.checkSpeed(40);
        myCar.printIsMoving();


        myCar.stop();
        myCar.printIsMoving();
        myCar.lightsOn(15);
    }
}
