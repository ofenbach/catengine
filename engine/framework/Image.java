package ofenbach.exampleapp.framework;	// change this to your package name

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Paint;

import ofenbach.exampleapp.main.MainView;	// change this to your package name
import ofenbach.exampleapp.main.Settings;	// change this to your package name

/* able to display .png pictures*/
/* @creation:   February 2014   */
/* @update:     25.4.2018       */
/* @author:     Tim B. Ofenbach */

public class Image {

	// Bitmap & Path
	Bitmap bitmap;
	int path;
	
	// Position & Angle
	public double x = 0;
	public double y = 0;
	int angle;
	
	// Matrix & Paint
	Matrix m;
	Paint p;

	
	/* CONSTRUCTOR */
	public Image(int path) {
		
		// Parameter
		this.path = path;
		
		// Erzeugung
		m = new Matrix();
		p = new Paint();
		
		// Bitmap Creation
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inScaled = false;
		bitmap = BitmapFactory.decodeResource(Settings.context.getResources(), path, options);
		
	}
	
	
	/* DRAW */
	public void draw() {
		
    	// Anglesettings
    	m.reset();
    	m.postRotate(angle, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
    	m.postTranslate((float) x, (float) y);
    	
	    // Draw
		MainView.global_canvas.drawBitmap(bitmap, m, p);
	    
	}
	
	
	/* SCALING */
	public void scale(double factor) {
		
		// Calculation
		double relativewidth = 1080 / (factor * bitmap.getWidth());
		double ratio = (double) bitmap.getHeight() / (double) bitmap.getWidth();
		double width = Settings.getScreenWidth() / relativewidth;
		double height = ratio * width;
		
		// Scaling
		bitmap = Bitmap.createScaledBitmap(bitmap, (int) width, (int) height, false);
		
	}
	public void scaleFullscreen() {
		bitmap = Bitmap.createScaledBitmap(bitmap, Settings.getScreenWidth(), Settings.getScreenHeight(), false);
	}
	public void scale() {
		
		/* SCALING FOR SCRATCH */
		
		// Calculation
		double ratio = (double) bitmap.getHeight() / (double) bitmap.getWidth();
		double realwidth = Settings.getScreenWidth() * ((double) bitmap.getWidth()*2 / 480);
		double realheight = realwidth * ratio;;
		
		// Scaling
		bitmap = Bitmap.createScaledBitmap(bitmap, (int) realwidth, (int) realheight, false);
		
	}

	public void scaleHalf() {
		// fuer bilder die doppelt so gross sind (halbe pixel)
		double ratio = (double) bitmap.getHeight() / (double) bitmap.getWidth();
		double realwidth = Settings.getScreenWidth() * ((double) bitmap.getWidth() / 480);
		double realheight = realwidth * ratio;;

		// Scaling
		bitmap = Bitmap.createScaledBitmap(bitmap, (int) realwidth, (int) realheight, false);
	}
	
	
	/* SET FUNCTIONS */
	public void setAlpha(int alpha) {
		p.setAlpha(alpha);
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
		this.x = Settings.getScreenWidth() / 2 - this.getWidth() / 2;
	}
	public void setY(double yPos) {
		this.y = yPos;
	}
	public void setYtoMiddle() {
		this.y = Settings.getScreenHeight() / 2 - this.getHeight() / 2;
	}
	public void setRotation(double angle) {
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
	public int getAlpha() {
		return p.getAlpha();
	}
	public Bitmap getBitMap() {
		return bitmap;
	}
	
	
	/* COLLISION */
	public boolean collidesWith(Image image) {
		
		// See CollisionDetection.java
		return CollisionDetection.isCollisionDetected(bitmap, (int) x, (int) y, image.bitmap, (int) image.x, (int) image.y);
		
	}
	
	
	/* ON SCREEN? */
	public boolean isInScreen() {
		if (this.x > -this.getWidth() && this.x < Settings.getScreenWidth()) {
			if (this.y > -this.getHeight() && this.y < Settings.getScreenHeight()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// Extra Stuff
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
	
	
	/* DELETE */
	public void delete() {
		bitmap.recycle();
	}


}
