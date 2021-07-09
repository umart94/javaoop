package com.umartariq;

public interface ITelephone {
    public void powerOn();
    public void dial(int phoneNumber);
    public void answer(DeskPhone obj);
    public boolean callPhone(int phoneNumber);
    public boolean isRinging();


}
