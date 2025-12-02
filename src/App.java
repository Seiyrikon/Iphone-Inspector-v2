import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import components.frame.MainFrame;

public class App {
    public static void main(String[] args) throws Exception {
        new MainFrame();
        
        //Barcode Generator
        // String data = "1234567890";
        // String filePath = "barcode.png";

        // try {
        //     BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.CODE_128, 400, 150);

        //     Path path = FileSystems.getDefault().getPath(filePath);

        //     MatrixToImageWriter.writeToPath(matrix, "PNG", path);
        //     System.out.println("Barcode Generated: " + filePath);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        //QR Code Generator
        // String text = "Hello Bossing!";
        // String filePath = "qrcode.png";

        // int width = 300;
        // int height = 300;

        // QRCodeWriter qrCodeWriter = new QRCodeWriter();

        // Map<EncodeHintType, Object> hints = new HashMap<>();
        // hints.put(EncodeHintType.MARGIN, 1);

        // try {
        //     BitMatrix matrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);

        //     Path path = FileSystems.getDefault().getPath(filePath);
        //     MatrixToImageWriter.writeToPath(matrix, "PNG", path);

        //     System.out.println("QR Code Generated: " + filePath);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }
}
