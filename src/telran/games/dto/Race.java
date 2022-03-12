package telran.games.dto;
//IlyaL-46

import java.time.Instant;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import telran.games.Runner;

public class Race {
	private int distance;
	private int minSleep;
	private int maxSleep;
	private final int WIN_INITIAL=-1;
	private int winner = WIN_INITIAL;
	private AtomicInteger atomicWinner= new AtomicInteger(WIN_INITIAL);
	private List<Runner> resultsTable;
	private Instant startTime;
	
	public List<Runner> getResultsTable() {
		return resultsTable;
	}
	public Instant getStartTime() {
		return startTime;
	}
	public Race(int distance, int minSleep, int maxSleep, List<Runner> resultsTable, Instant startTime) {
		this.distance = distance;
		this.minSleep = minSleep;
		this.maxSleep = maxSleep;
		this.resultsTable = resultsTable;
		this.startTime = startTime;
	}
	public int getWinner() {
		return winner;
	}
	
	public int getAtomicWinner() {
		return atomicWinner.get();
	}
	
	public void setAtomicWinner(int winnerID) {
		atomicWinner.compareAndSet(WIN_INITIAL, winnerID);
	}
	
	
	public void setWinner(int winner) {
		if (this.winner == -1) {
			this.winner = winner;
		}
	}
	public int getDistance() {
		return distance;
	}
	public int getMinSleep() {
		return minSleep;
	}
	public int getMaxSleep() {
		return maxSleep;
	}
	
}
