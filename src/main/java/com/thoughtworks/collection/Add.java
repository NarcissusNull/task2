package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int start = Math.min(leftBorder, rightBorder);
        int end = Math.max(leftBorder, rightBorder);
        return IntStream.rangeClosed(start, end).filter(e -> e % 2 == 0).sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int start = Math.min(leftBorder, rightBorder);
        int end = Math.max(leftBorder, rightBorder);
        return IntStream.rangeClosed(start, end).filter(e -> e % 2 != 0).sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return (int) arrayList.stream().collect(Collectors.summarizingInt(value -> value * 3 + 2)).getSum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().collect(ArrayList::new, (R, e) -> R.add(e % 2 != 0 ? 3 * e + 2 : e), ArrayList::addAll);
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(e -> e % 2 != 0).reduce(0, (R, T) -> R += T * 3 + 5);
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> result = arrayList.stream().filter(e -> e % 2 == 0).sorted().collect(Collectors.toList());
        if (result.size() % 2 == 0) {
            return (result.get(result.size() / 2) + result.get(result.size() / 2 - 1)) / 2.0;
        } else {
            return result.get(result.size() / 2 - 1);
        }
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().filter(e -> e % 2 == 0).collect(Collectors.averagingInt(e -> e));
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(e -> e % 2 == 0).anyMatch(e -> e.equals(specialElment));
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(e -> e % 2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> result1 = arrayList.stream().filter(e -> e % 2 == 0).sorted().collect(Collectors.toList());
        List<Integer> result2 = arrayList.stream().filter(e -> e % 2 != 0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        result1.addAll(result2);
        return result1;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        throw new NotImplementedException();
    }
}
