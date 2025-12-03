package Exam;

public class Triangle {

	static int x;
	static int y;
	static int z;

	Triangle(int X, int Y, int Z){
		this.x = X;
		this.y = Y;
		this.z = Z;
	}

	String type() {
		if(this.x == this.y && this.x == this.z) {
			return "equilateral";
		} else if ((this.x == this.y && this.x != this.z) || (this.x == this.z && this.x != this.y) || (this.y == this.z && this.y != this.z)) {
			return "isosceles";
		} else {
			return "scalene";
		}
	}
	private static Triangle half(Triangle tri) {
		Triangle newTri = new Triangle(x,y,z);
		newTri.x = tri.x/2;
		newTri.y = tri.y/2;
		newTri.z = tri.z/2;
		return newTri;
	}
	
	int getSide() {
		return this.x;
	}
}

