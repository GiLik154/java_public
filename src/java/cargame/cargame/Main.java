package cargame;

public class Main {

	public static void main(String[] args) {
		Input input = new Input();
		input.scan();

		int carCount = input.reciveCar();
		int moveCount = input.reciveCount();

		Car car = new Car();
		int[] carData = car.matchCar(carCount, moveCount);

		Print reslut = new Print();
		reslut.printScore(carCount, moveCount, carData);
	}
}