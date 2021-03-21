package application.pdf;

import application.dal.model.Client;
import application.dal.model.Dentiste;
import application.dal.model.Medicament;
import application.dal.model.Ordonnance;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

public class PdfGenerator {



    public static void GeneratePdf(Client c, Dentiste d, Ordonnance o) {

        Font ttlFont = new Font(Font.FontFamily.valueOf("TimesRoman"), Font.BOLD, 30);
        Font hdrFont = new Font(Font.FontFamily.valueOf("TimesRoman"), Font.BOLD, 25);
        Font lstFont = new Font(Font.FontFamily.valueOf("TimesRoman"), Font.NORMAL, 16);
        Font infosFont = new Font(Font.FontFamily.valueOf("TimesRoman"), Font.NORMAL, 18);

        Document document = new Document(PageSize.A6);
        document.setMargins(10, 10, 10, 10);


        //Ordonnance Title
        Paragraph title = new Paragraph(o.getPdfTitle(), ttlFont);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        title.setSpacingAfter(18f);

        //Dentist Header
        Paragraph dentHeader = new Paragraph("Dentist :", hdrFont);
        dentHeader.setAlignment(Paragraph.ALIGN_LEFT);
        dentHeader.setSpacingBefore(8f);
        dentHeader.setSpacingAfter(8f);

        //Dentist Body
        Paragraph dentInfos = new Paragraph(d.showInfos(), infosFont);
        dentInfos.setAlignment(Element.ALIGN_LEFT);
        dentInfos.setSpacingAfter(16f);

        //Client Header
        Paragraph cliHeader = new Paragraph("Client :", hdrFont);
        cliHeader.setAlignment(Paragraph.ALIGN_LEFT);
        cliHeader.setSpacingBefore(8f);
        cliHeader.setSpacingAfter(8f);

        //Client Body
        Paragraph cliInfos = new Paragraph(c.showInfos(), infosFont);
        cliInfos.setAlignment(Element.ALIGN_LEFT);
        cliInfos.setSpacingAfter(16f);

        //Medics Header
        Paragraph medicsHeader = new Paragraph("Medicament : ", hdrFont);
        cliInfos.setAlignment(Element.ALIGN_LEFT);
        cliInfos.setSpacingBefore(15f);
        cliInfos.setSpacingAfter(6f);

        //Medics List
        List medicsList = new List(List.UNORDERED);
        for (Medicament m:
                o.getMedics())
            medicsList.add(new ListItem(m.getNom(), lstFont));




        try {
            PdfWriter writer = PdfWriter
                    .getInstance(document,
                            new FileOutputStream("facture.pdf"));
            document.open();
            document.add(title);
            document.add(dentHeader);
            document.add(dentInfos);
            document.add(cliHeader);
            document.add(cliInfos);
            document.add(medicsList);

            document.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



}
