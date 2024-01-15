package com.springbootprj.qrcode_prac.service;

import com.google.zxing.WriterException;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

public interface QrService {
     Object cerateQR(String url) throws WriterException, IOException;

}
