package io.demo.jsp;

import java.math.BigDecimal;

public class calculator {

	private String firstNum="0";
	private String SecondNum="0";
	private String operator="+";
	private String result="0";
	public String getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(String firstNum) {
		this.firstNum = firstNum;
	}
	public String getSecondNum() {
		return SecondNum;
	}
	public void setSecondNum(String secondNum) {
		SecondNum = secondNum;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String calculate() {
		
		BigDecimal a = new BigDecimal(firstNum);
		BigDecimal b = new BigDecimal(SecondNum);
		
		switch (operator) {
		case "+":
			result = a.add(b).toString();
			break;

		case "-":
			result = a.subtract(b).toString();
			break;
			
		case "*":
			result = a.multiply(b).toString();
			break;
			
		case "/":
			if (SecondNum.equals("0")) {
				throw new RuntimeException("Divider can not be 0..");
			}
			result = a.divide(b, 6, BigDecimal.ROUND_HALF_UP).toString();
			break;

		default:
			break;
		}
		
		return result;
	}
}
