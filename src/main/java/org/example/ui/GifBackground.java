package org.example.ui;

import javax.swing.*;
import java.awt.*;

public class GifBackground extends JPanel {

    private ImageIcon gif;

    public GifBackground() {

        gif = new ImageIcon(
                getClass().getResource(
                        "/images/romantic_dinner.gif"
                )
        );

        setLayout(new GridBagLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (gif != null) {

            Image image = gif.getImage();

            int panelWidth = getWidth();
            int panelHeight = getHeight();

            int imageWidth = image.getWidth(this);
            int imageHeight = image.getHeight(this);

            if (imageWidth > 0 && imageHeight > 0) {

                double scaleX =
                        (double) panelWidth / imageWidth;

                double scaleY =
                        (double) panelHeight / imageHeight;

                double scale =
                        Math.max(scaleX, scaleY);

                int newWidth =
                        (int) (imageWidth * scale);

                int newHeight =
                        (int) (imageHeight * scale);

                int x =
                        (panelWidth - newWidth) / 2;

                int y =
                        (panelHeight - newHeight) / 2;

                g.drawImage(
                        image,
                        x,
                        y,
                        newWidth,
                        newHeight,
                        this
                );
            }
        }

        // Dark romantic overlay
        g.setColor(
                new Color(
                        20,
                        5,
                        12,
                        110
                )
        );

        g.fillRect(
                0,
                0,
                getWidth(),
                getHeight()
        );
    }
}