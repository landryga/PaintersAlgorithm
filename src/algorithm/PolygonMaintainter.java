/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.LinkedList;
import java.util.List;

import algorithm.BST.TreeException;

/**
 *
 * @author Kuba
 */
public class PolygonMaintainter {
    
    public List<Polygon>  squaresCompare(List<Polygon> squaresList) throws TreeException {
        
    	BST bst = new BST();
    	BST.Node node = bst.new Node(squaresList.get(0));
    	
    	
    	
        List<Polygon> indexMaintainer = new LinkedList<>();
        
        for(int i = 0; i < squaresList.size(); i++) {
        	bst.insert(squaresList.get(i));
        }
        
        //TODO - implement procedure to compare each wall with all different walls
        
        while(BST.root!=null) {
        	node = bst.min(BST.root);
        	indexMaintainer.add(node.polygon);
        	bst.remove(node.polygon);
        }
        
        
        return indexMaintainer;
    }
    
}
