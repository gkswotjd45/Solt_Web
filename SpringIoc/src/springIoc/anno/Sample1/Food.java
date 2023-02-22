package springIoc.anno.Sample1;

public class Food {
	private String foodName;
	private String foodPrice;

	public Food() {
		System.out.println("food 의 default 생성자");
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
		System.out.println("setFoodName의 setter 호출");
	}

	public void setFoodPrice(String foodPrice) {
		this.foodPrice = foodPrice;
		System.out.println("setFoodPrice의 setter 호출");
	}

	@Override
	public String toString() {
		return foodName + "," + foodPrice;
	}
}
