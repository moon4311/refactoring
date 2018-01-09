package chapter01;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String _name;
	private Vector _rentals = new Vector();
	
	
	public Customer(String _name, Vector _rentals) {
		super();
		this._name = _name;
		this._rentals = _rentals;
	}


	public String getName() {
		return _name;
	}
	
	
	public void addRental(Rental arg){
		_rentals.addElement(arg);
	}
	
	
	public String statement(){
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = getName() + "고객님 대여 기록 \n";
		while(rentals.hasMoreElements()){
			Rental each = (Rental) rentals.nextElement();
			
			/*
			 //비디오 종류별 대여료 계산
			switch (each.getMovie().getPriceCode()){
			case Movie.REGULAR:
				thisAmount += 2;
				if(each.get_daysRented() > 2 ){
					thisAmount += (each.get_daysRented() -2) * 1.5;
				}
				break;
			case Movie.NEW_RELEASE:
				thisAmount += each.get_daysRented() * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount +=1.5;
				if(each.get_daysRented() > 3)
					thisAmount += (each.get_daysRented()-3) * 1.5;
				break;
		
			}*/
			
			
			frequentRenterPoints += each.getFrequentRenterPoints();
			/*			
			//적립 포인트를 1 포인트 증가
			frequentRenterPoints ++;
			//최신물을 이틀 이상 대여하면 보너스 포인트 지급
			if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
				each.get_daysRented() > 1) frequentRenterPoints++;
				*/
			
			//이번에 대여하는 비디오 정보와 대여료 출력
			result += "\t" + each.getMovie().getTitle()+ "\t"+ String.valueOf(each.getCharge()) + "\n";
			//현재까지 누적된 총 대여료
//			totalAmount += each.getCharge();
		}
		result += "누적 대여료 : " + String.valueOf(getTotalCharge()) + '\n';
		result += "적립 포인트 : " + String.valueOf(getTotalFrequentRenterPoints());
		
		return result; 
	}
	
	
	/*
	private double amountFor(Rental aRental){
		double result = 0;
		//비디오 종류별 대여료 계산
		switch (aRental.getMovie().getPriceCode()){
		case Movie.REGULAR:
			result += 2;
			if(aRental.get_daysRented() > 2 ){
				result += (aRental.get_daysRented() -2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			result += aRental.get_daysRented() * 3;
			break;
		case Movie.CHILDRENS:
			result +=1.5;
			if(aRental.get_daysRented() > 3)
				result += (aRental.get_daysRented()-3) * 1.5;
			break;
	
		}
		
		return result;
	}*/
	
	private double getTotalCharge(){
		double result = 0;
		Enumeration rentals = _rentals.elements();
		
		while (rentals.hasMoreElements() ){
			Rental each = (Rental) rentals.nextElement();
			result += each.getCharge();
			
		}
		return result;
	}
	
	private int getTotalFrequentRenterPoints(){
		int result =0;
		Enumeration rentals = _rentals.elements();
		while (rentals.hasMoreElements()){
			Rental each = (Rental) rentals.nextElement();
			result += each.getFrequentRenterPoints();
		}
		return result;
	}
	
	
	public String htmlStatement(){
		Enumeration rentals = _rentals.elements();
		String result = "<H1><EM>" + getName() + " 고객님의 대여 기록 </EM></H1><P>\n";
		while (rentals.hasMoreElements()){
			Rental each = (Rental) rentals.nextElement();
			
			result += each.getMovie().getTitle()+ ": "+
			String.valueOf(each.getCharge()) +"<BR>\n";
			
		}
		
		result += "<P> 누적 대여로: <EM>" + String.valueOf(getTotalCharge()) + "</EM></P>\n";
		result += "<P> 적립 포인트: <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM></P>\n";
		return result;
	}
}
