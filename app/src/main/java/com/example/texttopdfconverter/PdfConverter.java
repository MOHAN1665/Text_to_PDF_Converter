package com.example.texttopdfconverter;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PdfConverter {

    public static void textToPdf(Context context, String text) {
        Document document = new Document();

        try {
            // Create a file with a unique timestamp-based name in the Documents directory
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
            String fileName = "ConvertedFile_" + timeStamp + ".pdf";

            File pdfFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), fileName);
            OutputStream outputStream = Files.newOutputStream(pdfFile.toPath());

            PdfWriter.getInstance(document, outputStream);

            document.open();

            // Add content to the PDF
            document.add(new Paragraph(text));

            document.close();

            // Display the path as a Toast message
            String filePath = pdfFile.getAbsolutePath();
            Toast.makeText(context, "PDF created successfully!\nFile Path: " + filePath, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
