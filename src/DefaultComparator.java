/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Comparator;

/**
 *
 * @author lukaszjelen
 */
public class DefaultComparator<E> implements Comparator<E> {
    public int compare(E a, E b) throws ClassCastException { 
        return ((Comparable<E>) a).compareTo(b);
        } 
}

