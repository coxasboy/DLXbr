/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package org.acabativa.dlxbr;

/**
 *
 * @author Matheus
 */
public class DLXNode {
    
    DLXNode right;
    DLXNode left;
    DLXNode up;
    DLXNode down;
    DLXNode columnNode;
    
    private int indexColumn;
    private int indexRow;
    
    private boolean controlNode = false;
    
    private int columnSize = 0;
    private String name;
    
    public DLXNode(boolean isControlNode) {
        this.controlNode = isControlNode;
        this.right = this;
        this.left = this;
        this.up = this;
        this.down = this;
        this.columnNode = this;
    }
    
    public DLXNode getRight() {
        return right;
    }
    
    public DLXNode getLeft() {
        return left;
    }
    
    public void setRight(DLXNode right) {
        this.right = right;
    }
    
    public void setLeft(DLXNode left) {
        this.left = left;
    }

    public int getIndexColumn() {
        return indexColumn;
    }

    public void setIndexColumn(int indexColumn) {
        this.indexColumn = indexColumn;
    }

    public int getIndexRow() {
        return indexRow;
    }

    public void setIndexRow(int indexRow) {
        this.indexRow = indexRow;
    }
    
    public boolean isControlNode() {
        return controlNode;
    }
    
    public void setControlNode(boolean controlNode) {
        this.controlNode = controlNode;
    }
    
    public DLXNode getUp() {
        return up;
    }
    
    public void setUp(DLXNode up) {
        this.up = up;
    }
    
    public DLXNode getDown() {
        return down;
    }
    
    public void setDown(DLXNode down) {
        this.down = down;
    }
    
    public DLXNode getColumnNode() {
        return columnNode;
    }
    
    public void setColumnNode(DLXNode columnNode) {
        this.columnNode = columnNode;
    }
    
    public int getColumnSize() {
        return columnSize;
    }
    
    public void setColumnSize(int columnSize) {
        this.columnSize = columnSize;
    }
    
    public String getName() {
        if(isControlNode()){
            return name + " size: " + this.getColumnSize();
        }
        return name ;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void linkDown(DLXNode node){
        node.setColumnNode(this.getColumnNode());
        this.getColumnNode().setColumnSize(this.getColumnNode().getColumnSize()+1);
        this.down.setUp(node);
        node.setDown(this.down);
        node.setUp(this);
        this.setDown(node);
        
    }
    
    public void linkRight(DLXNode node){
        this.right.setLeft(node);
        node.setRight(this.right);
        node.setLeft(this);
        this.setRight(node);
    }
    
    public void print(){
        DLXNode nextLine = this;
        while (!nextLine.getRight().equals(this)) {
            System.out.print(nextLine.getName() + "\t");
            nextLine.printDown();
            nextLine = nextLine.getRight();
        }
        
    }
    
    public void printDown(){
        System.out.println(this.name + " - " + this.isControlNode());
        DLXNode aux = this.down;
        while (!aux.equals(this)){
            System.out.println(aux.name + " - " + aux.isControlNode());
            aux = aux.down;
        }
        System.out.println("-----------------");
    }
    
    public void printRight(){
        System.out.println("000000000000000000000000");
        System.out.println(this.getName() + " - " + this.isControlNode());
        DLXNode aux = this.right;
        while (!aux.equals(this)){
            System.out.println(aux.getName() + " - " + aux.isControlNode());
            aux = aux.right;
        }
        System.out.println("000000000000000000000000");
    }

    @Override
    public String toString() {
        return "DLXNode{" + "indexColumn=" + indexColumn + ", indexRow=" + indexRow + ", name=" + name + '}';
    }
    
    
    
}
