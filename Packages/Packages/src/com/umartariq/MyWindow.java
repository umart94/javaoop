package com.umartariq;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindow extends Frame {
    public MyWindow(String title) throws HeadlessException {
        super(title);
        setSize(500,140);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //super.windowClosing(e);
                System.exit(0);
            }
        });
    }
            @Override
            public void paint(Graphics g){
                super.paint(g);
                Font sansSerifLarge = new Font("SansSerif",Font.BOLD,18);
                Font sansSerifSmall = new Font("SansSerif",Font.BOLD,12);
                g.setFont(sansSerifLarge);
                g.drawString("Java Programming Language",60,60);
                g.setFont(sansSerifSmall);
                g.drawString("Android Operating System",60,100);
        }



}