package test.java.no.algdat.oblig1;

import main.java.no.algdat.oblig1.Oblig1;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class Oblig1Test {

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

        System.out.println(sum / 100);
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
}