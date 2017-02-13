
import java.awt.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author houzegdouh
 */
public interface IForme extends IDessinable {
    public int getX();
    public int getY();
    public void placerA(int x, int y);
    public Rectangle getRectangleEnglobant();
}
