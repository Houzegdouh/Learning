
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author houzegdouh
 */
public class TestChenilleImage {

    /**
     * nombre de chenilles Star War par defaut
     */
    public static final int NBCH_SW = 5;

    /**
     * nombre de chenilles Star War par defaut
     */
    public static final int NBCH_COUL = 5;
    /**
     * nombre de visages par défaut
     */
    public static final int NBVG = 5;
    public static final int FF = 5;

    public static String[] tetesFileNames = {
        //        "images/darthVador.png",
        //        "images/leila.png",
        //        "images/c3po.png",
        //        "images/starTrooper.png"

        "images/leila.png",
        "images/c3po.png",
        "images/darthVador.png",
        "images/starTrooper.png"
    };

    public static void main(String[] args) throws IOException {
        int nbChenillesStarWar = NBCH_SW; // nombre de chenille Star War à afficher
        int nbChenillesCoul = NBCH_COUL;  // nombre de chenille couleur à afficher
        int nbVisages = NBVG; // nombre de visages à afficher
        int nbFormes = FF; // nombre de formes fixes à afficher
        int tempsPause = 80; // temps de pause entre deux réafficahge (en ms).
        BufferedImage[] images = new BufferedImage[tetesFileNames.length];
        for (int i = 0; i < images.length; i++) {
            images[i] = ImageIO.read(new File(tetesFileNames[i]));
        }
        if (args.length >= 1) {
            nbChenillesStarWar = Integer.parseInt(args[0]);
            if (args.length >= 2) {
                nbChenillesCoul = Integer.parseInt(args[1]);
            }
            if (args.length >= 3) {
                tempsPause = Integer.parseInt(args[2]);
            }
        }

        // la fenêtre graphique
        JFrame laFenetre = new JFrame("Chenilles");
        laFenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        laFenetre.setSize(1280, 720);

        // créé la zone de dessin et la place dans la fenêtre
        Dessin d = new Dessin();
        laFenetre.getContentPane().add(d);

        //  affiche la fenêtre
        laFenetre.setVisible(true);

        // creation d'un objet Chenille
        IDessinable[] formesAmovilble = new IDessinable[nbChenillesStarWar + nbChenillesCoul + nbVisages + 1];
        IDessinable[] formesFixe = new IDessinable[nbFormes];
        for (int i = 0; i < nbChenillesStarWar; i++) {
            Random random = new Random();
            int nbAx = random.nextInt(20);
            formesAmovilble[i] = new ChenilleImage(d, nbAx, (i < 3) ? images[i] : images[3]);
            d.ajouterObjet(formesAmovilble[i]);
        }
        for (int i = 0; i < nbVisages; i++) {
            Random random = new Random();
            int tL = random.nextInt(100);
            int tH = random.nextInt(100);
            formesAmovilble[nbChenillesStarWar + i] = new VisageRond(d, 0, 0, tL, tH);
            d.ajouterObjet(formesAmovilble[nbChenillesStarWar + i]);
        }
        for (int i = 0; i < nbChenillesCoul; i++) {
            Random random = new Random();
            int nbAx = random.nextInt(20);
            formesAmovilble[nbChenillesStarWar + nbVisages + i] = new ChenilleColor(
                    new Color((float) Math.random(),
                            (float) Math.random(),
                            (float) Math.random()),
                    d, nbAx, 15);
            d.ajouterObjet(formesAmovilble[nbChenillesStarWar + nbVisages + i]);
        }
        formesAmovilble[nbChenillesStarWar + nbChenillesCoul + nbVisages] = new ChenilleImage(d, 0, ImageIO.read(new File("images/DB.png")));
        d.ajouterObjet(formesAmovilble[nbChenillesStarWar + nbChenillesCoul + nbVisages]);
        d.ajouterObjet(new Etoile(new Color((float) Math.random(),
                (float) Math.random(),
                (float) Math.random()), new Color((float) Math.random(),
                (float) Math.random(),
                (float) Math.random()), 150, 150, 100, 20, 5));
        d.ajouterObjet(new PolygoneRegulier(new Color((float) Math.random(),
                (float) Math.random(),
                (float) Math.random()), new Color((float) Math.random(),
                (float) Math.random(),
                (float) Math.random()), 1050, 600, 100, 20, 5));
        d.ajouterObjet(new PolygoneRegulier(new Color((float) Math.random(),
                (float) Math.random(),
                (float) Math.random()), new Color((float) Math.random(),
                (float) Math.random(),
                (float) Math.random()), 500, 350, 50, 20, 8));
        while (true) {
            // les visages effectuent un déplacement élémentaire
            // en rebondissant sur les bords et en changeant d'expression

            

            // la zone de dessin se réaffiche
            d.repaint();

            // un temps de pause pour avoir le temps de voir le nouveau dessin
            d.pause(tempsPause);
            d.animer();

        }
    }
}
