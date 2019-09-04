package com.iss.demo.Utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/*
* 二维码工具类
* */
public class QRCodeUtil {
    private static final int width = 300;// 默认二维码宽度
    private static final int height = 300;// 默认二维码高度
    private static final String format = "png";// 默认二维码文件格式
    private static final Map<EncodeHintType, Object> hints = new HashMap();// 二维码参数

    static {
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");// 字符编码
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);// 容错等级 L、M、Q、H 其中 L 为最低, H 为最高
        hints.put(EncodeHintType.MARGIN, 2);// 二维码与图片边距
    }
    /**
     * 转换bitmatrix对象为一个图片,并用string展示出来
     */
    public static void toBufferedImage(String content, int width, int height) throws WriterException, IOException {
        //创建一个输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
       //将bitMatyrix对象写入到一张图片中
        BufferedImage image =  MatrixToImageWriter.toBufferedImage(bitMatrix);
        ImageIO.write(image,"png",out);
        byte[] bytes = out.toByteArray();
        // 2、将二进制数组转换成为字节
        BASE64Encoder encoder = new BASE64Encoder();
        String str = encoder.encodeBuffer(bytes).trim();
        System.out.println("---图片对应的str:  "+str);
    }



    /**
     * 将二维码图片输出到一个流中
     * @param content 二维码内容
     * @param destStream  自定义的一个目标输出输出流
     */
    public static void writeToStream(String content, OutputStream destStream, int width, int height) throws WriterException, IOException {
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
        //相当于写入到response的body中比如用reponse获取到OutputStream流
        //ServletOutputStream servletOutputStream = response.getOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, format, destStream);
        System.out.println(">>>writeToStream: " + destStream.toString());
    }
    /**
     * 生成二维码图片文件,未验证
     */
    public static void createQRCode(String content, String path, int width, int height) throws WriterException, IOException {
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
        //toPath() 方法由 jdk1.7 及以上提供
        MatrixToImageWriter.writeToPath(bitMatrix, format, new File(path).toPath());
    }
}
