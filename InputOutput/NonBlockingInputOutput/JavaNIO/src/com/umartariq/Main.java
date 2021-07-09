package com.umartariq;

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
	    /*in nio, data is processed one block at a time
	    channels , buffers and selectors are used
	    channel : is the data source we read from or write to e.g file or data source.
	    class that implements channel interface and can connect to data source

	    buffer is the container for block of data that we want to read or write
	    buffer can only hold one type of data

	    selector allows a single thread to manage io for multiple channels
	    when working with streams ( byte based or character based)
	    we need two instances of java.io class
	    1 instance for reading , 1 instance for writing

	    we need to use file reader and file writer.
	    reading and writing is always buffered.

	    jdk includes channels for files, network ,io , sockets etc.

	    we will use FileInputStream
        */

        try (FileOutputStream binaryFile = new FileOutputStream("data.dat");
             FileChannel binaryChannel = binaryFile.getChannel()) {
            // FileInputStream file = new FileInputStream("data.txt");
            // FileChannel channel = file.getChannel();
            //specify size of buffer, how many bytes will be read at a time
            //for files of same length
            // for files of varying lengths , we have to pass buffers for newLines.
            //by default utf-8 is assumed
            //append parameter, by default, otherwise we have parameters for overwriting, truncating etc.

//            Path dataPath = FileSystems.getDefault().getPath("data.txt");
//            Files.write(dataPath,"\nfourth line" .getBytes("UTF-8"), StandardOpenOption.APPEND);
//            Files.write(dataPath,"\nfifth line".getBytes("UTF-8"), StandardOpenOption.APPEND);
//
//            List<String> lines = Files.readAllLines(dataPath);
//            for(String line: lines){
//                System.out.println(line);
//            }


            //create byteBuffer
            /*

            buffer capacity is the number of elements it can contain
            buffer's position is the index of the next element that should be read or written
            it cant be greater than buffer capacity
            buffer mark is used by buffer.reset method
            this method is called when buffer's position is reset to its mark
            if we rewind buffer to certain point, we mark this point
            and reset the position to this mark

             */

            byte[] outputBytes = ("hey how are you i am writing a paragraph in java." +
                    "buffer capacity is the number of elements it can contain\n" +
                    "            buffer's position is the index of the next element that should be read or written\n" +
                    "            it cant be greater than buffer capacity\n" +
                    "            buffer mark is used by buffer.reset method\n" +
                    "            this method is called when buffer's position is reset to its mark\n" +
                    "            if we rewind buffer to certain point, we mark this point\n" +
                    "            and reset the position to this mark").getBytes();

            //create Byte Buffer
            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
            //wraps byte array in the buffer
            //modifications to buffer will change array
            //modification to array will change buffer.
            //wrap method wraps byte array in buffer.
            //modifications to buffer will change Output ByteArray will be changed.
            //when we call wrap , we are telling the runtime that we want to use the byte array
            //as the buffer, and since we used wrap buffer is already used.
            //sets position of buffer to 0
            //capacity set to bytearray length
            //mark will be undefined.
            int numBytes = binaryChannel.write(buffer);
            System.out.println(numBytes + " written");
            //since we used default utf8 character set, the file is in text.
            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            //get the ints and write to binary channel

            intBuffer.putInt(4000);
            intBuffer.flip();
            numBytes = binaryChannel.write(intBuffer);
            System.out.println(numBytes + " written");//0 as output
            intBuffer.flip();
            intBuffer.putInt(-98765);
            intBuffer.flip();
            /*
            Exception in thread "main" java.nio.BufferOverflowException
	at java.base/java.nio.Buffer.nextPutIndex(Buffer.java:717)
	at java.base/java.nio.HeapByteBuffer.putInt(HeapByteBuffer.java:468)
	at com.umartariq.Main.main(Main.java:105)

	after we wrote the last integer, buffer position was 4.
	but buffer is only 4 bytes long
	ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);

	here we allocate only 4 bytes (Integer) to the buffer
	position is 0 based
	4 is outside 0-3
	so exception.

	calling flip solves problem
	call flip twice.


	flip will set the limit of the buffer to the current position and reset the position to zero
	flip will set the limit of the buffer to the current position and reset the position to zero




One fairly common use case for the ByteBuffer is to construct some data structure piece-by-piece and then write that whole structure to disk. flip is used to flip the ByteBuffer from "reading from I/O" (putting) to "writing to I/O" (getting): after a sequence of puts is used to fill the ByteBuffer, flip will set the limit of the buffer to the current position and reset the position to zero. This has the effect of making a future get or write from the buffer write all of what was put into the buffer and no more.

After finishing the put, you might want to reuse the ByteBuffer to construct another data structure. To "unflip" it, call clear. This resets the limit to the capacity (making all of the buffer usable), and the position to 0.

So, a typical usage scenario:

ByteBuffer b = new ByteBuffer(1024);
for(int i=0; i<N; i++) {
    b.clear();
    b.put(header[i]);
    b.put(data[i]);
    b.flip();
    out.write(b);
}



             */

            //intBuffer.flip();
            numBytes = binaryChannel.write(intBuffer);
            System.out.println(numBytes + " written");//0 as output


            //using channels
            RandomAccessFile randomAccessFilereader = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = randomAccessFilereader.getChannel();
            outputBytes[0] = 'a';
            outputBytes[1] = 'b';
            //we are printing out value of outputBytes Buffer.
            //if we change its values, they are printed.
            //but we don't want buffer to be modified.

            //now we call flip
            buffer.flip();


            //the second way is to get the bytebuffer

            long numBytesRead = channel.read(buffer);
            if (buffer.hasArray()) {
                System.out.println("byte buffer = " + new String(buffer.array()));
            }
            //Flip
            //Read
            //Print

             //Relative read is when we dont pass in any parameters
//            intBuffer.flip();
//            numBytes = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());
//            intBuffer.flip();
//            numBytes = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());
//            channel.close();
//            randomAccessFilereader.close();


            //absolute read is when we pass in index in getInt method
            intBuffer.flip();
            numBytes = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            intBuffer.flip();
            numBytes = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));





            //System.out.println("output bytes == " +new String(outputBytes));
            //string will be in this buffer.
            //we need to access the bytearray now
            //we need to call flip method , but we test code without calling flip method
            /*

             */


            //without using channel
//            RandomAccessFile randomAccessFileReader = new RandomAccessFile("data.dat","rwd");
//            byte[] b = new byte[outputBytes.length];
//            randomAccessFileReader.read(b);
//            System.out.println(new String(b));
//
//            long int1 = randomAccessFileReader.readInt();
//            long int2 = randomAccessFileReader.readInt();
//            System.out.println("first integer written was "+int1);
//            System.out.println("second integer written was "+int2);


            //when we create buffer, position is set to 0
            //we wrote int into buffer, position changed
            //so now when read starts, it starts at buffers position ( current updated)
            //reset the position to 0 location in buffer and then it will read the number written.

            //developer has to write code to reset the position

            // flip the buffer.

            //close inputstream and filechannel


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
