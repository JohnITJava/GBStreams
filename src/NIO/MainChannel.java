package NIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MainChannel {
    public static void main(String[] args) throws IOException {
        RandomAccessFile srcFile = new RandomAccessFile("hw1.txt", "rw");
        FileChannel srcChannel = srcFile.getChannel();

       // RandomAccessFile dstFile = new RandomAccessFile("hw3.txt", "rw");
        //FileChannel dstChannel = dstFile.getChannel();

        //long position = 0;
        //long count = srcChannel.size();

        //Перекачка файла из источника в назначение
        //dstChannel.transferFrom(srcChannel, position, count);
        //srcChannel.transferTo(position, count, dstChannel);

        ByteBuffer buf = ByteBuffer.allocate(48);
        //Записали в буффер
        int bytesRead = srcChannel.read(buf);

        //Чтение из буффера
        /*while (bytesRead != -1) {
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.print((char)buf.get());
            }
            buf.clear();
            bytesRead = srcChannel.read(buf);

        }*/

        ByteBuffer buf1 = ByteBuffer.allocate(4);
        buf1.put((byte)10);
        buf1.put((byte)20);
        buf1.flip();
        System.out.println(buf1.get());
        System.out.println(buf1.get());
        buf1.flip();
        buf1.put((byte)30);
        buf1.flip();
        System.out.println(buf1.get());
        System.out.println(buf1.get());

        srcChannel.close();
        //dstChannel.close();
        //dstFile.close();
        srcFile.close();

    }
}
