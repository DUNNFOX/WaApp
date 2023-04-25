package com.wa.mvccontroller;

import com.wa.google.model.InputFile;
import com.wa.google.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class TestController {

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    @Autowired
    FileService fileService;

    @PostMapping(value = "/upload",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public List<InputFile> addFile(@RequestParam("file") MultipartFile[] files,
                                   @RequestParam String name) {

        System.out.println(name);
        //   LOGGER.debug("Call addFile API");
        return fileService.uploadFiles(files);
    }


}
