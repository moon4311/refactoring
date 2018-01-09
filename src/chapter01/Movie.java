package chapter01;

public class Movie {

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private String _title;
	private Price _price;
	
	public Movie(String title, int priceCode){
		_title = title;
//		_priceCode = priceCode;
		setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return _price.getPriceCode();
	}

	public void setPriceCode(int _priceCode) {
		
		switch(_priceCode){
		case REGULAR:
			_price = new RegularPrice();
			break;
		case CHILDRENS:
			_price = new ChildrensPrice();
			break;
		case NEW_RELEASE:
			_price = new NewReleasePrice();
			break;
			
		default:
			throw new IllegalArgumentException("가격 코드가 잘못 됐습니다.");
		}
	}
	
	
	public String getTitle(){
		return _title;
	}
	
	double getCharge(int daysRented){
/*		double result = 0;
		//비디오 종류별 대여료 계산
		switch (getPriceCode()){
		case Movie.REGULAR:
			result += 2;
			if(daysRented > 2){
				result += (daysRented -2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			result += daysRented * 3;
			break;
		case Movie.CHILDRENS:
			result +=1.5;
			if(daysRented > 3)
				result += (daysRented-3) * 1.5;
			break;
	
		}
		return result;*/
		return _price.getCharge(daysRented);
	}

	
	int getFrequentRenterPoints(int daysRented){
/*	//최신물을 이틀 이상 대여하면 보너스 포인트 지급
			if((_price.getPriceCode() == Movie.NEW_RELEASE) &&
				daysRented > 1) 
				return 2;
			else
				return 1;*/
		return _price.getFrequentRenterPoints(daysRented);
	}
}
