/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acabativa.dlxbr;

import java.util.Deque;

/**
 *
 * @author Matheus
 */
public class Function {
    
    private static void cover(DLXNode targetNode){ 
        System.out.println("Cover: " + targetNode.columnNode.getName());
        DLXNode colNode = targetNode.columnNode; 
        colNode.left.right = colNode.right; 
        colNode.right.left = colNode.left; 
  
        for(DLXNode row = colNode.down; row != colNode; row = row.down){ 
            for(DLXNode rightNode = row.right; rightNode != row; rightNode = rightNode.right){ 
                System.out.println("\tCover: " + rightNode.getName());
                rightNode.up.down = rightNode.down; 
                rightNode.down.up = rightNode.up; 
                rightNode.columnNode.setColumnSize(rightNode.columnNode.getColumnSize()-1); 
                //System.out.println("New column size : "+ rightNode.columnNode.getName());
            } 
        } 
    } 
    
    
    private static void uncover(DLXNode targetNode){ 
        System.out.println("Uncover: " + targetNode.getName());
        DLXNode colNode = targetNode.columnNode;
        for(DLXNode rowNode = colNode.up; rowNode != colNode; rowNode = rowNode.up){ 
            for(DLXNode leftNode = rowNode.left; leftNode != rowNode; leftNode = leftNode.left){ 
                System.out.println("Add Uncover: " + leftNode.getName());
                leftNode.up.down = leftNode; 
                leftNode.down.up = leftNode; 
                leftNode.columnNode.setColumnSize(leftNode.columnNode.getColumnSize()+1); 
            } 
        } 
        colNode.left.right = colNode; 
        colNode.right.left = colNode; 
    } 
  

    private static DLXNode getMinColumn(DLXNode header){ 
        //System.out.println("Getting min column: " + header.getName());
        DLXNode minCol = header.getColumnNode(); 
        DLXNode h = minCol.right; 
        while(h!=header.getColumnNode()){ 
            if(h.getColumnSize() < minCol.getColumnSize()){ 
                minCol = h; 
            } 
            h = h.right; 
        }; 
        return minCol; 
    }
    
    private static DLXNode getMinColumn2(DLXNode header){ 
        DLXNode h = header.getColumnNode(); 
        DLXNode min_col = h.right; 
         
  
    return min_col; 
} 
  
  
    public static void search(DLXNode header, Deque<DLXNode> solutions) { 
        
        if(header.right == header){ 
            System.out.println("Search: " + solutions);
            System.out.println("END");
            return; 
        } 

        DLXNode column = getMinColumn(header); 
        System.out.println("Min column: " + column.getName());
        cover(column); 

        for(DLXNode rowNode = column.down; rowNode != column; rowNode = rowNode.down){ 
            solutions.addLast(rowNode.getColumnNode()); 

            for(DLXNode rightNode = rowNode.right; rightNode != rowNode; rightNode = rightNode.right){ 
                cover(rightNode); 
            }
            header.printRight();
            search(header, solutions); 

            solutions.removeLast();

            column = rowNode.columnNode; 
            for(DLXNode leftNode = rowNode.left; leftNode != rowNode; leftNode = leftNode.left){ 
                uncover(leftNode); 
            }
        } 

        uncover(column); 
    } 
    
}
