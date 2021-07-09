public class Main {

    public static void main(String[] args) {

        /*
        Dimensions dimensions = new Dimensions(20,20,5);
        Case theCase = new Case("220B","Dell","240",dimensions);
        Monitor theMonitor = new Monitor("27inch Beast","Acer",27,new Resolution(2540,1440));
        Motherboard theMotherboard = new Motherboard("BJ-200","aSUS",4,6,"V2.44");
        PC thePC = new PC(theCase,theMonitor,theMotherboard);
        thePC.powerUp();


        //thePC.getTheMonitor().drawPixelAt(1500,1200,"red");
        //thePC.getMotherboard().loadProgram("Windows 1.0");
        //thePC.getTheCase().pressPowerButton();

*/
        Wall wall1 = new Wall("West");
        Wall wall2 = new Wall("East");
        Wall wall3 = new Wall("South");
        Wall wall4 = new Wall("North");

        //press Ctrl-P for showing Constructor Parameter Info
        Ceiling ceiling = new Ceiling(12,55);
        Bed bed = new Bed("Modern",2,50,1,1);
        Lamp lamp = new Lamp(20.0,"manual",true,5);
        Bedroom myBedRoom = new Bedroom("Umar's Bedroom",wall1,wall2,wall3,wall4,ceiling,bed,lamp);

        myBedRoom.sleepTime();
        myBedRoom.wakeTime();
        myBedRoom.makeBed();
        myBedRoom.getLamp().turnOn();
    }
}
