package br.com.sysmap.redesocial.service.fileupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileUploadService implements IFileUploadService {
    @Autowired
    private AwsService awsService;

    public String upload(MultipartFile file, String fileName){
        var fileUri = "";
        try {
            fileUri = awsService.upload(file, fileName);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

        return fileUri;
    }
}
