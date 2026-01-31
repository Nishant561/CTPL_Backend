package com.nishant.ctplbackend.service.cloudinaryService;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CloudinaryService {

private final Cloudinary cloudinary;

@Autowired
public CloudinaryService(Cloudinary cloudinary){
    this.cloudinary = cloudinary;
}

    public List<Map<String, Object>> uploadFile(List<MultipartFile> files, String folder) {

        return files.stream()
                .map(img -> {
                    try {
                        @SuppressWarnings("unchecked")
                        Map<String, Object> result = (Map<String, Object>) cloudinary.uploader().upload(
                                img.getBytes(),
                                ObjectUtils.asMap(
                                        "folder", folder,
                                        "resource_type", "auto"
                                )
                        );
                        return result;
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to upload file: " + img.getOriginalFilename(), e);
                    }
                })
                .collect(Collectors.toList());
    }}
