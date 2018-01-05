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
public class WallMaintainter {
    
    public List<Integer>  squaresCompare(List<Wall> squaresList) {
        
        int counter = 1;
        
        List<Integer> indexMaintainer = new LinkedList<>();
        
        for(int i = 0; i < squaresList.size(); i++) {
            Wall sq  = squaresList.get(i);
            indexMaintainer.add(i);
        }
        
        for(int i = 0; i < squaresList.size(); i++) {
            Wall sq1 = squaresList.get(i);
            for(int j = i+1; j<squaresList.size(); j++) {
                Wall sq2 = squaresList.get(j);
                WallComparator comparator = new WallComparator();
                String test_list = "";
                int c = 0;
                
                
                for (int k =0; k<indexMaintainer.size(); k++) {
                        c = indexMaintainer.get(k);
                         test_list+=(c+", ");
                    }
                     test_list = "";
                if(comparator.compare(sq1,sq2) == 1 && indexMaintainer.indexOf(j) > indexMaintainer.indexOf(i)) {
                    
                    indexMaintainer.remove(indexMaintainer.indexOf(j));
                    indexMaintainer.add(indexMaintainer.indexOf(i), j);
                }
                
                counter++;
            }
        }
        
        return indexMaintainer;
    }
    
}
