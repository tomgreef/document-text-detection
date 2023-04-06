package com.detection.text.pdfreader;

import com.detection.text.exceptions.ErrorWhileReadingPdfFileException;
import com.detection.text.services.PdfReaderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class PdfReaderTest {
    private static PdfReaderService service;

    @BeforeAll
    static void setup() {
        service = new PdfReaderService();
    }

    @Test
    void readSimplePdf() {
        try {
            String textInPdf = service.readPdfFile("samples/simple.pdf");
            assertEquals("Esto en un PDF simple.", textInPdf.trim());
        } catch (ErrorWhileReadingPdfFileException e) {
            fail();
        }

    }
}
