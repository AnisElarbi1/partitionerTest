package tech.positivethinking;

import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        if (args.length == 2) {
            var partitions = Partitioner.partition(List.of(args[0].split(",")), Integer.parseInt(args[1]));
            System.out.println(partitions);
        } else {
            throw new IllegalArgumentException("Invalid argument(s), please check your entries again");
        }
    }
}
