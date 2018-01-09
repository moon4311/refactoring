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

		/*  switch���� ���ڴ� �ڽ��� �����͸� ����ؾ� �Ѵ�.
		 *  Movie Ŭ������ �̵�
		double result = 0;
		//���� ������ �뿩�� ���
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
		 * //�ֽŹ��� ��Ʋ �̻� �뿩�ϸ� ���ʽ� ����Ʈ ����
		if((getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
			get_daysRented() > 1) 
			return 2;
		else
			return 1;
		*/
		return _movie.getFrequentRenterPoints(_daysRented);
	}
	
}
