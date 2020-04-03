package com.jvidalgz.calculator;


import org.springframework.stereotype.Service;

/** Calculator logic */
@Service
public class Calculator {

	public int sum(int a, int b) {
		return a + b;
	}
}