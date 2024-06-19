package com.jamersc.springboot.todoexpense.controller;

import com.jamersc.springboot.todoexpense.model.User;
import com.jamersc.springboot.todoexpense.service.PdfService;
import com.jamersc.springboot.todoexpense.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayInputStream;
import java.util.List;

@Controller
@RequestMapping("/pdf")
public class PdfController {

    private final PdfService pdfService;
    private final UserService userService;

    @Autowired
    public PdfController(PdfService pdfService, UserService userService) {
        this.pdfService = pdfService;
        this.userService = userService;
    }

    @GetMapping("/generate")
    public ResponseEntity<byte[]> generatePdf() {
        List<User> users = userService.findAllUser();
        ByteArrayInputStream pdfStream = pdfService.generatedPdf(users);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=users.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfStream.readAllBytes());
    }

}
