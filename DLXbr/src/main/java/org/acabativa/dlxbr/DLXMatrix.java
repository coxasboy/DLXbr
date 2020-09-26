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
public class DLXMatrix {
    
    public static DLXNode instantiateFrom2DArray(int [][] primitiveMatrix){
        DLXNode[][] matrix = createObjectArray(primitiveMatrix);
        DLXNode header = createHeaderNode();   
        
        linkRight(header, matrix);
        linkDown(matrix);
       
        return header;        
    }
    
    private static void linkDown(DLXNode[][] matrix){
        for (int i = 0; i < matrix[0].length; i++) {
            DLXNode lastNode = null;
            for (int j = 0; j < matrix.length; j++) {
                DLXNode dLXNode = matrix[j][i];
                if(dLXNode!=null){
                    if(lastNode!=null){
                        lastNode.linkDown(dLXNode);
                    }
                    lastNode = dLXNode;
                }
            }
        }
    }
    
    private static void linkRight(DLXNode header, DLXNode[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            DLXNode[] dLXNodes = matrix[i];
            DLXNode lastNode = null;
            if(i==0){
                lastNode = header;
            }
            for (int j = 0; j < dLXNodes.length; j++) {
                DLXNode dLXNode = dLXNodes[j];
                if(dLXNode!=null){
                    if(lastNode!=null){
                        lastNode.linkRight(dLXNode);
                    }
                    lastNode = dLXNode;
                }
            }
        }
    }
    
    private static DLXNode createHeaderNode(){
        DLXNode header = new DLXNode(true);
        header.setIndexColumn(-1);
        header.setIndexRow(-1);
        header.setName("header");
        header.setColumnSize(Integer.MAX_VALUE);
        return header;
    }
    
    private static DLXNode[][] createObjectArray(int [][] primitiveMatrix){
        DLXNode [][] matrix = new DLXNode[primitiveMatrix.length+1][primitiveMatrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[0][i] = new DLXNode(true);
            matrix[0][i].setIndexColumn(i);
            matrix[0][i].setIndexRow(0);
            matrix[0][i].setName("(0" + " - " + i + ")");
        }
        for (int i = 0; i < primitiveMatrix.length; i++) {
            int[] is = primitiveMatrix[i];
            for (int j = 0; j < is.length; j++) {
                int k = is[j];
                if(k==1){
                    matrix[i+1][j] = new DLXNode(false);
                    //System.out.println("Setting node: " + (i+1) + " " + j );
                    matrix[i+1][j].setIndexColumn(j);
                    matrix[i+1][j].setIndexRow(i+1);
                    matrix[i+1][j].setName("(" + (i+1) + " - " + j + ")");
                }
            }
        }
        return matrix;
    }
    
    public static int [][] generateTestCase(){
        int [][] test = new int [6][7];
        //A
        test[1][0] = 1;
        test[3][0] = 1;
        //B
        test[2][1] = 1;
        test[4][1] = 1;
        //C
        test[0][2] = 1;
        test[2][2] = 1;
        //D
        test[1][3] = 1;
        test[3][3] = 1;
        test[5][3] = 1;
        //E
        test[0][4] = 1;
        test[5][4] = 1;
        //F
        test[0][5] = 1;
        test[2][5] = 1;
        //G
        test[1][6] = 1;
        test[4][6] = 1;
        test[5][6] = 1;
        return test;
    }
    
    public static int[][] tcreateTestCase2(){
        int [][] test = new int [6][7];
        //A
        test[0][0] = 1;
        test[1][0] = 1;
        //B
        test[2][1] = 1;
        test[3][1] = 1;
        //C
        test[4][2] = 1;
        test[5][2] = 1;
        //D
        test[1][3] = 1;
        test[3][3] = 1;
        test[5][3] = 1;
        //E
        test[0][4] = 1;
        test[5][4] = 1;
        //F
        test[0][5] = 1;
        test[2][5] = 1;
        //G
        test[1][6] = 1;
        test[4][6] = 1;
        test[5][6] = 1;
        return test;
    } 
    
   
    
}
