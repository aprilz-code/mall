package com.lsh.aprilz.utils.upload;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.resizers.configurations.ScalingMode;
import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

@Slf4j
public class ImageOperation {
    /**
     * 左旋
     *
     * @param inFile  源文件
     * @param outFile 目的文件
     * @param angle   角度
     * @throws IOException io异常
     */
    public static void leftTotation(File inFile, File outFile, int angle) throws IOException {
        Thumbnails.of(inFile).scale(1).outputQuality(1).rotate(-angle).toFile(outFile);
    }

    /**
     * 右旋
     *
     * @param inFile  源文件
     * @param outFile 目的文件
     * @param angle   角度
     * @throws IOException io异常
     */
    public static void rightTotation(File inFile, File outFile, int angle) throws IOException {
        Thumbnails.of(inFile).scale(1).outputQuality(1).rotate(angle).toFile(outFile);
    }

    /**
     * 压缩
     *
     * @param inFile  源文件
     * @param outFile 目的文件
     * @throws IOException io异常
     */
    public static void thumbnailsImage(File inFile, File outFile, int imageSize) throws IOException {

        Thumbnails.of(inFile).size(imageSize, imageSize)
                .toFile(outFile);

    }


    /**
     * 压缩图片   //小于10kb直接返回，不然压缩
     */
    public static void imageCompression(String path,String outPath){
        ByteArrayOutputStream out = null;
        FileOutputStream outputStream = null;
        try {
            File file = new File(path);
            outputStream = new FileOutputStream(outPath);
            long length = file.length()/1024;

            if (length<10){
                byte[] fileByte = Files.readAllBytes(file.toPath());
                return;
            }
            double qual = 0.50;
            do {
                out = new ByteArrayOutputStream();
                Thumbnails.of(path).
                        scalingMode(ScalingMode.BICUBIC).
                        // 图片缩放90%, 不能和size()一起使用
                                scale(0.9).
                        // 图片质量压缩到50%
                                outputQuality(qual).
                        toOutputStream(out);
                qual=qual-0.1;
            }while ((out.size()/1024)>200);
            outputStream.write(out.toByteArray());
            outputStream.close();
            return ;
        } catch (IOException e) {
            log.error("图片压缩失败",e);
        }finally {
            if (out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    log.error("关闭流失败",e);
                }
            }

            if (outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    log.error("关闭输出流失败",e);
                }
            }
        }
        return ;
    }


    /**
     * 压缩图片   //小于10kb直接返回，不然压缩
     */
    public static void imageCompression(String path){
        ByteArrayOutputStream out = null;
        FileOutputStream outputStream = null;
        try {
            File file = new File(path);
            String parent = file.getParent();
            outputStream = new FileOutputStream(parent + "/"+ file.getName().replace(file.getName().split("\\.")[0], file.getName().split("\\.")[0]+"_min"));
            long length = file.length()/1024;

            if (length<10){
                byte[] fileByte = Files.readAllBytes(file.toPath());
                return;
            }
            double qual = 0.50;
            do {
                out = new ByteArrayOutputStream();
                Thumbnails.of(path).
                        scalingMode(ScalingMode.BICUBIC).
                        // 图片缩放90%, 不能和size()一起使用
                                scale(0.9).
                        // 图片质量压缩到50%
                                outputQuality(qual).
                        toOutputStream(out);
                qual=qual-0.1;
            }while ((out.size()/1024)>200);
            outputStream.write(out.toByteArray());
            return ;
        } catch (IOException e) {
            log.error("图片压缩失败",e);
        }finally {
            if (out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    log.error("关闭流失败",e);
                }
            }

            if (outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    log.error("关闭输出流失败",e);
                }
            }
        }
        return ;
    }


    public static void main(String[] args) throws IOException {
//        FileOutputStream out = new FileOutputStream("H:\\tmp\\ttt_2.jpeg");
//        Thumbnails.of(new File("H:\\tmp\\ttt.jpeg"))
//                .scale(0.9f) //图片大小（长宽）压缩比例 从0-1，1表示原图
//                .outputQuality(0.4f) //图片质量压缩比例 从0-1，越接近1质量越好
//                .toOutputStream(out);
            imageCompression("H:\\tmp\\a.jpeg");
    }
}
