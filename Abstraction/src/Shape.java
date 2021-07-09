public abstract class Shape {

    private String name;

    public Shape(){

    }
    public Shape(String name){
        this.name = name;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString(){
        return name + "  " + getArea() + "  " + getPerimeter();
    }

}
