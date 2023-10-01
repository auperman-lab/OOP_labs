package lab1;

public class Car {
    int speed = 0;
    String brand = "";
    boolean isMoving = false;
    public void brand(String brand){
        this.brand = brand;
    }
    public void stop() {
        this.isMoving = false;
        System.out.println("Car Stopped");
    }
    public void accelerate(int amount) {
        this.speed += amount;
        isMoving = speed != 0;
        godMode();
    }
    public void printSpeed() {
        System.out.println("Speed: " + this.speed);
    }
    public void printIsMoving() {
        if(isMoving) {
            System.out.println("The car is moving");
        } else {
            System.out.println("The car is not moving");
        }
    }

    public void checkSpeed(int limitSpeed){
        if (speed > limitSpeed){
            System.out.println("Calm the god damn car");
            while (limitSpeed <= speed){
                speed = speed-1;
                printSpeed();
            }
            System.out.println("Good boy");
        }else {
            System.out.println("Good boy");
        }
    }

    private void godMode(){
        if (speed >= 200){
            if(brand.equals("bmw")){
                System.out.println("chilling with the boys");
                System.out.println("get the girls now");
            }
            System.out.println("Hello God or Satan??");
        }else{
            System.out.println("not good not bad, still manage the trees someday they will avenge you for creating books");

        }

    }
    public void lightsOn(int time){
        if(8 < time && time<17 ){
            System.out.println("C is beter <3");
        }

    }
}