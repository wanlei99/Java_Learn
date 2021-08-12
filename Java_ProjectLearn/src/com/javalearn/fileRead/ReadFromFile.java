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
    /**
     * 以字节读取文件，常用于读二进制文件，如图片，声音、影像等文件
     * @param filename
     */
    public static void readFileByByte(String filename) throws IOException{
        File file = new File(filename);
        InputStream in = null;
        System.out.println("以字节为单位读取文件内容，一次读一个字节：");
        in = new FileInputStream(file);
        int tempByte;
        while ((tempByte = in.read()) != -1){
            System.out.println(tempByte);
        }
        in.close();
        System.out.println("以字节为单位，一次读取多个字节：");
        //一次读取多个字节
        byte[] tempBytes = new byte[100];
        int byteRead = 0;
        in = new FileInputStream(filename);
        while ((byteRead = in.read(tempBytes)) != -1){
            System.out.write(tempBytes,0,byteRead);
        }
    }

    /**
     * 以字符为单位读取文件内容，一次读一个字符
     * @param fileName 文件路径
     */
    public static void readFileByChars(String fileName) throws IOException{
        File file = new File(fileName);
        Reader reader = null;
        System.out.println("以字符读取文件内容，一次读一个字节：");
        reader = new InputStreamReader(new FileInputStream(file));
        int tempChar;
        while ((tempChar = reader.read()) != -1){
            //对于Windows下，/r/n这两个字符在一起时，表示一个换行
            //但如果这两个字符分开显示时，会换两次行。
            //因此要屏蔽掉\r或者屏蔽掉\n，否则将会多出很多空行
            if (((char) tempChar) != -1){
                System.out.println((char) tempChar);
            }
        }
        reader.close();
        System.out.println("以字符为单位读取文件内容，一次读取多个字节:");
        //一次读取多个字符
        char[] tempChars = new char[30];
        int charRead = 0;
        reader = new InputStreamReader(new FileInputStream(fileName));
        //读取多个字符到字符数组中，charRead为一次读取字符数
        while ((charRead = reader.read(tempChars)) != -1){
            //同样屏蔽掉\r
            if ((charRead == tempChars.length) && (tempChars[tempChars.length - 1] != '\r')){
                System.out.println(tempChars);
            } else {
                for (int i = 0; i < charRead; i++) {
                    if (tempChars[i] == '\r'){
                        continue;
                    } else {
                        System.out.print(tempChars[i]);
                    }
                }
            }
        }

    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     * @param fileName
     * @throws IOException
     */
    public static void readFileByLines(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedReader reader = null;
        System.out.println("以行为单位读取文件内容，一次读取一行：");
        reader = new BufferedReader(new FileReader(file));
        String tempString;
        int line = 1;
        while ((tempString = reader.readLine()) != null){
            //显示内容
            System.out.println("line"+line+':'+tempString);
            line++;
        }
        reader.close();

    }

    public static void main(String[] args) throws IOException{
        String fileName = "E:\\应用\\test.txt";
        readFileByByte(fileName);
        readFileByChars(fileName);
        readFileByLines(fileName);
    }
}
