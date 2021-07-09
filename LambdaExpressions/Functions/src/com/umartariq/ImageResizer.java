package com.umartariq;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * ImageResizer.java created by umartariq on 29/10/2020
 * 3:26 PM inside the package - com.umartariq
 * in the java project Functions using IDE IntelliJ IDEA
 */
public class ImageResizer {

    public Image resizeImage(Image image,int width,int height){
        return image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
    }

    public Image resizeImage2(Image image,int width,int height){

        return image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
    }
}
