package com.detection.text.imagereader;

import com.detection.text.exceptions.ErrorWhileReadingImageFileException;
import com.detection.text.models.TesseractDataLanguage;
import com.detection.text.services.ImageReaderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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
}