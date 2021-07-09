package com.umartariq;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * DisplayImage.java created by umartariq on 29/10/2020
 * 3:43 PM inside the package - com.umartariq
 * in the java project Functions using IDE IntelliJ IDEA
 */
public class DisplayImage {

    public DisplayImage(ArrayList<Image> imageList) throws IOException
    {

        JFrame frame=new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        int count=0;
        DefaultListModel listModel = new DefaultListModel();


        for(int i = 0; i < imageList.size(); i++) {
            Image image= imageList.get(i);
            ImageIcon resizedImageIcon = new ImageIcon(image);
            listModel.add(count++,resizedImageIcon);

            /*
            The Java language has lots of abstract classes
            whenever we want to display them, the abstract class object will only show the data type

            what the error is, is that we want compatible classes and only those objects will show on the JFrame..

            so JFrame will show ImageIcons, inside the DefaultList Model..

            we can also use buffered images etc.
            or use toolkits to display the graphics versions..

            the problem is that , since image is an abstract class, we have to convert it into something else.

            also these variables will not show up in debugging.
            while when you convert them , then they will show in watch variables.

             */
        }
        JList lsm=new JList(listModel);
        lsm.setVisibleRowCount(1);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.add(new JScrollPane(lsm));

        frame.pack();
        frame.setVisible(true);
    }
}
