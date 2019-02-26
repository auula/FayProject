package club.applo.fay.utils;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.google.zxing.client.j2se.MatrixToImageConfig.BLACK;
import static com.google.zxing.client.j2se.MatrixToImageConfig.WHITE;

/**
 * @author ligen
 * @create 2018-01-09 下午9:02
 */
@Slf4j
public class QRCodeUtil {
    /**
     * 默认二维码宽度
     */
    private static final int width = 280;
    /**
     * 默认二维码高度
     */
    private static final int height = 280;
    /**
     * 默认二维码文件格式
     */
    private static final String format = "png";
    /**
     * 二维码参数
     */
    private static final Map<EncodeHintType, Object> hints = new HashMap();

    static {
        // 字符编码
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        // 容错等级 L、M、Q、H 其中 L 为最低, H 为最高
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        // 二维码与图片边距
        hints.put(EncodeHintType.MARGIN, 1);
    }

    public static void generateQRCode(String url, HttpServletResponse response) throws Exception {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(url), "连接地址为空");
        generateQRCode(url, response, height, width);
    }

    public static void generateQRCode(String url, HttpServletResponse response, int height, int width) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(url), "连接地址为空");

        try (OutputStream stream = response.getOutputStream()) {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, height, width, hints);
//            MatrixToImageWriter.writeToStream(bitMatrix, format, stream);
            BufferedImage bufferedImage = toBufferedImage(bitMatrix);
            bufferedImage = setMatrixLogo(bufferedImage, "https://codegc.me/Fay.png");
            ImageIO.write(bufferedImage, format, stream);
        } catch (Exception e) {
            log.error("生成二维码失败", e);
        }
    }

    public static BufferedImage setMatrixLogo(BufferedImage matrixImage, String logUri) throws IOException {
        /**
         * 读取二维码图片，并构建绘图对象
         */
        Graphics2D g2 = matrixImage.createGraphics();
        int matrixWidth = matrixImage.getWidth();
        int matrixHeigh = matrixImage.getHeight();

        /**
         * 读取Logo图片
         */
        BufferedImage logo = ImageIO.read(new URL(logUri));

        //开始绘制图片
        g2.drawImage(logo, matrixWidth / 5 * 2, matrixHeigh / 5 * 2, matrixWidth / 5, matrixHeigh / 5, null);
        //绘制边框
        BasicStroke stroke = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        // 设置笔画对象
        g2.setStroke(stroke);
        //指定弧度的圆角矩形
        RoundRectangle2D.Float round = new RoundRectangle2D.Float(matrixWidth / 5 * 2, matrixHeigh / 5 * 2, matrixWidth / 5, matrixHeigh / 5, 20, 20);
        g2.setColor(Color.white);
        // 绘制圆弧矩形
        g2.draw(round);

        //设置logo 有一道灰色边框
        BasicStroke stroke2 = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        // 设置笔画对象
        g2.setStroke(stroke2);
        RoundRectangle2D.Float round2 = new RoundRectangle2D.Float(matrixWidth / 5 * 2 + 2, matrixHeigh / 5 * 2 + 2, matrixWidth / 5 - 4, matrixHeigh / 5 - 4, 20, 20);
        g2.setColor(new Color(128, 128, 128));
        g2.draw(round2);// 绘制圆弧矩形


        g2.dispose();
        matrixImage.flush();
        return matrixImage;
    }

    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, (matrix.get(x, y) ? BLACK : WHITE));
//              image.setRGB(x, y,  (matrix.get(x, y) ? Color.YELLOW.getRGB() : Color.CYAN.getRGB()));
            }
        }
        return image;
    }

}