 //declare bacteria variables here
Bacteria [] platoon;
 void setup()   
 {     
 	size(500,500);
 	platoon = new Bacteria[10];
 	for(int i = 0; i < platoon.length; i++) {

 		int a = 1;
 		int b = 1;

 		a += 1;
 		if (a == 5) {
 			a = 1;
 			b += 1;
 		}

 		int x = (a*50);
 		int y = (b*50);
 		platoon[i] = new Bacteria(x, y, 5);
 	}
 	//initialize bacteria variables here   
 }   
 void draw()   
 {    
 	fill(255,255,255,30);
 	rect(0,0,500,500);
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

	int barrier = 500;

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
 	void move() {
 		if (bias == true) {

 		}
 		else {
 			if(startInterval == endInterval) {
 				resetDirection();
 			}
 			else {
	 			if (randomD == 0) {
	 				if(y > barrier) {
	 					resetDirection();
	 					y = barrier;
	 				}
	 				else {
	 					y += speed;
	 				}
	 			}
	 			else if (randomD == 1) {
	 				if(x > barrier){
	 					resetDirection();
	 					x = barrier;
	 				}
	 				else {
	 					x += speed;
	 				}
	 			}
	 			else if (randomD == 2) {
	 				if(y < 0) {
	 					resetDirection();
	 					y = 0;
	 				}
	 				else {
	 					y -= speed;
	 				}
	 			}
	 			else if (randomD == 3) {
	 				if(x < 0) {
	 					resetDirection();
	 					x = 0;
	 				}
	 				else {
	 					x -= speed;
	 				}
	 			}
	 			startInterval += 1;
 			}
 		}
 	}

 	void resetDirection() {
		startInterval = 0;
		randomD = (int)(Math.random()*4);
 	}

 	void show() {
 		fill(red,green,blue);
 		ellipse(x,y,size,size);
 		noFill();
 	}
 	//lots of java!   
 }    