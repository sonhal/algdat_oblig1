

package main.java.no.algdat.oblig1;

import java.util.NoSuchElementException;

public class Oblig1 {
    
    private Oblig1() {};
    
    
    public static void bytt(int[] a, int x, int y){
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
    
    /**
     * OPPGAVE 1
     * 
     * I metoden maks() blir det O(n) sammenligninger av verdier.
     *
     * Det blir flest ombyttninger om vært tall i arrayet er større en det forgje (n ombyttninger).
     * Det blir færrest ombyttninger når det største tallet i arrayet ligger først i arrayet(1 ombyttning).
     * Gjennomsnittet av ombyttninger er det samme som det harmoniske tallet til størrelsen til arrayet (log(n) + 0.577).
     * 
     */
    public static int maks(int[] a) {
        
        if(a.length < 1){
            throw new NoSuchElementException("Array passed is Null or empty");
        }
        
        // 1. Sammenlign først a[0] og a[1].
        //Hvis a[0] > a[1], bytter de to verdiene plass (en ombytting).
        
        for(int i = 0; i < a.length - 1; i++){
            if(a[i] > a[i+1]){
                bytt(a, i, i+1);
            }
        }
        return a[a.length -1 ];
    }
    
    public static int ombyttinger(int[] a){
        
        if(a.length < 1){
            throw new NoSuchElementException("Array passed is Null or empty");
        }
        int ombyttinger = 0;

        for(int i = 0; i < a.length - 1; i++){
            if(a[i] > a[i+1]){
                ombyttinger++;
                bytt(a, i, i+1);
            }
        }
        return ombyttinger;
    }
    
    
    /**
     * OPPGAVE 2
     * 
     */
    public static int antallUlikeSortert(int[] a){
        if(!isSorted(a)){
            throw new IllegalStateException("Array is not sorted rising");
        }
        
        int uniqueCounter = 1;
        for(int i = 0; i < a.length; i++){
            if(a[i] != a[i+1]){
                uniqueCounter++;
            }
        }
        return uniqueCounter;
    }
    
    public static boolean isSorted(int[] a){
        for(int i = 0; i < a.length; i++){
            if(a[i] > a[i+1]){
                return false;
            }
        }
        return true;
    }
    
}