package com.umartariq;

/**
 * Main.java created by umartariq on 26/08/2020
 * 1:54 PM inside the package - com.umartariq
 */

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.RandomAccess;

public class Main {

    public static void main(String[] args) {
        try (FileOutputStream binaryFile = new FileOutputStream("data.dat");
             FileChannel binaryChannel = binaryFile.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(100);


//            byte[] outputBytes = "hello world".getBytes();
//            byte[] outputBytes2 = "Nice to meet you".getBytes();
//            buffer.put(outputBytes).putInt(245).putInt(-98765).put(outputBytes2).putInt(1000);
//            buffer.flip();
//            binaryChannel.write(buffer);

            /*
            position() - Returns this channel's position.
 	        position(long newPosition) - Sets this channel's position.
            read(ByteBuffer dst) - Reads a sequence of bytes from this channel into the given buffer.
            size() - Returns the current size of entity to which this channel is connected.
         	truncate(long size) - Truncates the entity, to which this channel is connected, to the given size.
            write(ByteBuffer src) - Writes a sequence of bytes to this channel from the given buffer.
             */




            byte[] outputBytes = "hello world".getBytes();
            buffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            buffer.putInt(245);
            long int2Pos = int1Pos+ Integer.BYTES;
            buffer.putInt(-98765);

            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            long int3Pos = int2Pos+ Integer.BYTES+outputBytes2.length;
            buffer.putInt(1000);
            buffer.flip(); // if we dont use flip method, buffer position will be set to after the previous call to
            // write method. and calling flip sets buffer to 0 position

            binaryChannel.write(buffer);

            RandomAccessFile randomfilereader = new RandomAccessFile("data.dat","rwd");
            FileChannel channel = randomfilereader.getChannel();
            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.read(readBuffer);
            readBuffer.flip();
            byte[] inputString = new byte[outputBytes.length];
            readBuffer.get(inputString);
            System.out.println("inputString = "+ new String(inputString));
            System.out.println("int1 = "+ readBuffer.getInt());
            System.out.println("int2 = "+ readBuffer.getInt());
            byte[] inputString2 = new byte[outputBytes2.length];
            readBuffer.get(inputString2);
            System.out.println("inputString2  " + new String(inputString2));
            System.out.println("int3 = " + readBuffer.getInt());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
