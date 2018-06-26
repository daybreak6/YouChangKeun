package org.rvslab.chapter3.java8.chap1;


import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class FilteringApplesTestUnit {

    private List<Apple> inventory = Arrays.asList(
                                            new Apple(80,"green"),
                                            new Apple(155, "green"),
                                            new Apple(120, "red")
                                         );

    //메서드 전달 테스트
    @Test
    public void isGreenAppleTest(){

        System.out.println("ori arr==>" + inventory.size());
        List isGreenArr = FilteringApples.filterApples(inventory , FilteringApples::isGreenApple);
        System.out.println("green arr==>" + isGreenArr.size());
        List isHeavyArr = FilteringApples.filterApples(inventory,FilteringApples::isHeavyApple);
        System.out.println("heavy arr==>" + isHeavyArr.size());
    }


    @Test
    public void isGreenAppliLambdaTest(){
        System.out.println("ori arr==>" + inventory.size());
        List isGreenArr = FilteringApples.filterApples(inventory , (Apple a) -> "green".equals(a.getColor()));
        System.out.println("green lambda arr==>" + isGreenArr.size());
        List isHeavyArr = FilteringApples.filterApples(inventory,(Apple a) -> a.getWeight() > 150);
        System.out.println("heavy lambda arr==>" + isHeavyArr.size());
    }

    @Test
    public void isHeavyParalleTest(){
        List<Apple> heavyApples = this.inventory.parallelStream().filter((Apple a) -> a.getWeight() > 150).collect(Collectors.toList());
        System.out.println("dataSize=>" + heavyApples.size());
    }



}
