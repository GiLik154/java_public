package cargame;

public class Main {

    public static void main(String[] args) {
        Input input = new Input();

        Car car = new Car();
        car.matchCar(input.carCountScan(), input.moveCountScan());

//        Print reslut = new Print();
//        reslut.printScore(input.carCountScan(), input.moveCountScan(), carScore);
    }
}