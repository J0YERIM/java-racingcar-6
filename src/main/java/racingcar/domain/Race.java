package racingcar.domain;

import java.util.List;
import racingcar.utils.RandomGenerator;
import racingcar.view.ResultView;

public class Race {

    private final List<Car> cars;
    private final int attemptCount;

    public Race(List<Car> cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public void startRace() {
        for (int i = 0; i < attemptCount; i++) {
            for (Car car : cars) {
                car.tryMove(RandomGenerator.generateRandomNumber());
            }
            ResultView.printRaceResult(cars);
        }
        ResultView.printWinners(findWinners());
    }

    public List<Car> findWinners() {
        return cars.stream()
                .filter(car -> car.getPosition() == findMaxPosition())
                .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
