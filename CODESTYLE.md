# Code Style

## Naming conventions

* File names: PascalCase
* Folder names: PascalCase
* Class names: PascalCase
* Functions: camelCase
* Local variables: underscore_case
* Constants: SCREAMING_SNAKE_CASE

## Class Style

```Java
class Image {

    // Class vars
    int example_int, example_int2;
    boolean example_bool;

    public Image() {}
    
    /* DRAW */
    public void draw() {}
    
    /* SCALING */
    public void scale() {}
    public void scale(double factor) {}
    
    /* EXAMPLE GROUP */
    public void exampleFunc() {}
    public void exampleFunc2() {
        
        // Calculate something
        calculate();
        calculateAgain();
        
        // next group
        doSomething();
        again();
        
    }
    
    ...
    
}
```

* Public functions and members at top, protected in middle, private at bottom
* Class variables at top, then constructor then special functions, divided into groups.
* Often, code is divided by comments.

## Functions

* Function names should be descriptive of what they do and should be a verb ("doing word")
* Functions which return "bool" should be a question eg 

```Java
boolean isXGreaterThan5 (int x) {
    return x > 5;
}
```

## Enums
* Use enum class, not regular enums!
