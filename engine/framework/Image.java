package ofenbach.exampleapp.framework;	// change this to your package name

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Paint;

import ofenbach.exampleapp.main.Device;
import ofenbach.exampleapp.main.MainActivity;
import ofenbach.exampleapp.main.MainView;	// change this to your package name

/* able to display .png pictures*/
/* @creation:   February 2014   */
/* @update:     28.4.2018       */
/* @author:     Tim B. Ofenbach */

/* update news 28.4.2018:
	+ added auomatic positions
	+ added gravity support
	+ improved comments
 */

public class Image {

	// File
	Bitmap bitmap;
	int path;
	
	// position & angle
	public double x, y;
	int angle;
	
	// rotation & transparency
	Matrix m;
	Paint p;

	// Gravity
	public double gravity_factor, gravity_timer;

	
	/* CONSTRUCTOR */
	public Image(int path) {

		this.path = path;

		m = new Matrix();
		p = new Paint();
		
		// Bitmap Creation
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inScaled = false;
		bitmap = BitmapFactory.decodeResource(MainActivity.context.getResources(), path, options);
		
	}
	
	
	/* DRAW */
	public void draw() {
		
    		// Anglesettings
    		m.reset();
    		m.postRotate(angle, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
    		m.postTranslate((float) (x/1920)*Device.get_screen_width(), (float) (y/1080)*Device.get_screen_height());

    		// Gravity
		if (gravity_factor != 0) {
			this.applyGravity();
		}

	    	// Draw
		MainView.global_canvas.drawBitmap(bitmap, m, p);
	    
	}
	
	
	/* SCALING */
	public void scale() {
		
		// Calculation
		double ratio = (double) bitmap.getHeight() / (double) bitmap.getWidth();
		double real_width = Device.get_screen_width() * ((double) bitmap.getWidth() / 480);
		double real_height = real_width * ratio;;
		
		// Scaling
		bitmap = Bitmap.createScaledBitmap(bitmap, (int) real_width, (int) real_height, false);
		
	}
	public void scale(double factor) {
		
		// Calculation
		double relative_width = 1080 / (factor * bitmap.getWidth());
		double ratio = (double) bitmap.getHeight() / (double) bitmap.getWidth();
		double width = Device.get_screen_width() / relative_width;
		double height = ratio * width;
		
		// Scaling
		bitmap = Bitmap.createScaledBitmap(bitmap, (int) width, (int) height, false);
		
	}
	public void scaleFullscreen() {
		bitmap = Bitmap.createScaledBitmap(bitmap, Device.get_screen_width(), Device.get_screen_height(), false);
	}
	
	
	/* SET FUNCTIONS */
	public void setAlpha(int alpha) {
		p.setAlpha(alpha);
	}
	public void setTransparency(double percent) {
		int real_value = (int) percent * 255;
		p.setAlpha(real_value);
	}
	public void move(double distance) {

		// Calculation
		double distanceX = distance * Math.sin(angle);
		double distanceY = distance * Math.cos(angle);

		// Update X Y
		x += distanceX;
		y += distanceY;

	}
	public void goTo(int xPos, int yPos) {
		x = xPos;
		y = yPos;
	}
	public void setX(double xPos) {
		this.x = xPos;
	}
	public void setXtoMiddle() {
		//this.x = Device.get_screen_width() / 2 - this.getWidth() / 2;		// old way
		x = 1920 / 2 - getWidth() / 2;
	}
	public void setY(double yPos) {
		this.y = yPos;
	}
	public void setYtoMiddle() {
		//this.y = Device.get_screen_height() / 2 - this.getHeight() / 2;	// old way: relative but still absolut
		y = 1080 / 2 - getHeight() / 2;	// new way: relative/automatic
	}
	public void setAngle(double angle) {
		this.angle = (int) angle;
		m.reset();
		m.postRotate((int) angle, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
		m.postTranslate((int) x, (int) y);
	}
	
	
	/* GET FUNCTIONS */
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public int getWidth() {
		return bitmap.getWidth();
	}
	public int getHeight() {
		return bitmap.getHeight();
	}
	public int getAngle() {
		return angle;
	}
	public double getAngleTo(Image image) {

		// Vars
		double delta_x;
		double delta_y;
		double hypo;				// Pythagoras
		double angle = 0;

		// ∆-X
		if (image.x > this.x) {
			delta_x = image.x - this.x;
		} else {
			delta_x = this.x - image.x;
		}

		// ∆Y
		// Wenn Image unter diesem Image
		if (image.y > this.y) {
			delta_y = image.y - this.y;
		} else {	// Wenn  Image ueber diesem Image
			delta_y = this.y - image.y;
		}

		// Satz des Pythagoras a^2 + b^2 = c^2
		// <=> sin(alpha) = Gegenkathete (∆x) / Hypothenuse (Wurzel aus (∆x^2 + ∆y^2))
		// <=> alpha = arcsin(∆x / (sqrt(∆x^2+∆y^2)
		hypo = Math.sqrt(delta_x*delta_x + delta_y*delta_y);
		angle = Math.asin( delta_y / hypo );	// alpha = arcsin(gegenkathete / hypo)
		angle = Math.toDegrees(angle);

		// Umkehrung des Winkels wenn Image "tiefer" als dieses Image ist
		if (image.y > this.y) {
			angle = -angle;
		}

		return angle;
	}
	public int getAlpha() {
		return p.getAlpha();
	}
	public Bitmap getBitmap() {
		return bitmap;
	}
	public boolean isInScreen() {
		if (this.x > -this.getWidth() && this.x < Device.get_screen_width()) {
			if (this.y > -this.getHeight() && this.y < Device.get_screen_height()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	
	/* COLLISION */
	public boolean collidesWith(Image image) {
		// See CollisionDetection.java
		return CollisionDetection.isCollisionDetected(bitmap, (int) x, (int) y, image.bitmap, (int) image.x, (int) image.y);
	
	}


	/* GRAVITY */
	public void setGravity(double factor) {	// e.g. factor=9.81, factor = 0 -> false, factor != 0 -> true
		this.gravity_factor = factor;
	}
	public void applyGravity() {			// updates gravity movement (put this in your repeat())
		this.y += gravity_timer* gravity_factor;
		this.gravity_timer += 0.016*4;
	}
	public void increaseGravity(int increase) {
		this.gravity_timer += increase;
	}
	public void setGravityTimer(int value) {
		this.gravity_timer = value;
	}

	
	/* DELETE */
	public void delete() {
		bitmap.recycle();
	}


}
