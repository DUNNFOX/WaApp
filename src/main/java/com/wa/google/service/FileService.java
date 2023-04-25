package com.wa.google.service;

import com.wa.google.exception.BadRequestException;
import com.wa.google.exception.GCPFileUploadException;
import com.wa.google.model.FileDto;
import com.wa.google.model.InputFile;
import com.wa.google.util.DataBucketUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private DataBucketUtil dataBucketUtil;

    public List<InputFile> uploadFiles(MultipartFile[] files) {


        List<InputFile> inputFiles = new ArrayList<>();

        Arrays.asList(files).forEach(file -> {
            String originalFileName = file.getOriginalFilename();
            if (originalFileName == null) {
                throw new BadRequestException("Original file name is null");
            }
            Path path = new File(originalFileName).toPath();

            try {
                String contentType = Files.probeContentType(path);
                FileDto fileDto = dataBucketUtil.uploadFile(file, originalFileName, contentType);

                if (fileDto != null) {
                    inputFiles.add(new InputFile(fileDto.getFileName(), fileDto.getFileUrl()));
                    //         System.out.println("File uploaded successfully, file name: {} and url: {}",fileDto.getFileName(), fileDto.getFileUrl() );
                }
            } catch (Exception e) {

                throw new GCPFileUploadException("Error occurred while uploading");
            }
        });

        //  fileRepository.saveAll(inputFiles);
        //   LOGGER.debug("File details successfully saved in the database");
        return inputFiles;
    }
}