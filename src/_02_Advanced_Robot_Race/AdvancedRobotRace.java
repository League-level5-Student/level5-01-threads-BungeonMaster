package _02_Advanced_Robot_Race;

import java.util.ArrayList;
import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace extends Thread {
	
	static final int NUM_ROBOTS = 5;
	
	static boolean robotReachedTop = false;
	
	Robot robot;
	int position;
	
	
	AdvancedRobotRace(int position) {
		
		this.position = position;
		robot = new Robot();
		robot.setY(700);
		robot.setX(100 + position * 100);
		
	}
	
		public static void main(String[] args) {
			
			ArrayList<AdvancedRobotRace> race = new ArrayList<AdvancedRobotRace>();

			//3. use a for loop to initialize the robots.
			for (int i = 0; i < NUM_ROBOTS; i++) {
				race.add(new AdvancedRobotRace(i));
			}
			
			for(int i = 0;i < race.size();i++) {
				race.get(i).start();
			}
		}
		
		public void run() {
			while(!robotReachedTop) {
				robot.move(new Random().nextInt(50));
				
				if(robot.getY() <= 0) {
					if(!robotReachedTop) {
						robotReachedTop = true;	
						System.out.println("Robot " + position + " won!");
						robot.sparkle();
					}
					break;
				}
			}
		}
	}
