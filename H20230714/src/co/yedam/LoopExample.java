package co.yedam;

public class LoopExample {
	
	static int 돈[] = {50000, 10000, 5000, 1000, 500, 100};
	static int 오만원 = 0;
	static int 만원 = 0;
	static int 오천원 = 0;
	static int 천원 = 0;
	static int 오백원 = 0;
	static int 백원 = 0;
	static int 개수[] = {오만원, 만원, 오천원, 천원, 오백원, 백원};
	static int 거스름돈 = 0;
	
	public static void main(String[] args) {
		// 76800원 > 5만원:1장, 만원:2장, 5천원:1장, 천원:1장, 500원:1개, 100원:3개
		Money(77760);
	} // end of main
	
	public static void Money(int money) {
		거스름돈 = money;
		for(int i=0; i<돈.length; i++) {
			
			개수[i] = 거스름돈/돈[i];
			거스름돈 -= 개수[i]*돈[i];
			
			if(i == 돈.length - 1) {
				System.out.printf("%d원은 오만원권: %d장, 만원권: %d장, 오천원권: %d장, 천원권: %d장, 오백원: %d개, 백원: %d개, 거스름돈: %d원",
						money, 개수[0], 개수[1], 개수[2], 개수[3], 개수[4], 개수[5], 거스름돈);
			}
		}
	} // end of Money()
}
