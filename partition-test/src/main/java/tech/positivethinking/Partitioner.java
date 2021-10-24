package tech.positivethinking;

import com.google.common.collect.Lists;

import java.util.List;

public class Partitioner {

    /**
     * @param liste  : the list to perform the partitioning on
     * @param taille : the partitions size
     * @param <T>    : Generic type of the list to partition
     * @return : List that contains all the partitions
     */
    public static <T> List<List<T>> partition(List<T> liste, int taille) {
        return Lists.partition(liste, taille);
    }
}
