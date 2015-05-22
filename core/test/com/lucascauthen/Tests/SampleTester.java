package com.lucascauthen.Tests;

import com.lucascauthen.util.Tester;

import org.junit.Test;

import javax.inject.Inject;


public class SampleTester {
    Tester tester;
    @Test
    public void testLevelScreen() {
        tester = new Tester();
        assert true;
    }
}