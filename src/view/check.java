/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author hoand
 */
public class check {
    
    //check blank string
    public boolean checkvalidString(String s){
        if(s.trim().length()==0){
            return false;
        }
        return true;
    }
    public boolean checkValidInt(String s){
        try {
            int a = Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public boolean checkPositive(int s){
        if(s<=0){
            return false;
        }return true;
    }
}
