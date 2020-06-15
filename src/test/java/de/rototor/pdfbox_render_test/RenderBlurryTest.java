package de.rototor.pdfbox_render_test;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class RenderBlurryTest
{
    @Test
    public void testRenderBlurry() throws IOException
    {
        PDDocument doc = PDDocument
                .load(RenderBlurryTest.class.getResourceAsStream("FlowerBompA6.pdf"));
        new File("target/test/").mkdirs();
        File target = new File("target/test/rendered.png");

        PDFRenderer pdfRenderer = new PDFRenderer(doc);
        BufferedImage bufferedImage = pdfRenderer.renderImageWithDPI(0, 304, ImageType.RGB);
        ImageIO.write(bufferedImage, "PNG", target);

        doc.close();
    }
}
