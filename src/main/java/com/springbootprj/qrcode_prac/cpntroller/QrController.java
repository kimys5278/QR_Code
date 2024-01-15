package com.springbootprj.qrcode_prac.cpntroller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.springbootprj.qrcode_prac.service.QrServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

//QR 코드
//어떤 방향으로 스캔해도 인식 가능.(대각선, 정방향, 역방향 등등)
//최대 숫자 7089자, 문자 4296자에 해당하는 정보 저장 가능.
//인식률, 속도 높음.
//암호화, 위변조 방지 등 보안 기능 존재.
//단점: QR 코드의 수정,삭제 불가능.
@RestController
public class QrController {
    private QrServiceImpl qrServiceImpl;

    @Autowired
    public QrController(QrServiceImpl qrServiceImpl){
        this.qrServiceImpl = qrServiceImpl;
    }
    @GetMapping("/qr")
    public Object cerateQR(@RequestParam String url) throws WriterException, IOException {
        Object Qr = qrServiceImpl.cerateQR(url);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(Qr);
    }
}
