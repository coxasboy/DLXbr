/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acabativa.dlxbr;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author Matheus
 */
public class Main {
    
    public static void main(String[] args) {
        
        int [][] test = DLXMatrix.generateTestCase();
        
        DLXNode node = DLXMatrix.instantiateFrom2DArray(test);
        System.out.println("Root node: " + node.getName());
        DLXSolver solver = new DLXSolver();
        solver.solveProblem(node);
        System.out.println("------------------------");
        for (Object object : solver.getMySolution()) {
            DLXNode nodeAnswer = (DLXNode)object;
            System.out.println(" 1" + nodeAnswer.getName());
        }
                
                
    }
    
}
