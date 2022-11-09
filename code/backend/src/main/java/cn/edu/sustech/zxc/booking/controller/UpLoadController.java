package cn.edu.sustech.zxc.booking.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
@Api
public class UpLoadController {
    @PostMapping("/upload")
    public Object upload(@RequestParam("file") MultipartFile file){
        System.out.println("upload called");
        return saveFile(file);
    }
    @PostMapping("/multiUpload")
    public Object multiUpload(@RequestParam("file")MultipartFile[] files){
        System.out.println("文件的个数:"+files.length);
        for (MultipartFile f : files){
            saveFile(f);
        }
        return "ok";
    }

    private Object saveFile(MultipartFile file){
        if (file.isEmpty()){
            return "未选择文件";
        }
        String filename = file.getOriginalFilename(); //获取上传文件原来的名称
        String filePath = "E:\\javaproject\\chengdu80\\src\\main\\java\\cn\\edu\\sustech\\zxc\\booking\\java2py\\";
        File temp = new File(filePath);
        if (!temp.exists()){
            temp.mkdirs();
        }

        File localFile = new File(filePath+filename);
        try {
            file.transferTo(localFile); //把上传的文件保存至本地
            System.out.println(file.getOriginalFilename()+" 上传成功");
        }catch (IOException e){
            e.printStackTrace();
            return "上传失败";
        }

        //解析文件
        Process proc;
        String ans = "";
        try {
            String pyVersion = "python";//可更改成指定版本的python路径
            String pyPath = "E:\\javaproject\\chengdu80\\src\\main\\java\\cn\\edu\\sustech\\zxc\\booking\\java2py\\model.py"; //调用的python程序路径
            String target_path = filePath+filename;
            String[] command = new String[] {pyVersion, pyPath,target_path};//如果需要传参数，直接连在pyPath之后
            proc = Runtime.getRuntime().exec(command);
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            while ((ans = in.readLine()) != null) {
                System.out.println(ans);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return ans;
    }
}
