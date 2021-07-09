package com.umartariq;

/**
 * Main.java created by umartariq on 26/08/2020
 * 1:54 PM inside the package - com.umartariq
 */

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;


public class Main {

    public static void main(String[] args) {

        try{
            Pipe pipe = Pipe.open();
            //we need two threads
            //one that will write to sink channel
            //one that will read from source channel

            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try{
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for(int i=0;i<10;i++){
                            String currentTime = " The time is : " + System.currentTimeMillis();
                            buffer.put(currentTime.getBytes());
                            buffer.flip();

                            while(buffer.hasRemaining()){
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    }catch(Exception e){

                    }
                }
            };

            Runnable reader = new Runnable() {
                @Override
                public void run() {
                        try{
                            Pipe.SourceChannel sourceChannel = pipe.source();
                            ByteBuffer buffer = ByteBuffer.allocate(56);
                            for(int i=0;i<10;i++){
                                int bytesRead = sourceChannel.read(buffer);
                                byte[] timeString = new byte[bytesRead];
                                buffer.flip();
                                buffer.get(timeString);
                                System.out.println("reader thread : "+new String(timeString));


                                buffer.flip();
                                Thread.sleep(100);
                            }

                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                }
            };

            new Thread(writer).start();
            new Thread(reader).start();
        }catch(IOException e){
            e.printStackTrace();
        }
//
//
//
//        try (FileOutputStream binaryFile = new FileOutputStream("data.dat");
//             FileChannel binaryChannel = binaryFile.getChannel()) {
//            ByteBuffer buffer = ByteBuffer.allocate(100);
//            byte[] outputBytes = "hello world".getBytes();
//            buffer.put(outputBytes);
//            long int1Pos = outputBytes.length;
//            buffer.putInt(245);
//            long int2Pos = int1Pos+ Integer.BYTES;
//            buffer.putInt(-98765);
//
//            byte[] outputBytes2 = "Nice to meet you".getBytes();
//            buffer.put(outputBytes2);
//            long int3Pos = int2Pos+ Integer.BYTES+outputBytes2.length;
//            buffer.putInt(1000);
//            buffer.flip();
//            binaryChannel.write(buffer);
//
//           //reading from int 3 to int 1 - reverse order.
//           RandomAccessFile randomfilereader = new RandomAccessFile("data.dat","rwd");
//            FileChannel channel = randomfilereader.getChannel();
//            ByteBuffer readBuffer = ByteBuffer.allocate(100);
//            channel.position(int3Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int3 = " + readBuffer.getInt());
//            readBuffer.flip();
//            channel.position(int2Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int2 = " + readBuffer.getInt());
//            readBuffer.flip();
//            channel.position(int1Pos);
//
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int1 = " + readBuffer.getInt());
//
//            //FileChannel to copy files and pipes with threads.
//            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat","rw");
//            FileChannel copyChannel = copyFile.getChannel();
//            //set channel.position
//            channel.position(0);
//           // long numTransferred = copyChannel.transferFrom(channel,0,channel.size());
//            long numTransferred = channel.transferTo(0,channel.size(),copyChannel);
//
//            System.out.println("Num transferred "+numTransferred);
//            channel.close();
//            randomfilereader.close();
//            copyChannel.close();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//

    }
}
