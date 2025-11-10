package com.thc.sprbasic2025fall.Controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController // 페이지 리턴이 아닌 객체 리턴
@RequestMapping("/api/default") // 모든 메서드 앞에 붙는 매핑

public class DefaultRestController {
    @PostMapping("uploadFile")
    public String uploadFile(MultipartFile file) {
        System.out.println("file : " + file.getOriginalFilename());

        String finalFileName = null;
        String path = "C:\\Users\\user\\Downloads\\uploadfile2025\\";
        String fileName = file.getOriginalFilename();

        File newfile = new File(path);
        if(!newfile.exists()){
            newfile.mkdirs();
        }

        Date date = new Date();
        String temp_date = date.getTime() + "";
        try {
            FileCopyUtils.copy(file.getBytes(), new File(path + temp_date + "_" + fileName));
            finalFileName = temp_date + "_" + fileName;
        } catch (Exception e) {}

        return finalFileName;
    }
}
