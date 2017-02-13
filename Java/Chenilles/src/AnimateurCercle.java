/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author houzegdouh
 */
public class AnimateurCercle implements IAnimateur{
    private final int r, x, y;
    private double angle;
    private final double deltaAngle;

    public AnimateurCercle(int xc, int yc, int r, double angle, double deltaAngle) {
        this.r = r;
        this.x = xc;
        this.y = yc;
        this.angle = angle;
        this.deltaAngle = deltaAngle;
    }

    @Override
    public void deplacer(Forme f) {
        this.angle += this.deltaAngle;
        double angleRadians = Math.toRadians(angle);
        f.placerA((int) (this.x + this.r * Math.cos(angleRadians)),
                (int) (this.y + this.r * Math.sin(angleRadians)));
    }
    
}
