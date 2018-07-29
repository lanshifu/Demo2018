package com.example.module_demo;

import com.example.module_demo.design_mode.ObserverTest;
import com.example.module_demo.suanfa.leetcode.easy.LeetCodeEasy;
import com.example.module_demo.suanfa.Sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        Sort sort = new Sort();
        sort.test();

        LeetCodeEasy leetCode = new LeetCodeEasy();
        leetCode.test();

        ObserverTest observerTest = new ObserverTest();
        observerTest.test();

        assertEquals(4, 2 + 2);

    }

}