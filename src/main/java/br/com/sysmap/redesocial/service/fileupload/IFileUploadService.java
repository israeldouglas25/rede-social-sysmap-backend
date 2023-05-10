package br.com.sysmap.redesocial.service.fileupload;

import org.springframework.web.multipart.MultipartFile;

public interface IFileUploadService {
    String upload(MultipartFile file, String fileName);
}
