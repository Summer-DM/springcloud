package com.summer.springcloud.springcloudcommon.utils.java8Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Summer_DM
 * @Summary TODO  java8的集合stream操作详解
 * @Version 1.0
 * @Date 2021/9/8 下午 05:23
 **/
public class StreamDemo {

    /**
     * 获取集合中的最大值或最小值
     */
    public void testMaxAndMin() {
        List<Integer> list = Arrays.asList(1, -1, 2, -2);
        Integer max = list.stream().max((i, j) -> Integer.compare(i, j)).get();
        Integer min = list.stream().min((i, j) -> Integer.compare(i, j)).get();
        System.out.printf("max=%s, min=%s", max, min); // max=2, min=-2
    }

    /**
     * 排序
     */
    public void testSorted() {
        List<Integer> list = Arrays.asList(1, 4, 3, 2);
        // 正序排序
        List<Integer> sortedList1 = list.stream().sorted().collect(Collectors.toList());
        System.out.printf("sortedList1=%s%n", sortedList1);// sortedList1=[1, 2, 3, 4]
        // 倒序排序
        List<Integer> sortedList2 = list.stream().sorted((i, j) -> Long.compare(j, i)).collect(Collectors.toList());
        System.out.printf("sortedList2=%s", sortedList2);// sortedList2=[4, 3, 2, 1]
    }

    /**
     * 使用map可以访问list中的元素的某些属性或方法
     */
    public void testMap() {
        List<String> list = Arrays.asList("a", "java", "helianxiaowu");
        // 获取list中的字符串的长度
        List<Integer> mapList = list.stream().map(String::length).collect(Collectors.toList());
        System.out.printf("mapList=%s%n", mapList); // mapList=[1, 4, 12]
    }

    /**
     * 滤重
     */
    public void testDistinct() {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 3, 3);
        List<Integer> distinctList = list.stream().distinct().collect(Collectors.toList());
        System.out.printf("distinctList=%s", distinctList); // distinctList=[1, 2, 3]
    }

    /**
     * limit可以取出集合中的前n个元素
     */
    public void testLimit() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        // 取出前3个元素
        List<Integer> limitList = list.stream().limit(3).collect(Collectors.toList());
        System.out.printf("limitList=%s", limitList); // limitList=[1, 2, 3]
    }

    /**
     * skip可以去除list中的前n个元素，与limit相反作用
     */
    public void testSkip() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        // 去除list中的前3个元素
        List<Integer> skipList = list.stream().skip(3).collect(Collectors.toList());
        System.out.printf("skipList=%s", skipList); // skipList=[4, 5, 6]
    }

    /**
     * 根据条件过滤集合中的元素
     */
    public void testFilter() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        // 过滤能被2整除的元素
        List<Integer> filterList = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.printf("filterList=%s", filterList); // filterList=[2, 4, 6]
    }

    /**
     * 聚合
     */
    public void testReduce() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // 计算list中所有元素的乘积
        Integer integer = list.stream().reduce((i, j) -> i * j).get();
        System.out.printf("integer=%s", integer); // integer=24
    }

    /**
     * 匹配
     * anyMatch 集合中的元素有一个满足条件就返回true
     * allMatch 集合中的元素全部满足条件返回true
     * noneMatch 集合中的元素都不满足条件返回true
     */
    public void testMatch() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // list中有没有大于等于4的元素
        boolean b1 = list.stream().anyMatch(i -> i >= 4);
        System.out.printf("b1=%s%n", b1);// b1=true

        // list中的元素是否全部大于4
        boolean b2 = list.stream().allMatch(i -> i > 4);
        System.out.printf("b2=%s%n", b2); // b2=false

        // list中的元素是否没有大于4的
        boolean b3 = list.stream().noneMatch(i -> i > 4);
        System.out.printf("b3=%s", b3);// b3=true

    }
}