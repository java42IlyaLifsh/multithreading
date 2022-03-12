package telran.games;
//IlyaL-46
import java.time.Instant;

import telran.games.dto.Race;

public class Runner extends Thread {
private Race race;
private int runnerId;
private Instant finishTime;
public int getRunnerId() {
	return runnerId;
}
public Runner(Race race, int runnerId) {
	this.race = race;
	this.runnerId = runnerId;
}
@Override
public void run() {
	int sleepRange = race.getMaxSleep() - race.getMinSleep() + 1;
	int minSleep = race.getMinSleep();
	int distance = race.getDistance();
	for (int i = 0; i < distance; i++) {
		try {
			sleep((long) (minSleep + Math.random() * sleepRange));
		} catch (InterruptedException e) {
			throw new IllegalStateException();
		}
		System.out.println(runnerId);
	}
	race.setAtomicWinner(runnerId);
	synchronized (race) {
		finishTime = Instant.now();
		finishRace();
	}
}
private void finishRace() {
//	race.setWinner(runnerId);
	race.setAtomicWinner(runnerId);
	race.getResultsTable().add(this);

}
public Instant getFinsishTime() {
	return finishTime;
}
}
