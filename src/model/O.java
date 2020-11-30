/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Button;
import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import view.Form;

/**
 *
 * @author Tien Thanh
 */
public class O extends JButton {

    private int row;
    private int col;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    
    public O(int row, int col, String tile){
        super(tile);
        this.row=row;
        this.col=col;
    }
}
