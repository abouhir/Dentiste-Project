package application.pdf;

import application.dal.model.Client;
import application.dal.model.Dentiste;
import application.dal.model.Medicament;
import application.dal.model.Ordonnance;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PdfGenerator {
    public static void GeneratePdf(Client c, Dentiste d, Ordonnance o) throws IOException, BadElementException {

        Font ttlFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 10f);
        Font hdrFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 8f);
        Font lstFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6f);
        Font infosFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 6f,BaseColor.BLUE);


        Document document = new Document(PageSize.A6,
                10f, 10f, 7f, 7f);

        //Dentist Body
        Paragraph dentInfos = new Paragraph("Docteur :  xxxxxxx xxxxxxxx\nAdresse : 97 Rue Boumdiane el gheouti hay dakhla" +
                "\nCabinet Dentiste : 78 45 63 21"+"\nTéléphone : 06.41.85.36.14", infosFont);
        dentInfos.setAlignment(Element.ALIGN_LEFT);
        dentInfos.setSpacingAfter(16f);
        //image
        Image img = Image.getInstance("src/resource/Icons/dentist.png");
        img.scaleAbsolute(70f,50f);
        img.setAbsolutePosition(220f, 370f);

        //date
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate= formatter.format(date);
        Paragraph dateP = new Paragraph("Le "+strDate, lstFont);
        dateP.setAlignment(Element.ALIGN_RIGHT);
        dateP.setSpacingAfter(16f);

        //Client Body
        Paragraph cliInfos = new Paragraph(c.showInfos(), infosFont);
        cliInfos.setAlignment(Element.ALIGN_CENTER);
        cliInfos.setSpacingAfter(16f);


        //Medics Header
        Paragraph medicsHeader = new Paragraph("Medicament : ", hdrFont);
        cliInfos.setAlignment(Element.ALIGN_CENTER);
        cliInfos.setSpacingBefore(15f);
        cliInfos.setSpacingAfter(2f);

        //Medics List
        List medicsList = new List(List.UNORDERED);
        for (Medicament m: o.getMedics())
            medicsList.add(new ListItem(m.getNom(), lstFont));

        try {
            FileChooser fc = new FileChooser();
            PdfWriter writer = PdfWriter
                    .getInstance(document,
                            new FileOutputStream(fc.showSaveDialog(null)+".pdf"));
            document.open();
            document.add(dentInfos);
            document.add(img);
            document.add(dateP);
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
