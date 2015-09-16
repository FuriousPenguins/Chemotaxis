import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

 //declare bacteria variables here   
 Bacteria [] platoon;
 public void setup()   
 {     
 	size(500,500);
 	platoon = new Bacteria[10];
 	for(int i = 1; i <= platoon.length; i++) {

 		int a = 1;
 		int b = 1;

 		a += 1;
 		if (a <= 5) {
 			a = 1;
 			b += 1;
 		}

 		int x = (a*50) + 25;
 		int y = (b*50) + 25;
 		platoon[i] = new Bacteria(x, y, 10);
 	}
 	//initialize bacteria variables here   
 }   
 public void draw()   
 {    
 	for (int i = 0; i < platoon.length; i++) {
 		platoon[i].move();
 		platoon[i].show();
 	}
 	//move and show the bacteria   
 }  
 class Bacteria    
 {
	int x;
	int y;
	int speed;

	int startInterval = 10;
	int endInterval = 10;

	int randomD;

	boolean bias = false;

	int size = (((int)(Math.random()*41))+10);
	int red = ((int)(Math.random()*256));
	int green = ((int)(Math.random()*256));
	int blue = ((int)(Math.random()*256));

 	Bacteria(int inputX, int inputY, int inputSpeed) {
 		x = inputX;
 		y = inputY;
 		speed = inputSpeed;
 	}
 	public void move() {
 		if (bias == true) {

 		}
 		else {
 			if(startInterval == endInterval) {
 				startInterval = 0;
 				randomD = (int)(Math.random()*4);
 			}
 			else {
	 			if (randomD == 0) {
	 				y += speed;
	 			}
	 			else if (randomD == 1) {
	 				x += speed;
	 			}
	 			else if (randomD == 2) {
	 				y -= speed;
	 			}
	 			else if (randomD == 3) {
	 				x -= speed;
	 			}
	 			startInterval += 1;
 			}
 		}
 	}

 	public void show() {
 		fill(red,green,blue);
 		ellipse(x,y,size,size);
 		noFill();
 	}
 	//lots of java!   
 }    
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
