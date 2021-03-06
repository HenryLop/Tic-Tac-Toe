/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;
import model.Game.Win;

/**
 *
 * @author Pardo
 */
public class Rival {
    public static int randomMove(){
        Random random = new Random();
        int move = random.nextInt(9);
        while(Game.alreadyPlayed(move)){
            move = random.nextInt(9);

        }
        return move;
    }
    
    public static Win possibleBlockOrWin(){
        int coincidencesX = 0;
        int coincidencesO = 0;
        char[] currentGame = Game.getCurrentGame();
        for(int i = 1; i < currentGame.length; i++){
            for (Win win : Game.checkPossibleWins(i)) {
                if(win == null) break;
                for(int number : win.numbers){
                    if('x'== currentGame[number-1]) coincidencesX++;
                    if('o'== currentGame[number-1]) coincidencesO++;
                }
                if(coincidencesO == 2 && coincidencesX == 0) return win;
                if(coincidencesX == 2 && coincidencesO == 0) return win;
                coincidencesO = 0;
                coincidencesX = 0;
            }
        }
        return new Win();
    }
    
    public static int bestMove(){
        char[] currentGame = Game.getCurrentGame();
        if(possibleBlockOrWin().isWin){
            for(int number: possibleBlockOrWin().numbers){
                if(currentGame[number -1] == ' ')  return number-1;
            }
        }
        return randomMove();
    }
    
}
