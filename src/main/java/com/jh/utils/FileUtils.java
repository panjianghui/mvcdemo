package com.jh.utils;

import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.*;
import java.util.Iterator;

public class FileUtils {
    /**
     * 压缩图片大小而不改变像素
     * @param imgByte
     * @param quality
     * @return
     */
    public static byte[] CompressPicByQuality(byte[] imgByte, float quality){
        byte[] inByte = null;
        try {
            ByteArrayInputStream byteInput = new ByteArrayInputStream(imgByte);
            BufferedImage image = ImageIO.read(byteInput);
            if(image == null){
                return null;
            }
            // 获取指定图片类型的writer
            Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName("jpeg");
            ImageWriter imageWriter = iter.next();
            ImageWriteParam iwp = imageWriter.getDefaultWriteParam();
            iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            iwp.setCompressionQuality(quality);
            iwp.setProgressiveMode(ImageWriteParam.MODE_DISABLED);

            ColorModel colorModel = ColorModel.getRGBdefault();
            // 指定压缩是使用的色彩模式
            iwp.setDestinationType(new ImageTypeSpecifier(colorModel,colorModel.createCompatibleSampleModel(16,16)));
            ByteArrayOutputStream outByte = new ByteArrayOutputStream();
            IIOImage iioImage = new IIOImage(image,null,null);
            imageWriter.setOutput(ImageIO.createImageOutputStream(outByte));
            imageWriter.write(null,iioImage,iwp);
            inByte = outByte.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("压缩图片异常，message:" + e.getMessage());
        }
        return inByte;
    }

    /**
     * 将文件转成byte[]
     * @param filePath
     * @return
     */
    public static byte[] fileToBytes(String filePath) {
        byte[] buffer = null;
        File file = new File(filePath);

        FileInputStream fis = null;
        ByteArrayOutputStream bos = null;

        try {
            fis = new FileInputStream(file);
            bos = new ByteArrayOutputStream();

            byte[] b = new byte[1024];
            int n;

            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }

            buffer = bos.toByteArray();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } finally {
            try {
                if (null != bos) {
                    bos.close();
                }
            } catch (IOException ex) {

            } finally {
                try {
                    if (null != fis) {
                        fis.close();
                    }
                } catch (IOException ex) {

                }
            }
        }

        return buffer;
    }

    /**
     * 将byte[]转成文件
     * @param buffer
     * @param filePath
     */
    public static void bytesToFile(byte[] buffer, final String filePath) {

        File file = new File(filePath);
        OutputStream output = null;
        BufferedOutputStream bufferedOutput = null;

        try {
            output = new FileOutputStream(file);
            bufferedOutput = new BufferedOutputStream(output);

            bufferedOutput.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bufferedOutput) {
                try {
                    bufferedOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != output) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
