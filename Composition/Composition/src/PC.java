public class PC {
    private Case theCase;
    private Monitor theMonitor;
    private Motherboard motherboard;



    public PC(Case theCase, Monitor theMonitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.theMonitor = theMonitor;
        this.motherboard = motherboard;
    }

    public void powerUp(){
        theCase.pressPowerButton();
        drawLogo();
        loadprogramms();
    }

    private void drawLogo(){
        theMonitor.drawPixelAt(1600,1200,"blue");
    }
    private void loadprogramms(){
        motherboard.loadProgram("windows");
        motherboard.loadProgram("uTorrent");
    }


}
