package application.pdf;

import application.dal.model.Client;
import application.dal.model.Dentiste;
import application.dal.model.Medicament;
import application.dal.model.Ordonnance;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;


public class PdfGenerator {
    public static void GeneratePdf(Client c, Dentiste d, Ordonnance o,String nomfile) {

        Font ttlFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 10f);
        Font hdrFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 8f);
        Font lstFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6f);
        Font infosFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6f);


        Document document = new Document(PageSize.A6,
                10f, 10f, 7f, 7f);


        //Ordonnance Title
        Paragraph title = new Paragraph(o.getPdfTitle(), ttlFont);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        title.setSpacingAfter(18f);

        //Dentist Header
        Paragraph dentHeader = new Paragraph("Dentist :", hdrFont);
        dentHeader.setAlignment(Paragraph.ALIGN_LEFT);
        dentHeader.setSpacingBefore(8f);
        dentHeader.setSpacingAfter(2f);

        //Dentist Body
        Paragraph dentInfos = new Paragraph(d.showInfos(), infosFont);
        dentInfos.setAlignment(Element.ALIGN_LEFT);
        dentInfos.setSpacingAfter(16f);

        //Client Header
        Paragraph cliHeader = new Paragraph("Client :", hdrFont);
        cliHeader.setAlignment(Paragraph.ALIGN_LEFT);
        cliHeader.setSpacingBefore(8f);
        cliHeader.setSpacingAfter(2f);

        //Client Body
        Paragraph cliInfos = new Paragraph(c.showInfos(), infosFont);
        cliInfos.setAlignment(Element.ALIGN_LEFT);
        cliInfos.setSpacingAfter(16f);


        //Medics Header
        Paragraph medicsHeader = new Paragraph("Medicament : ", hdrFont);
        cliInfos.setAlignment(Element.ALIGN_LEFT);
        cliInfos.setSpacingBefore(15f);
        cliInfos.setSpacingAfter(2f);

        //Medics List
        List medicsList = new List(List.UNORDERED);
        for (Medicament m: o.getMedics())
            medicsList.add(new ListItem(m.getNom(), lstFont));

        try {
            PdfWriter writer = PdfWriter
                    .getInstance(document,
                            new FileOutputStream(nomfile+".pdf"));
            document.open();
            document.add(title);
            document.add(dentHeader);
            document.add(dentInfos);
            document.add(cliHeader);
            document.add(cliInfos);
            if (!o.getMedics().isEmpty()) {
                document.add(medicsHeader);
                document.add(medicsList);
            }

            document.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



}
