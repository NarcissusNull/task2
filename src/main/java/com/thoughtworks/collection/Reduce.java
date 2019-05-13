package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        throw new NotImplementedException();
    }

    public int getIndexOfFirstEven() {
        throw new NotImplementedException();
    }

    public boolean isEqual(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        throw new NotImplementedException();
    }

    public int getLastOdd() {
        throw new NotImplementedException();
    }

    public int getIndexOfLastOdd() {
        throw new NotImplementedException();
    }
}
