package com.lagerweij;

public class GearBoxOriginal {

	private final static int LOWER_SHIFT_POINT = 500;
	private final static int UPPER_SHIFT_POINT = 2000;
	private static final int NEUTRAL = 0;
	private static final int REVERSE = -1;
	private static final int TOP_GEAR = 6;
	private static final int UP = 1;
	private static final int DOWN = -1;

	private int gear = NEUTRAL;
	private int rpm = 0;

	public void rpmChangeListener(int currentRpm) {
		this.rpm = currentRpm;
		changeGearIfNeeded();
	}

	private void changeGearIfNeeded() {
		int direction = determineGearDirection();
		switch (direction) {
		case UP:
			shiftUpIfPossible();
			break;
		case DOWN:
			shiftDownIfPossible();
			break;
		}
	}

	private void shiftDownIfPossible() {
		if (!inLowestGear()) {
			gear--;
		}
	}

	private void shiftUpIfPossible() {
		if (!inHighestGear()) {
			gear++;
		}
	}

	private boolean inLowestGear() {
		return gear == NEUTRAL + 1;
	}

	private boolean inHighestGear() {
		return gear == TOP_GEAR;
	}


	private int determineGearDirection() {
		int gearDelta = 0;
		if (needsToShiftDown()) {
			gearDelta = DOWN;
		} else if (needsToShiftUp()) {
			gearDelta = UP;
		}
		return gearDelta;
	}

	public boolean needsToShiftUp() {
		return rpm > UPPER_SHIFT_POINT;
	}

	public boolean needsToShiftDown() {
		return rpm < LOWER_SHIFT_POINT;
	}

}
