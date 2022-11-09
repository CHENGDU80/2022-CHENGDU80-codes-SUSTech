package cn.edu.sustech.zxc.booking.java2py;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RuntimeFunction {
    public static void main(String[] args) {
        Process proc;
        try {
            String pyVersion = "python";//可更改成指定版本的python路径
            String pyPath = "E:\\javaproject\\chengdu80\\src\\main\\java\\cn\\edu\\sustech\\zxc\\booking\\java2py\\model.py"; //调用的python程序路径
            String target_path = "E:\\javaproject\\chengdu80\\src\\main\\java\\cn\\edu\\sustech\\zxc\\booking\\java2py\\example.csv";
            String[] command = new String[] {pyVersion, pyPath,target_path};//如果需要传参数，直接连在pyPath之后
            proc = Runtime.getRuntime().exec(command);
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }
}