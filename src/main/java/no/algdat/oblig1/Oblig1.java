

package main.java.no.algdat.oblig1;

class Oblig1 {
    
    private Oblig1() {};
    
    
    public static void bytt(int[] a, int x, int y){
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
    
    public static int maks(int[] a) {
        
        if(!a && a.length < 1){
            return new NoSuchElementException("Array passed is Null or empty");
        }
        
        // 1. Sammenlign først a[0] og a[1].
        //Hvis a[0] > a[1], bytter de to verdiene plass (en ombytting).
        
        for(int i = 0; i < a.length - 1; i++){
            if(a[i] > a[i+1]){
                bytt(a, i, i+1);
            }
        }
        
        return a[a.length -1 ]
    }
    
    
}