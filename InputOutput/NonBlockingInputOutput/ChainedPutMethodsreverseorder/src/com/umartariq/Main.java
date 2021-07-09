package com.umartariq;

/**
 * Main.java created by umartariq on 26/08/2020
 * 1:54 PM inside the package - com.umartariq
 */

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class Main {

    public static void main(String[] args) {
        try (FileOutputStream binaryFile = new FileOutputStream("data.dat");
             FileChannel binaryChannel = binaryFile.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(100);
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
            buffer.flip();
            binaryChannel.write(buffer);

           /*
         //  reading from int 1 to int 3
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
            System.out.println("int3 = " + readBuffer.getInt());*/


           //reading from int 3 to int 1 - reverse order.
           RandomAccessFile randomfilereader = new RandomAccessFile("data.dat","rwd");
            FileChannel channel = randomfilereader.getChannel();
            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.position(int3Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int3 = " + readBuffer.getInt());
            readBuffer.flip();
            channel.position(int2Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int2 = " + readBuffer.getInt());
            readBuffer.flip();
            channel.position(int1Pos);

            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int1 = " + readBuffer.getInt());

            //FileChannel to copy files and pipes with threads.
            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat","rw");
            FileChannel copyChannel = copyFile.getChannel();
            //set channel.position
            channel.position(0);
           // long numTransferred = copyChannel.transferFrom(channel,0,channel.size());
            long numTransferred = channel.transferTo(0,channel.size(),copyChannel);

            System.out.println("Num transferred "+numTransferred);
            channel.close();
            randomfilereader.close();
            copyChannel.close();







//
//            byte[] outputString = "Hello, World!".getBytes();
//            long str1Pos=0;
//            long newint1Pos=outputString.length;
//            long newint2Pos=newint1Pos + Integer.BYTES;
//            byte[] outputString2 = "Nice to meet you".getBytes();
//            long str2Pos = newint2Pos + Integer.BYTES;
//            long newint3pos = str2Pos + outputString2.length;
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(100);
//            intBuffer.putInt(245);
//            intBuffer.flip();
//            binaryChannel.position(newint1Pos);
//            binaryChannel.write(intBuffer);
//            intBuffer.flip();
//            intBuffer.putInt(-98765);
//            intBuffer.flip();
//            binaryChannel.position(newint2Pos);
//            binaryChannel.write(intBuffer);
//            intBuffer.flip();
//            intBuffer.putInt(1000);
//            intBuffer.flip();
//            binaryChannel.position(newint3pos);
//            binaryChannel.write(intBuffer);
//            binaryChannel.position(str1Pos);
//            binaryChannel.write(ByteBuffer.wrap(outputString));
//            binaryChannel.position(str2Pos);
//            binaryChannel.write(ByteBuffer.wrap(outputString2));


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
