/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Kuba
 */
public class PolygonMaintainter {
    
    public List<Polygon>  squaresCompare(List<Polygon> squaresList) {
        
    	
    	
        List<Integer> indexMaintainer = new LinkedList<>();
        
        for(int i = 0; i < squaresList.size(); i++) {
            Polygon sq  = squaresList.get(i);
            indexMaintainer.add(i);
        }
        
        //Using bubblesort
        
        int counter = squaresList.size();
        int helper = 0;
        
        PolygonComparator comparator = new PolygonComparator();
        
        while(counter!=0) {
        	helper = 0;
        	for(int i = 1; i < counter; i++) {
        		Polygon sq1 = squaresList.get(i-1);
        		Polygon sq2 = squaresList.get(i);
        		
        		if(comparator.compare(sq1,sq2) == 1) {
        			squaresList.add(i+1, sq1);
        			squaresList.remove(i-1);
        			helper = i;
        		}
        	}
        	counter = helper;
        }
        
        /*
        for(int i = 0; i < squaresList.size(); i++) {
            Polygon sq1 = squaresList.get(i);
            for(int j = i+1; j<squaresList.size(); j++) {
                Polygon sq2 = squaresList.get(j);
                PolygonComparator comparator = new PolygonComparator();
                
                if(comparator.compare(sq1,sq2) == 1 && indexMaintainer.indexOf(j) > indexMaintainer.indexOf(i)) {
                    
                    indexMaintainer.remove(indexMaintainer.indexOf(j));
                    indexMaintainer.add(indexMaintainer.indexOf(i), j);
                }
                
                counter++;
            }
        }
        */
        return squaresList;
    }
    
}
