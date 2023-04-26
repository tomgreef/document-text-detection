package com.detection.text.imagereader;

import com.detection.text.exceptions.ErrorWhileReadingImageFileException;
import com.detection.text.models.TesseractDataLanguage;
import com.detection.text.services.ImageReaderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ImageReaderTest {
    private static ImageReaderService service;

    @BeforeAll
    static void setup() {
        service = new ImageReaderService();
    }

    @Test
    void readSimpleJpgImage() {
        try {
            String textInPdf = service.readImageFile("samples/simple.jpg", TesseractDataLanguage.SPANISH);
            assertEquals("Esto en una imagen simple.", textInPdf.trim());
        } catch (ErrorWhileReadingImageFileException e) {
            fail();
        }
    }

    @Test
    void readSimplePngImage() {
        try {
            String textInPdf = service.readImageFile("samples/simple.png", TesseractDataLanguage.SPANISH);
            assertEquals("Esto en una imagen simple.", textInPdf.trim());
        } catch (ErrorWhileReadingImageFileException e) {
            fail();
        }
    }
    @Test
    void readPngImage() {
        try {
            String textInPdf = service.readImageFile("samples/listado-trabajos.png", TesseractDataLanguage.SPANISH);
            log.info(textInPdf);
            assertTrue(textInPdf.contains("GIMP"));
            assertTrue(textInPdf.contains("Instrucciones"));
            assertTrue(textInPdf.contains("tendrá"));
        } catch (ErrorWhileReadingImageFileException e) {
            fail();
        }
    }

    @Test
    void readPngSlide() {
        try {
            String textInPdf = service.readImageFile("samples/diapositiva.png", TesseractDataLanguage.SPANISH);
            log.info(textInPdf);
            assertTrue(textInPdf.contains("justamente"));
            assertTrue(textInPdf.contains("coincidirá"));
            assertTrue(textInPdf.contains("razonamientos"));
            assertFalse(textInPdf.contains("Línea 16"));
        } catch (ErrorWhileReadingImageFileException e) {
            fail();
        }
    }
}
