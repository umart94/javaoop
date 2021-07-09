package com.umartariq;

public class DeskPhone implements ITelephone {
    private int myNumber;
    public boolean isRinging;


    public DeskPhone(int myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn() {
        System.out.println("POWER ONNNNNN");
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("ringgg"  + phoneNumber);
    }

    @Override
    public void answer(DeskPhone obj) {
        if(obj.isRinging && obj.getMyNumber() != this.myNumber){
            System.out.println("Philosphical Lyrics");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if(phoneNumber != myNumber)
        {
            isRinging = true;
            System.out.println("Phone utha code phat gaya hai");
        } else{
            isRinging = false;
            System.out.println("why are you calling yourself ?");
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }

    public int getMyNumber(){
        return this.myNumber;
    }
}
