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
            log.info(textInPdf);
            assertEquals("Esto en un PDF simple.", textInPdf.trim());
        } catch (ErrorWhileReadingPdfFileException e) {
            fail();
        }
    }

    @Test
    void readPdf() {
        try {
            String textInPdf = service.readPdfFile("samples/listado-trabajos.pdf");
            log.info(textInPdf);
            assertTrue(textInPdf.contains("GIMP"));
            assertTrue(textInPdf.contains("Instrucciones"));
            assertTrue(textInPdf.contains("tendrá"));
        } catch (ErrorWhileReadingPdfFileException e) {
            fail();
        }
    }
}
