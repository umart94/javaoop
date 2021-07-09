package com.umartariq;

/**
 * Main.java created by umartariq on 10/08/2020
 * 2:46 PM inside the package - com.umartariq
 */

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class Main {

    public static void main(String[] args) {
        try (FileOutputStream binaryFile = new FileOutputStream("data.dat");
             FileChannel binaryChannel = binaryFile.getChannel()) {

            //allocated more
            /*
            The allocate() method of java.nio.ByteBuffer class is used to allocate a new byte buffer.

The new buffer’s position will be zero, its limit will be its capacity, its mark will be undefined, and each of its elements will be initialized to zero. It will have a backing array, and its array offset will be zero.

Syntax :

public static ByteBuffer allocate(int capacity)

Parameters: This method takes capacity, in bytes as parameter.

Return Value: This method returns the new byte buffer .
             */
            ByteBuffer buffer = ByteBuffer.allocate(1000);
            byte[] outputBytes = ("hey how are you i am writing a paragraph in java." +
                    "buffer capacity is the number of elements it can contain\n" +
                    "            buffer's position is the index of the next element that should be read or written\n" +
                    "            it cant be greater than buffer capacity\n" +
                    "            buffer mark is used by buffer.reset method\n" +
                    "            this method is called when buffer's position is reset to its mark\n" +
                    "            if we rewind buffer to certain point, we mark this point\n" +
                    "            and reset the position to this mark").getBytes();

                buffer.put(outputBytes);
                buffer.putInt(245);
                buffer.putInt(-98765);
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            buffer.putInt(1000);
            buffer.flip();//flip is called only once, after we have written everything to the buffer.

            binaryChannel.write(buffer);
//            //in previous code, we used same buffer for reading and writing
//            //now we use different buffers.
//
//            //ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
//            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
//            buffer.put(outputBytes);
//
//            //after each reading or writing we have to use flip method.
//            buffer.flip();
//
//            int numBytes = binaryChannel.write(buffer);
//            System.out.println(numBytes + " written");
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(4000);
//            intBuffer.flip();
//            numBytes = binaryChannel.write(intBuffer);
//            System.out.println(numBytes + " written");
//            intBuffer.flip();
//            intBuffer.putInt(-98765);
//            intBuffer.flip();
//            numBytes = binaryChannel.write(intBuffer);
//            System.out.println(numBytes + " written");
//            RandomAccessFile randomAccessFilereader = new RandomAccessFile("data.dat", "rwd");
//            FileChannel channel = randomAccessFilereader.getChannel();
//            outputBytes[0] = 'a';
//            outputBytes[1] = 'b';
//            buffer.flip();
//
//            long numBytesRead = channel.read(buffer);
//            if (buffer.hasArray()) {
//               System.out.println("byte buffer = " + new String(buffer.array()));
//               //System.out.println("byte buffer == "+ new String(outputBytes));
//            }
//
//            //Absolute Read
//            intBuffer.flip();
//            numBytes = channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0));
//            intBuffer.flip();
//            numBytes = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt(0));//Exception in thread "main" java.lang.IndexOutOfBoundsException
//            System.out.println(intBuffer.getInt());

            //we read the second integer from buffer twice
            //by doing an absolute and a relative read
            //channel.close();
            //randomAccessFilereader.close();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


