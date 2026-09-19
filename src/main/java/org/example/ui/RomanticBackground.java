package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class RomanticBackground extends JPanel {

    private final ArrayList<Heart> hearts =
            new ArrayList<>();

    private final Random random =
            new Random();

    private final Timer animationTimer;

    public RomanticBackground() {

        setOpaque(true);

        setBackground(
                new Color(15, 5, 10)
        );

        // Create initial hearts
        for (int i = 0; i < 35; i++) {

            hearts.add(
                    createHeart(true)
            );
        }

        // Animation timer
        animationTimer =
                new Timer(
                        35,
                        e -> {
                            updateAnimation();
                            repaint();
                        }
                );

        animationTimer.start();
    }

    private Heart createHeart(
            boolean randomPosition
    ) {

        int panelWidth =
                Math.max(getWidth(), 1200);

        int panelHeight =
                Math.max(getHeight(), 700);

        double x =
                random.nextInt(panelWidth);

        double y;

        if (randomPosition) {

            y =
                    random.nextInt(panelHeight);

        } else {

            y =
                    panelHeight + 30;
        }

        int size =
                12 + random.nextInt(35);

        double speed =
                0.4 + random.nextDouble() * 1.4;

        double drift =
                -0.4 + random.nextDouble() * 0.8;

        int alpha =
                50 + random.nextInt(130);

        return new Heart(
                x,
                y,
                size,
                speed,
                drift,
                alpha
        );
    }

    private void updateAnimation() {

        for (int i = 0;
             i < hearts.size();
             i++) {

            Heart heart =
                    hearts.get(i);

            heart.y -= heart.speed;

            heart.x += heart.drift;

            heart.pulse += 0.08;

            if (heart.y < -80) {

                hearts.set(
                        i,
                        createHeart(false)
                );
            }
        }

        // Occasionally create another heart
        if (random.nextInt(18) == 0) {

            hearts.add(
                    createHeart(false)
            );
        }

        // Keep the number of hearts controlled
        if (hearts.size() > 55) {

            hearts.remove(0);
        }
    }

    @Override
    protected void paintComponent(
            Graphics g
    ) {

        super.paintComponent(g);

        Graphics2D g2 =
                (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        // =========================================================
        // DARK ROMANTIC GRADIENT
        // =========================================================

        GradientPaint gradient =
                new GradientPaint(
                        0,
                        0,
                        new Color(45, 8, 25),
                        getWidth(),
                        getHeight(),
                        new Color(10, 4, 9)
                );

        g2.setPaint(gradient);

        g2.fillRect(
                0,
                0,
                getWidth(),
                getHeight()
        );

        // =========================================================
        // SOFT CENTER GLOW
        // =========================================================

        RadialGradientPaint glow =
                new RadialGradientPaint(
                        new Point(
                                getWidth() / 2,
                                getHeight() / 2
                        ),
                        Math.max(
                                getWidth(),
                                getHeight()
                        ) / 2f,
                        new float[]{0f, 1f},
                        new Color[]{
                                new Color(120, 20, 55, 35),
                                new Color(0, 0, 0, 0)
                        }
                );

        g2.setPaint(glow);

        g2.fillRect(
                0,
                0,
                getWidth(),
                getHeight()
        );

        // =========================================================
        // DRAW HEARTS
        // =========================================================

        for (Heart heart : hearts) {

            drawHeart(
                    g2,
                    heart
            );
        }

        g2.dispose();
    }

    private void drawHeart(
            Graphics2D g2,
            Heart heart
    ) {

        // Pulsing effect
        double pulse =
                Math.sin(heart.pulse) * 0.10 + 1.0;

        int size =
                (int) (
                        heart.size * pulse
                );

        int x =
                (int) heart.x;

        int y =
                (int) heart.y;

        // =========================================================
        // SOFT HEART GLOW
        // =========================================================

        g2.setColor(
                new Color(
                        255,
                        70,
                        120,
                        Math.min(
                                heart.alpha / 3,
                                50
                        )
                )
        );

        g2.fillOval(
                x - size / 2,
                y - size / 2,
                size * 2,
                size * 2
        );

        // =========================================================
        // HEART SHAPE
        // =========================================================

        Polygon heartShape =
                new Polygon();

        heartShape.addPoint(
                x,
                y + size
        );

        heartShape.addPoint(
                x - size,
                y
        );

        heartShape.addPoint(
                x - size,
                y - size / 2
        );

        heartShape.addPoint(
                x - size / 2,
                y - size
        );

        heartShape.addPoint(
                x,
                y - size / 2
        );

        heartShape.addPoint(
                x + size / 2,
                y - size
        );

        heartShape.addPoint(
                x + size,
                y - size / 2
        );

        heartShape.addPoint(
                x + size,
                y
        );

        g2.setColor(
                new Color(
                        255,
                        80,
                        125,
                        heart.alpha
                )
        );

        g2.fillPolygon(
                heartShape
        );
    }
}


// ================================================================
// HEART DATA
// ================================================================

class Heart {

    double x;
    double y;

    int size;

    double speed;
    double drift;

    int alpha;

    double pulse;

    public Heart(
            double x,
            double y,
            int size,
            double speed,
            double drift,
            int alpha
    ) {

        this.x = x;
        this.y = y;

        this.size = size;

        this.speed = speed;
        this.drift = drift;

        this.alpha = alpha;

        this.pulse =
                Math.random() * Math.PI * 2;
    }
}