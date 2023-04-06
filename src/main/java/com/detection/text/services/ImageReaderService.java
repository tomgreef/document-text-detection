package com.detection.text.services;

import com.detection.text.exceptions.ErrorWhileReadingImageFileException;
import com.detection.text.models.TesseractDataLanguage;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;


@Slf4j
public class ImageReaderService {

    public String readImageFile(String fileDirectory, TesseractDataLanguage language) throws ErrorWhileReadingImageFileException {
        try {
            File file = new File(fileDirectory);
            Tesseract tesseract = new Tesseract();

            if (language.equals(TesseractDataLanguage.SPANISH)) {
                tesseract.setLanguage("spa");
            }
            tesseract.setDatapath("tesseract-data");

            return tesseract.doOCR(file);
        } catch (TesseractException e) {
            log.error("Error al procesar la imagen");
            throw new ErrorWhileReadingImageFileException();
        }
    }
}