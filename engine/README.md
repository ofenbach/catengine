# Image.java
Useful functions:  
  draw()  
  scale()  
  scale(double)  
  scaleFullscreen()  
  setAngle(int)  
  setAlpha(int)  
  getAngleTo(image): int  
  collidesWith(image): boolean  

# Button.java
Same as Image.java but can register touch.  
  isPressed(): boolean  

# Music.java
Basic functions:  
  play()  
  pause()  
  stop()  
  delete()  

# Sound.java
Basic functions:  
  play()  
  stop()  
  delete()  
  
# Device.java
+ get_screen_width(): int  
+ get_screen_height(): int  
+ setSavingInt(String, int) <- for saving numbers onto the device  
+ setSavingBool(bool) <- for saving bool values onto the device  
+ getSavingInt(String): int <- get int value of file (filename: parameter string)  
+ getSavingBool(String): bool <-same with bool  
