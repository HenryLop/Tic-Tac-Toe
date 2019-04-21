/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Pardo
 */
public class Panel extends JPanel{
    private boolean empty = true;

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
    
    
    public void drawX(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(10,10,this.getWidth()-20,this.getHeight()-20);
        g2.drawLine(this.getWidth()-20,10,10,this.getHeight()-20);
    }
    
    public void drawO(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.blue);
        g2.setStroke(new BasicStroke(3));
        g2.drawOval(10,10,this.getWidth()-20,this.getHeight()-20);
    }
    
    public void drawHorizontalWin(Graphics g){
        
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.green);
        g2.setStroke(new BasicStroke(7));
        g2.drawLine(0,this.getHeight()/2,this.getWidth(),this.getHeight()/2);

    }
        
    public void drawVerticalWin(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.green);
        g2.setStroke(new BasicStroke(7));
        g2.drawLine(this.getWidth()/2,0,this.getWidth()/2,this.getHeight());
    }
    
    public void drawDiagonalLeftWin(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.green);
        g2.setStroke(new BasicStroke(7));
        g2.drawLine(0,0,this.getWidth(),this.getHeight());
    }
    
    public void drawDiagonalRightWin(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.green);
        g2.setStroke(new BasicStroke(7));
        g2.drawLine(this.getWidth(),0,0,this.getHeight());
    }
}
