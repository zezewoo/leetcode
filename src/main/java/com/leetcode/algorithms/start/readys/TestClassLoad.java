package com.leetcode.algorithms.start.readys;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestClassLoad {

    static {
        System.out.println("supper class loading..");
    }

    public static int val = 123;

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {

        ClassLoader classLoader = new ClassLoader() {

            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        };

    }

}



