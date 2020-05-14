package com.diary.diaryserver.controller;

import com.diary.diaryserver.bean.Diary;
import com.diary.diaryserver.service.DiaryService;
import org.apache.ibatis.annotations.Delete;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/diary")
public class DiaryController {
    @Autowired
    DiaryService diaryService;

    @PostMapping("/getdiaryList")
    public List<Diary> findDiaruList(String userId){
//        System.out.println(userId);
        return diaryService.findDiaryByUser(userId);
    }


    @PostMapping("/adddiary")
    public int addDiary(Diary diary){
        diary.setDiary_createTime(new Timestamp(System.currentTimeMillis()));
        return diaryService.addDiary(diary);
    }

    @PutMapping("/updatedairy")
    public int updateDiary(@RequestBody Diary diary){
        return diaryService.updateDiary(diary);
    }


    @DeleteMapping("/deletediary/{diaryId}")
    public int deleteDiary(@PathVariable("diaryId") int diaryId){
//        System.out.println(diaryId);
        return diaryService.deleteDiary(diaryId);
    }




    //获取当前日期时间的string类型用于文件名防重复
    public String dates(){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    @RequestMapping("wx_uploadImg")
    public String uploadPicture(HttpServletRequest request,@RequestParam("image") MultipartFile file) throws Exception {
        System.out.println(file);


        //如果文件不为空，写入上传路径
        if (!file.isEmpty()){
            //上传文件路径
            String path = request.getServletContext().getRealPath("/upload/");
            System.out.println("path = " + path);
            //上传文件名
            String filename = file.getOriginalFilename();
            File filePath = new File(path, filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filePath.getParentFile().exists()){
                filePath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path+File.separator + filename));
            System.out.println(filename);
            return "success";
        }else {
            return "error";
        }

//        //获取从前台传过来得图片
//        MultipartHttpServletRequest req =(MultipartHttpServletRequest)request;
//        MultipartFile multipartFile = req.getFile("file");
//        //获取图片的文件类型
//        String houzhu=multipartFile.getContentType();
//        int one = houzhu.lastIndexOf("/");
//        System.out.println(houzhu.substring((one+1),houzhu.length()));
//        System.out.println(multipartFile.getName());
//        //根据获取到的文件类型截取出图片后缀
//        String type=houzhu.substring((one+1),houzhu.length());
//        System.out.println(multipartFile.getContentType());
//
//        String filename;
//        // request.getRealPath获取我们项目的根地址在加上我们要保存的地址
//        String realPath = request.getSession().getServletContext().getRealPath("/upload/wximg/");
//
//        try {
//            File dir = new File(realPath);
//            if (!dir.exists()) {
//                dir.mkdir();
//            }
//            //获取到当前的日期时间用户生成文件名防止文件名重复
//            String filedata=this.dates();
//            //生成一个随机数来防止文件名重复
//            int x=(int)(Math.random()*1000);
//            filename="zhongshang"+x+filedata;
//            System.out.println(x);
//            //将文件的地址和生成的文件名拼在一起
//            File file = new File(realPath,filename+"."+type);
//            multipartFile.transferTo(file);
//            //将图片在项目中的地址和isok状态储存为json格式返回给前台，由于公司项目中没有fastjson只能用这个
//            JSONObject jsonObject=new JSONObject();
//            jsonObject.put("isok",1);
//            jsonObject.put("dizhi","/upload/wximg/"+filename+"."+type);
//
//            writer.write(jsonObject.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        }
    }



}
