package com.hdfcapp.test;

public class Test {
public static void main(String args[]){
	String balanceWithString = "Available Balance11,536.98";
	String[] str = balanceWithString.split(".");
	String onlyBalance = str[0].replaceAll("[^0-9]", "");
	System.out.println(onlyBalance);
}
}
