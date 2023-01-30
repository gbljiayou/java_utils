import com.google.zxing.WriterException;
import org.junit.Test;

import java.io.IOException;

public class QrCodeUtilTest {

    @Test
    public void generateQRCodeImage() {
        String qrcode = QrCodeUtil.generateQRCodeImage("generateQRCodeImage");
        System.out.println("qrcode = " + qrcode);
    }

    @Test
    public void testGenerateQRCodeImage() throws IOException, WriterException {
        String qrcode = QrCodeUtil.generateQRCodeImage("testGenerateQRCodeImage", 500, 600);
        System.out.println("qrcode = " + qrcode);
    }
}