import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.*;
import javax.imageio.ImageIO;

public class Receive {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(13085);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        System.out.println("Reading: " + System.currentTimeMillis());

        byte[] sizeAr = new byte[4];
        inputStream.read(sizeAr);
        int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

        byte[] imageAr = new byte[size];
        inputStream.read(imageAr);

        BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));

        System.out.println("Received " + image.getHeight() + "x" + image.getWidth() + ": " + System.currentTimeMillis());
        ImageIO.write(image, "jpg", new File("/home/pict/Documents/31130_Nikita/SocketImageVideo/Image"));

        serverSocket.close();
    }

}

/*
public class Send {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("10.10.10.46", 13085);
        OutputStream outputStream = socket.getOutputStream();

        BufferedImage image = ImageIO.read(new File("/home/te/Downloads/image.jpg"));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", byteArrayOutputStream);

        byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
        outputStream.write(size);
        outputStream.write(byteArrayOutputStream.toByteArray());
        outputStream.flush();
        System.out.println("Flushed: " + System.currentTimeMillis());

        Thread.sleep(120000);
        System.out.println("Closing: " + System.currentTimeMillis());
        socket.close();
    }
}

*/
