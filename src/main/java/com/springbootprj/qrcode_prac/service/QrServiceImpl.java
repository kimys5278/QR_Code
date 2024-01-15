package com.springbootprj.qrcode_prac.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class QrServiceImpl implements QrService{
    @Override
    public Object cerateQR(String url) throws WriterException, IOException{
            //qr 크기 설정
            int width = 200;
            int height = 200;

            // QR Code - BitMatrix: qr code 정보 생성
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE,width,height);

            try(ByteArrayOutputStream out = new ByteArrayOutputStream();){
                MatrixToImageWriter.writeToStream(bitMatrix,"PNG",out);
                return out.toByteArray();
            }

        }
}
