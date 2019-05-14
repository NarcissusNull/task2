package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().max(Comparator.naturalOrder()).get();
    }

    public double getMinimum() {
        return arrayList.stream().min(Comparator.naturalOrder()).get();
    }

    public double getAverage() {
        return arrayList.stream().collect(Collectors.averagingInt(e -> e));
    }

    public double getOrderedMedian() {
        List<Integer> result = arrayList.stream().sorted().collect(Collectors.toList());
        if (result.size() % 2 == 0) {
            return (result.get(result.size() / 2) + result.get(result.size() / 2 - 1)) / 2.0;
        } else {
            return result.get(result.size() / 2 - 1);
        }
    }

    public int getFirstEven() {
        return arrayList.stream().filter(e -> e % 2 == 0).findFirst().get();
    }

    public int getIndexOfFirstEven() {
        return IntStream.range(0, arrayList.size()).filter(e -> arrayList.get(e) % 2 == 0).findFirst().getAsInt();
    }

    public boolean isEqual(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        int size = arrayList.size();
        if (size % 2 == 0) {
            return ((Integer) singleLink.getNode(size / 2) + (Integer) singleLink.getNode(size / 2 + 1)) / 2.0;
        } else {
            return (Integer) singleLink.getNode(size / 2 + 1) / 1.0;
        }
    }

    public int getLastOdd() {
        return arrayList.stream().filter(e -> e % 2 != 0).reduce((R, T) -> T).get();
    }

    public int getIndexOfLastOdd() {
        return IntStream.range(0, arrayList.size()).filter(e -> arrayList.get(e) % 2 != 0).reduce((R, T) -> T).getAsInt();
    }
}
