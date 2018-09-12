

package no.oslomet.cs.algdat;

import javax.management.InvalidAttributeValueException;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.NoSuchElementException;


public class Oblig1 {
    
    private Oblig1() {};

    public static int[] randIntArray(int size){
        int[] arr = new int[size];

        for (int i = 1; i < size +1; i++) {
            arr[i -1] = i;
        }

        for (int i = size - 1; i >= 0; i--) {
            bytt(arr, i, (int)(Math.random() * i));
        }
        return arr;
    }
    
    
    public static void bytt(int[] a, int x, int y){
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    public static void bytt(char[] a, int x, int y){
        char tmp = a[x];
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
        if(a.length < 1){
            return 0;
        }
        
        int uniqueCounter = 1;
        for(int i = 0; i < a.length -1; i++){
            if(a[i] != a[i+1]){
                uniqueCounter++;
            }
        }
        return uniqueCounter;
    }
    
    public static boolean isSorted(int[] a){
        for(int i = 0; i < a.length - 1; i++){
            if(a[i] > a[i+1]){
                return false;
            }
        }
        return true;
    }

    /**
     * OPPGAVE 3
     */
    public static int antallUlikeUsortert(int[] a){
        if(a.length < 1){
            return 0;
        }

        int uniqueCounter = 0;
        for(int i = 0; i < a.length; i++){
            boolean unique = true;
            for(int j = i - 1; j >= 0; j--){
                if(a[i] == a[j]){
                    unique = false;
                }
            }
            if(unique) uniqueCounter++;
        }
        return uniqueCounter;
    }

    /**
     * OPPGAVE 4
     */
    public static void delsortering(int[] a){

        if(a.length < 1){
            return;
        }

        int arrLength = a.length;
        int l = 0;
        int r = arrLength - 1;
        while(l <= r && r > 0){
            if(a[l] % 2 == 0 ){
                if(a[r] % 2 != 0){
                    bytt(a,l,r);
                    l++;
                    r--;
                }
                else r--;
            }
            else {
                if(a[r] % 2 != 0){
                    l++;
                }
                else {
                    l++;
                    r--;
                }
            }
        }
        int middle = l + r / arrLength;
            kvikksortering(a, 0, l);
            kvikksortering(a, l , arrLength);
    }

    /*
    *Skriv om som egen implementering
     */
    private static int sParter0(int[] a, int v, int h, int indeks)
    {
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h − 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }

    private static int parter0(int[] a, int v, int h, int skilleverdi)
    {
        while (true)                                  // stopper når v > h
        {
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h

            if (v < h) bytt(a,v++,h--);                 // bytter om a[v] og a[h]
            else  return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }

    private static void kvikksortering0(int[] a, int v, int h)  // en privat metode
    {
        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = sParter0(a, v, h, (v + h)/2);  // bruker midtverdien
        kvikksortering0(a, v, k - 1);     // sorterer intervallet a[v:k-1]
        kvikksortering0(a, k + 1, h);     // sorterer intervallet a[k+1:h]
    }

    public static void kvikksortering(int[] a, int fra, int til) // a[fra:til>
    {
        //fratilKontroll(a.length, fra, til);  // sjekker når metoden er offentlig
        kvikksortering0(a, fra, til - 1);  // v = fra, h = til - 1
    }

    /**
     * OPPGAVE 5
     */
    public static void rotasjon(char[] a){
        if(a.length < 2){
            return;
        }

        char last = a[a.length -1];

        char temp = a[a.length -1];

        for(int i = a.length -1; i > 0; i--){
            a[i] = a[i - 1];
        }
        a[0] = temp;
    }

    /**
     * OPPGAVE 6
     */
    public static void rotasjon(char[] a, int k){
        rotasjonOpt(a, k);
    }

    public static void rotasjonOpt(char[] a, int  k){
        int length = a.length;
        if(length < 2){
            return;
        }
        char[] b = new char[length];

        if(k < 0){
            for(int i = 0; i < length; i++){
                int place = ((i + k) % length);
                if(place < 0) place = length + place;
                b[place] = a[i];
            }
        }
        else {
            for(int i = 0; i < length; i++){
                b[(i + k) % length] = a[i];
            }
        }


        for(int i = 0; i < length; i++){
            a[i] = b[i];
        }


    }

    /**
     * OPPGAVE 7
     */
    public static String flett(String s, String t){
        int i = 0;
        int ii = 0;

        StringBuilder newString = new StringBuilder();
        while(i < s.length() && ii < t.length()){
            newString.append(s.charAt(i++));
            newString.append(t.charAt(ii++));
        }
        while (i < s.length()) newString.append(s.charAt(i++));
        while (ii < t.length()) newString.append(t.charAt(ii++));
        return newString.toString();
    }

    public static String flett(String... s){
        StringBuilder newString = new StringBuilder();
        int i = 0;
        boolean allStringsEmpty = true; //Vi må vite om alle Strings i String arrayet er tomme. Denne holder denne informasjonen

        while (true){
            allStringsEmpty = true; //Vi setter den til true slik at vist alle Strings er tomme så faller vi ut av loopen

            for(String str: s){
                if(i < str.length()){
                    allStringsEmpty = false;
                    newString.append(str.charAt(i));
                }
            }
            if(allStringsEmpty) break;
            i++;
        }
        return newString.toString();
    }

    /**
     * OPPGAVE 8
     */
    public static int[] indekssortering(int[] a){
        int arrLength = a.length;
        int[] b = new int[arrLength];

        Arrays.setAll(b, i -> i++);

        insettingSortertingForIndex(a, b);
        return b;
    }

    public static void insettingSortertingForIndex(int[] verdiArray, int[] indexArray){
        int length = verdiArray.length;

        for(int i = 1; i < length; i++){

            int verdi  = verdiArray[indexArray[i]];
            int verdiIndex = indexArray[i];
            int j = i - 1;
            for(;  j >= 0 && verdi < verdiArray[indexArray[j]]; j--){
                indexArray[j + 1] = indexArray[j];
            }
            indexArray[j + 1] = verdiIndex;
        }
    }

    /**
     * OPPGAVE 9
     */
    public static int[] tredjeMin(int[] a){
        int length = a.length;

        if(length < 3){
            throw new NoSuchElementException("Det må hvere minst 3 elementer i arrayet");
        }

        int[] startIndexes = indekssortering(Arrays.copyOfRange(a,0,3));

        int m = startIndexes[0];      // m er posisjonen til største verdi
        int nm = startIndexes[1];     // nm er posisjonen til nest største verdi
        int nnm = startIndexes[2];     // nnm er posisjonen til nest nest største verdi

        int minverdi = a[m];                // største verdi
        int nestminverdi = a[nm];           // nest største verdi
        int nestnestminverdi = a[nnm];           // nest største verdi

        for (int i = 3; i < length; i++)
        {
            if(a[i] < nestnestminverdi){
                if (a[i] < nestminverdi) {
                    if (a[i] < minverdi) {
                        nnm = nm;
                        nestnestminverdi = nestminverdi;

                        nm = m;
                        nestminverdi = minverdi;     // ny nest størst

                        m = i;
                        minverdi = a[m];              // ny størst
                    }
                    else
                    {
                        nnm = nm;
                        nestnestminverdi = nestminverdi;

                        nm = i;
                        nestminverdi = a[nm];         // ny nest størst
                    }
                }
                else {
                    nnm = i;
                    nestnestminverdi = a[nnm];
                }
            }

        }

        return new int[] {m,nm,nnm};
    }

    /**
     * OPPGAVE 10
     */
    public static boolean inneholdt(String a, String b){
        //B er en String som skal inneholde A

        if(a.equals("")) return true;

        int[] bAlfa = new int[29];
        int[] aAlfa = new int[29];

        for(int i = 0; i < b.length(); i++){
            registrerNyCharObservasjon(bAlfa, b.charAt(i));
        }

        for(int i = 0; i < a.length(); i++){
            registrerNyCharObservasjon(aAlfa, a.charAt(i));
        }

        for(int i = 0; i < 29; i++){
            if(aAlfa[i] > bAlfa[i]) return false;
        }
        return true;

    }


    public static void registrerNyCharObservasjon(int[] abcState, char c){
        if(c == 'Å') abcState[c - 169] += 1;
        else if(c == 'Ø') abcState[c - 189] += 1;
        else if(c == 'Æ') abcState[c - 172] += 1;
        else abcState[c - 65] += 1;
    }



}