/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Game;
import model.Game.Win;
import model.Rival;
import view.Frame;
import view.Panel;

/**
 *
 * @author Pardo
 */
public class Control extends MouseAdapter {
    static Frame frame = new Frame();
    static boolean gameWinned = false;
            
    @Override
    public void mouseClicked(MouseEvent e) {
        Panel panel = (Panel) e.getSource();

        if(panel.isEmpty()){
            if(gameWinned || Game.isFull()){
                resartGame(panel);
            }else{
                play(panel,panel.getGraphics());
                if(!gameWinned && !Game.isFull()){
                    int move = Rival.bestMove();
                    play((Panel)panel.getParent().getComponent(move),panel.getParent().getComponent(move).getGraphics());
                }              
            }
        }else{
            if(gameWinned || Game.isFull()){
                resartGame(panel);
            }
        }
    }
    
    void play(Panel panel, Graphics g){

        
            switch(model.Game.getTurn()){

                case 'x':
                    panel.drawX(g);
                    model.Game.setTurn('o');
                    model.Game.addMove(Integer.parseInt(panel.getName()),'x');
                    break;

                case 'o':
                    panel.drawO(g);
                    model.Game.setTurn('x');
                    model.Game.addMove(Integer.parseInt(panel.getName()),'o');
                    break;
            }
            
            panel.setEmpty(false);
            Win win = Game.checkWin(Integer.parseInt(panel.getName()));
            if(win.isWin){
                gameWinned = true;
                sendWinToGui(panel,win);
            }
        

    }
    
    void sendWinToGui(Panel panel,Win win){
        Component[] components;
        components = panel.getParent().getComponents();
        
        switch (win.type) {
            
            case Win.HORIZONTAL:
                for(int i = 0; i < 3; i++){
                    Panel current = (Panel)components[win.numbers[i]-1];
                    current.drawHorizontalWin(current.getGraphics());
                }   
                break;
            
            case Win.VERTICAL:
                for(int i = 0; i < 3; i++){
                    Panel current = (Panel)components[win.numbers[i]-1];
                    current.drawVerticalWin(current.getGraphics());
                }   
                break;
            
            case Win.DIAGONAL_LEFT:
                for(int i = 0; i < 3; i++){
                    Panel current = (Panel)components[win.numbers[i]-1];
                    current.drawDiagonalLeftWin(current.getGraphics());
                }   
                break;
                
            case Win.DIAGONAL_RIGHT:
                for(int i = 0; i < 3; i++){
                    Panel current = (Panel)components[win.numbers[i]-1];
                    current.drawDiagonalRightWin(current.getGraphics());
                }   
                break;                      
        }
        
    }
    
    public void resartGame(Panel panel){
        gameWinned = false;

        Game.setTurn('x');
        Game.setCurrentGame(new char[9]);

        
        Component[] components;
        components = panel.getParent().getComponents();
        
        for(Component component: components){
            Panel current = (Panel) component;
            current.setEmpty(true);
        }
                
        frame.init();
    }
    
    
    
    public static void main(String[] args) {
        frame.init();
    }
    
}
