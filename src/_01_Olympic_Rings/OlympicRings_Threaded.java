package _01_Olympic_Rings;

import java.awt.Color;
import java.util.ArrayList;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded extends Thread {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	Robot robot;
	
	public OlympicRings_Threaded(int position) {
		robot = new Robot(250 + 200 * position , 700);
		robot.setSpeed(100);
		robot.penDown();
		robot.setPenWidth(10);
		
		if(position == 0) {
			robot.setPenColor(Color.BLUE);
		} 
		else if(position == 1) {
			robot.setPenColor(Color.YELLOW);
		}
		else if(position == 2) {
			robot.setPenColor(Color.BLACK);
		}
		else if(position == 3) {
			robot.setPenColor(Color.GREEN);
		}
		else if(position == 4) {
			robot.setPenColor(Color.RED);
		}	
	}
	
	public static void main(String[] args) {	
		for(int position = 0; position < 5; position++) {
			new OlympicRings_Threaded(position).start();
		}
	}
	
	public void run() {
		
		robot.turn(270);
		
		for(int i=0; i < 360;i ++) {
			robot.turn(1);
			robot.move(4);
		}
	}

}

