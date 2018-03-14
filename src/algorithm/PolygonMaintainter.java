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
        
        int n = squaresList.size();
        int helper = 0;
        
        PolygonComparator comparator = new PolygonComparator();
        
        boolean proceed;
        
        //TODO - implement procedure to compare each wall with all different walls
        
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
