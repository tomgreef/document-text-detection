package com.detection.text.services;

import java.io.File;
import java.io.IOException;

import com.detection.text.exceptions.ErrorWhileReadingPdfFileException;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

@Slf4j
public class PdfReaderService {

    public String readPdfFile(String fileDirectory) throws ErrorWhileReadingPdfFileException {
        try {
            File file = new File(fileDirectory);
            PDDocument document = PDDocument.load(file);
            PDFTextStripper stripper = new PDFTextStripper();
            String content = stripper.getText(document);
            document.close();
            return content;
        } catch (IOException e) {
            log.error("Error al leer el archivo PDF");
            throw new ErrorWhileReadingPdfFileException();
        }
    }
}
