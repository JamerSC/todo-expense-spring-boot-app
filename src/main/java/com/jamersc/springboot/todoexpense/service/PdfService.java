package com.jamersc.springboot.todoexpense.service;

import com.jamersc.springboot.todoexpense.exception.DocumentGenerationException;
import com.jamersc.springboot.todoexpense.model.User;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfService {

    // Create my PDF Service

    //ByteArrayInputStream contains an internal buffer that contains bytes that may be read from the stream.
    public ByteArrayInputStream generatedPdf(List<User> users) {
        //Document - Maven: com.github.librepdf:openpdf:1.3.27 (openpdf-1.3.27.jar)
        Document document = new Document();
        //this class implements an output stream in which the data is written into a byte array. The buffer automatically grows as data is written to it
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(new Paragraph("User List"));

            for (User user : users) {
                document.add(new Paragraph("ID: " + user.getId()));
                document.add(new Paragraph("First Name: " + user.getFirstName()));
                document.add(new Paragraph("Last Name: " + user.getLastName()));
                document.add(new Paragraph("Username: " + user.getUsername()));
                document.add(new Paragraph("Created Date: " + user.getCreatedAt()));
                document.add(new Paragraph("Modified Date: " + user.getUpdatedAt()));
                document.add(new Paragraph("------------------------------"));
            }
            document.close();
        } catch (DocumentException e) {
            throw new DocumentGenerationException("Error generating PDF", e);
            //e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
