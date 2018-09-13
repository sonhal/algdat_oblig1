package no.oslomet.cs.algdat;

import no.oslomet.cs.algdat.Oblig1;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Oblig1MyTest {

    int[] testArray;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        testArray = new int[]{123,24,435,23,123,535,23,35,5,10};
    }

    @org.junit.jupiter.api.Test
    void bytt() {
    }

    @org.junit.jupiter.api.Test
    void maks() {
        assertEquals(535, Oblig1.maks(testArray));
    }

    @org.junit.jupiter.api.Test
    void ombyttinger() {
        assertEquals(7, Oblig1.ombyttinger(testArray));
    }

    @org.junit.jupiter.api.Test
    void ombyttinger_gjennomsnitt() {

        int[][] arrays = new int[100][10];
        for (int i = 0; i < 100; i++) {
            arrays[i] = Oblig1.randIntArray(10);
        }
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            int number = Oblig1.ombyttinger(arrays[i]);
            sum += number;
        }

        int[][] arraysP = new int[100][10];
        for (int i = 0; i < 100; i++) {
            arraysP[i] = Oblig1.randIntArray(10);
        }
        int sumP = 0;
        for (int i = 0; i < 100; i++) {
            int number = Oblig1.ombyttningerMaksFraPensum(arraysP[i]);
            sumP += number;
        }

        System.out.println("Maks fra Oblig: " + sum / 100);
        System.out.println("Maks fra Pensum: " + sumP / 100);
    }

    @org.junit.jupiter.api.Test
    void antallUlikeSortert() {
        int antallUnike = 6;
        int[] sortertArr = {1,1,1,5,5,8,20,50,50,51};
        int[] enkeltTall = {1};
        assertEquals(antallUnike, Oblig1.antallUlikeSortert(sortertArr));
        assertEquals(1, Oblig1.antallUlikeSortert(enkeltTall));
    }

    @org.junit.jupiter.api.Test
    void isSorted() {
        int[] sortedArray = {1,4,6,7,200};
        assertFalse(Oblig1.isSorted(testArray));
        assertTrue(Oblig1.isSorted(sortedArray));
    }

    @Test
    void randIntArray() {
        int[] a = Oblig1.randIntArray(10);
        System.out.println(Arrays.toString(a));
    }

    @Test
    void antallUlikeUsortert() {
        int[] usortert = {1,2,3,3,3,4,1,1,2,11,11,11,17,2,12,50};
        int unique = 8;
        assertEquals(unique, Oblig1.antallUlikeUsortert(usortert));

    }

    @Test
    void delsortering() {
        int[] delArr = {1, 2, 3, 4, 6, 5};
        Oblig1.delsortering(delArr);
        System.out.println(Arrays.toString(delArr));
    }

    @Test
    void delsortering_only_even() {
        int[] delArr = {4,2,6,10,8,4};
        Oblig1.delsortering(delArr);
        System.out.println(Arrays.toString(delArr));
    }

    @Test
    void delsortering_only_odd() {
        int[] delArr = {3,5,1,11,9,7};
        Oblig1.delsortering(delArr);
        System.out.println(Arrays.toString(delArr));
    }

    @Test
    void delsortering_neg() {
        int[] delArr = {-3,-5,-2,11,-9,7,12,5};
        Oblig1.delsortering(delArr);
        System.out.println(Arrays.toString(delArr));
    }

    @Test
    void rotasjon() {
        char[] delArr = {'A', 'B', 'C', 'D', 'E'};
        Oblig1.rotasjon(delArr);
        System.out.println(Arrays.toString(delArr));
    }

    @Test
    void kvikksortering() {
    }

    @Test
    void rotasjonNeg() {
    }

    @Test
    void flett() {
        String s = Oblig1.flett("", "AB");  // kaller metoden
        System.out.println(s);
    }

    @Test
    void flett1() {
    }

    @Test
    void indekssortering() {
        int[] testArray = {21,23,42,4,4,6,12,4,8,34};
        System.out.println(Arrays.toString(Oblig1.indekssortering(testArray)));
    }

    @Test
    void insettingSorterting() {
        int[] testArray = {21,23,42,4,4,6,12,4,8,34};
        System.out.println(Arrays.toString(testArray));
    }

    @Test
    void insettingSortertingForIndex() {
    }

    @Test
    void tredjeMin() {
        int[] testArray = {10, 6, 3, 4, 5, 9, 1, 7, 8, 2};
        int[] result = Oblig1.tredjeMin(testArray);
        System.out.println(Arrays.toString(result));
    }

    @Test
    void inneholdt() {
        boolean b = Oblig1.inneholdt("ABBA", "BARBERER");
        System.out.println(b);
    }

    @Test
    void antallGangerSett() {
        int[] ax = new int[29];
        char a = 'Å';
        char b = 'Æ';
        char c = 'Ø';
        Oblig1.registrerNyCharObservasjon(ax,a);
        Oblig1.registrerNyCharObservasjon(ax,b);
        Oblig1.registrerNyCharObservasjon(ax,c);
        System.out.println(Arrays.toString(ax));
    }
}