package nmd.mzgh.nextgen.edi;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HeaderFooterHandler implements IEventHandler {
    @Override
    public void handleEvent(Event docEvent) {
        if (docEvent instanceof PdfDocumentEvent) {
            PdfDocumentEvent event = (PdfDocumentEvent) docEvent;
            PdfDocument pdfDocument = event.getDocument();
            PdfPage page = event.getPage();
            int totalPages = pdfDocument.getNumberOfPages();
            int pageNumber = pdfDocument.getPageNumber(page);

            PdfCanvas canvas = new PdfCanvas(page);

            canvas.beginText(); // Adding Header
            canvas.moveText(36, pdfDocument.getDefaultPageSize().getTop() - 20);
            try {
                canvas.setFontAndSize(PdfFontFactory.createFont(), 12);
            } catch (IOException e) { throw new RuntimeException(e); }
            canvas.showText("NextGen");
            canvas.endText();

            URL u; // Adding Logo
            try {
                u = new URL("https://img.icons8.com/?size=100&id=20680&format=png&color=000000");
            } catch (MalformedURLException e) { throw new RuntimeException(e); }
            ImageData img = ImageDataFactory.create(u);
            img.setWidth(25);
            img.setHeight(25);
            canvas.addImageAt(img,pdfDocument.getDefaultPageSize().getWidth() - 36, pdfDocument.getDefaultPageSize().getTop() - 25, true);

            canvas.beginText(); // Adding Footer
            canvas.moveText(36, 20);
            canvas.showText("Page " + pageNumber + " sur " + totalPages);
            canvas.endText();

            canvas.release();
        }
    }
}
