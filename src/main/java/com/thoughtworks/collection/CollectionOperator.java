package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        if (left <= right) {
            return IntStream.rangeClosed(left, right).boxed().collect(Collectors.toList());
        } else {
            return IntStream.rangeClosed(right, left).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        }
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        if (left <= right) {
            return IntStream.rangeClosed(left, right).boxed().filter(e -> e % 2 == 0).collect(Collectors.toList());
        } else {
            return IntStream.rangeClosed(right, left).boxed().filter(e -> e % 2 == 0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        }
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).boxed().filter(e -> e % 2 == 0).collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        return Arrays.stream(firstArray).boxed().filter(e -> Arrays.stream(secondArray).boxed().anyMatch(e1 -> e1.equals(e))).collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> first = Arrays.asList(firstArray);
        List<Integer> second = Arrays.asList(secondArray);
        List<Integer> result = new ArrayList<>();
        result.addAll(Arrays.asList(firstArray));
        result.addAll(second.stream().filter(e -> first.stream().noneMatch(e::equals)).collect(Collectors.toList()));
        return result;
    }
}
