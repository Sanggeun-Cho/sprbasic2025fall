package com.thc.sprbasic2025fall.Controller.page;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;

// 스프링부트에게 컨트롤러임을 알리기 위한 어노테이션 -> 알아서 에러 등도 잡아줌
@Controller
@RequestMapping("")

public class DefaultPageController {
    // 페이지 컨트롤러 예시
    @RequestMapping("/index") // 이건 URL 매핑이라 리턴하는 값과는 관련이 없음
    public String index(){
        System.out.println("DefaultPageController.index()"); // 제대로 전송이 된건지 확인하는 로그 느낌
        return "index"; // PATH : src/resources/templates/index.html
    }

    @ResponseBody
    @RequestMapping(value = "image/{file_name:.+}", method = {RequestMethod.GET, RequestMethod.POST})
    public byte[] getImage(@PathVariable("file_name") String file_name, HttpServletRequest request) throws Exception {
        byte[] return_byte = null;
        String path = "C:\\Users\\user\\Downloads\\uploadfile2025\\";

        // 해당 이미지를 byte[] 형태로 변환
        File file = new File(path + file_name);
        InputStream in = null;

        try {
            in = new FileInputStream(file);
            return_byte = IOUtils.toByteArray(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {

                }
            }
        }

        return return_byte;
    }

    @ResponseBody
    @RequestMapping(value = "/download/{file_name:.+}", method = RequestMethod.GET)
    public void download(@PathVariable("file_name") String file_name, @RequestParam Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String path = "C:\\Users\\user\\Downloads\\uploadfile2025\\";
        File file = new File(path + file_name);

    // Response에 설정, 어려울 수 있음
    String mimeType = URLConnection.guessContentTypeFromName(file_name);
    if(mimeType == null){
        mimeType = "application/octet-stream";
    }
    response.setContentType(mimeType);
    response.setContentLength((int) file.length());
    response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(file.getName(), "utf-8") + "\"");

    InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
    FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
}
