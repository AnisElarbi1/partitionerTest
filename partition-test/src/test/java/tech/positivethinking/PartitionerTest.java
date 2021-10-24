package tech.positivethinking;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static java.util.List.of;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


@RunWith(Enclosed.class)
public class PartitionerTest {

    @RunWith(Parameterized.class)
    public static class PartitionTest {

        private final List<Integer> liste;
        private final int taille;
        private final List<List<Integer>> partitions;

        public PartitionTest(List<Integer> liste, int taille, List<List<Integer>> partitions) {
            this.liste = liste;
            this.taille = taille;
            this.partitions = partitions;
        }

        @Parameterized.Parameters
        public static List<Object[]> inputs() {
            // the list to partition , partitioning size, expected partitions
            return of(new Object[][]{
                    {of(1, 2, 3), 2, of(of(1, 2), of(3))},
                    {of(4, 8, 0), 1, of(of(4), of(8), of(0))},
                    {of(3, 9, 1, 7), 4, of(of(3, 9, 1, 7))},
                    {of(5), 2, of(singletonList(5))},
                    {of(), 3, emptyList()}
            });
        }

        @Test
        public void should_return_valid_partitions() {
            var actualPartitions = Partitioner.partition(liste, taille);
            assertArrayEquals(partitions.toArray(), actualPartitions.toArray());
        }

        @Test
        public void should_return_valid_partitions_numbers() {
            var expectedSize = partitions.size();
            var actualSize = Partitioner.partition(liste, taille).size();
            assertEquals(expectedSize, actualSize);
        }

    }

    public static class PartitionExceptionTest {

        @Test(expected = IllegalArgumentException.class)
        public void should_throw_an_illegal_argument_exception_when_split_argument_is_less_or_equal_to_ZERO() {
            Partitioner.partition(of(9, 5, 7), 0);
            Partitioner.partition(of(9, 5, 7), -1);
        }

        @Test(expected = NullPointerException.class)
        public void should_throw_a_null_pointer_exception_with_null_or_list_of_null() {
            Partitioner.partition(null, 1);
            Partitioner.partition(of(null, null), 1);
        }

    }

}