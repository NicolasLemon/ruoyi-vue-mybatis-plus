package com.lemon.demo;

import com.itextpdf.text.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 本地测试类
 *
 * @author Nicolas·Lemon
 * @since 2023/3/22
 */
@Slf4j
public class LocalTest {
    @Test
    public void myTest() {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try {
            PdfWriter.getInstance(document, new FileOutputStream("table.pdf"));
            document.open();

            Paragraph header = new Paragraph("Table Example");
            header.setAlignment(Element.ALIGN_CENTER);
            document.add(header);

            // Create 4 column table
            PdfPTable table = new PdfPTable(4);
            // Set the width of the table to 100% of page width
            table.setWidthPercentage(100);
            // Create header cell
            PdfPCell cell = new PdfPCell(new Phrase("Header 1"));
            cell.setColspan(2); // Merge header columns
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(5);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Header 2"));
            cell.setColspan(2);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(5);
            cell.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cell);

            table.addCell("1.0");
            table.addCell("2.0");
            table.addCell("3.0");
            table.addCell("4.0");

            document.add(table);
            document.close();

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }


}
