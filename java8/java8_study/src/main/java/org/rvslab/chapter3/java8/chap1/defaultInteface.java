package org.rvslab.chapter3.java8.chap1;

import java.util.Collections;

public interface defaultInteface {

    //상속을 하는 클래스에서 재구현 할 필요가 없다.
    default void sort(){
        System.out.println();
    }

}
