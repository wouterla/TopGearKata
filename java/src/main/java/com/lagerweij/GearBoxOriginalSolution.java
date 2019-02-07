package com.lagerweij;

import java.util.Map;

public class GearBoxOriginalSolution {

	private final static int LOWER_SHIFT_POINT = 500;
	private final static int UPPER_SHIFT_POINT = 2000;

	private Gear gear = new Gear(Gear.NEUTRAL);
	private Map<Integer, Gear> gears;
	private int rpm = 0;


	public GearBoxOriginalSolution(Map<Integer, Gear> gears) {
		this.gears = gears;
	}

	public void rpmChangeListener(int currentRpm) {
		this.rpm = currentRpm;
		changeGearIfNeeded();
	}

	private void changeGearIfNeeded() {
		GearChange direction = determineGearDirection();
		gear = gears.get(gear.gearIndex + direction.getValue());
	}

	private GearChange determineGearDirection() {
		return gear.determineGearChange(rpm);
	}

	public boolean needsToShiftUp() {
		return rpm > UPPER_SHIFT_POINT;
	}

	public boolean needsToShiftDown() {
		return rpm < LOWER_SHIFT_POINT;
	}

	public class Gear {
		private static final int NEVER = -1;

		private static final int NEUTRAL = 0;
		private static final int REVERSE = -1;
		private static final int TOP_GEAR = 6;

		private int gearIndex = NEUTRAL;
		private int downShiftRpm = NEVER;
		private int upShiftRpm = NEVER;

		public Gear(int gearIndex) {
			this.gearIndex = gearIndex;
		}

		public Gear(int gearIndex, int downShiftRpm, int upShiftRpm) {
			this.gearIndex = gearIndex;
			this.downShiftRpm = downShiftRpm;
			this.upShiftRpm = upShiftRpm;
		}

		public GearChange determineGearChange(int currentRpm) {
			GearChange change = GearChange.NO_CHANGE;
			if (needsDownShift(currentRpm)) {
				change = GearChange.DOWN;
			} else if (needsUpShift(currentRpm)) {
				change = GearChange.UP;
			}
			return change;
		}

		public boolean needsUpShift(int currentRpm) {
			return (upShiftRpm != NEVER) && (currentRpm > upShiftRpm);
		}

		public boolean needsDownShift(int currentRpm) {
			return (downShiftRpm != NEVER) && (currentRpm < downShiftRpm);
		}
	}

	public enum GearChange {

		UP (1),
		DOWN (-1),
		NO_CHANGE (0);

		private final int value;
		GearChange(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}
}
