/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meter;

import java.util.ArrayList;

/**
 *
 * @author san
 */
public class CalReading {

    public int getValue(String a) {           
        String values[]=a.toString().split("\\s+");                     
        ArrayList<Integer> arrayIndex = new ArrayList<Integer>();
        
        for (int j = 0; j < values.length; j++) {
            if(Integer.parseInt(values[j])>600){               
               arrayIndex.add(j);
           }
            
        }
        System.out.println(arrayIndex.get(0));
        if(arrayIndex.size()==1){
            switch (arrayIndex.get(0)){
                case 0:
                    return 10;
                case 1:
                    return 20;
                case 2:
                    return 30;
                case 3:
                    return 40;
                case 4:
                    return 50; 
                case 5:
                    return 60;
                case 6:
                    return 70;
                case 7:
                    return 80;
                    
            }            
        }
        return 0;
    }
    
}
