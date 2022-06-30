package LeetcodeDailyProblems.JuneMonth;

import java.util.Arrays;
import java.util.Comparator;

public class NumOfWeakCharactersInGame {
    public int numberOfWeakCharacters(int[][] properties) {
        
        Arrays.sort(properties, new Comparator<int[]>() {
          public int compare(int[] o1, int[] o2) {
            if (o1[0] == o2[0]) {
              return Integer.compare(o2[1], o1[1]);
            } else {
              return Integer.compare(o1[0], o2[0]);
            }
          }
        });
        
        for(int i=0; i<properties.length; i++) {
            System.out.println(properties[i][1]);
        }
        
        int weak = 0;
        int end = properties.length-1;
        int aMax = properties[end][0];
        int dMax = properties[end][1];
        
        for(int i=end; i>=0; i--) {
            
            if(properties[i][1] > dMax) {
                dMax = properties[i][1];
                aMax = properties[i][0];
            }
            if(properties[i][1] < dMax) {
                weak++;
            }
        }
        return weak;
    }
}
