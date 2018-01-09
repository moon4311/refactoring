package chapter01;

public class Rental {
	private Movie _movie;
	private int _daysRented;
	
	
	public Rental(Movie _movie, int _daysRented) {
		super();
		this._movie = _movie;
		this._daysRented = _daysRented;
	}


	public Movie getMovie() {
		return _movie;
	}


	public int get_daysRented() {
		return _daysRented;
	}

	double getCharge(){

		/*  switch문의 인자는 자신의 데이터를 사용해야 한다.
		 *  Movie 클래스로 이동
		double result = 0;
		//비디오 종류별 대여료 계산
		switch (getMovie().getPriceCode()){
		case Movie.REGULAR:
			result += 2;
			if(get_daysRented() > 2){
				result += (get_daysRented() -2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			result += get_daysRented() * 3;
			break;
		case Movie.CHILDRENS:
			result +=1.5;
			if(get_daysRented() > 3)
				result += (get_daysRented()-3) * 1.5;
			break;
	
		}
		return result;
		*/
		return _movie.getCharge(_daysRented);
	}
	
	
	
	int getFrequentRenterPoints(){
		/*
		 * //최신물을 이틀 이상 대여하면 보너스 포인트 지급
		if((getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
			get_daysRented() > 1) 
			return 2;
		else
			return 1;
		*/
		return _movie.getFrequentRenterPoints(_daysRented);
	}
	
}
