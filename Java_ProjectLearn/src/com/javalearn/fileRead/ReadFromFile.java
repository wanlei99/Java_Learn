package com.javalearn.fileRead;

import java.io.*;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.8.10$
 * @Param 以字节读取文件，常用于二进制文件，如图片、声音、影像等文件$
 * @return $
 */
public class ReadFromFile {
    public static void readFileByBytes(String fileName) {
        File file = new File(fileName);
        InputStream inputStream = null;
        try {
            System.out.println("以字节为单位读取晚间内容，一次读一个字节：");
            inputStream = new FileInputStream(file);
            int tempByte;
            while ((tempByte = inputStream.read()) != -1) {
                System.out.println(tempByte);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        try {
            System.out.println("以字节为单位读取文件内容，一次读取多个字节：");
            byte[] tempByte = new byte[100];
            int byteRead = 0;
            try {
                inputStream = new FileInputStream(fileName);
                ReadFromFile.readFileByBytes(String.valueOf(inputStream));
                while ((byteRead = inputStream.read(tempByte)) != -1) {
                    System.out.write(tempByte, 0, byteRead);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
