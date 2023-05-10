package br.com.sysmap.redesocial.service.fileupload;

import br.com.sysmap.redesocial.exception.DomainException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

@Service
public class AwsService {

    @Autowired
    private AmazonS3 amazonS3;

    public String upload(MultipartFile multipartFile, String fileName) {
        var fileUri = "";
        try {
            var fileConvert = convertMultiPartToFile(multipartFile);
            amazonS3.putObject(new PutObjectRequest("parrot-bucket", fileName, fileConvert).withCannedAcl(CannedAccessControlList.PublicRead));
            fileUri = "http://s3.localhost.localstack.cloud:4566" + "/" + "parrot-bucket" + "/" + fileName;

            fileConvert.delete();

        } catch (Exception e) {
            throw new DomainException(e.getMessage());
        }

        return fileUri;
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        var convFile = new File(Objects.requireNonNull(file.getOriginalFilename()));

        var fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();

        return convFile;
    }

}
