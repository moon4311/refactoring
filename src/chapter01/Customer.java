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
		String result = getName() + "���� �뿩 ��� \n";
		while(rentals.hasMoreElements()){
			Rental each = (Rental) rentals.nextElement();
			
			/*
			 //���� ������ �뿩�� ���
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
			//���� ����Ʈ�� 1 ����Ʈ ����
			frequentRenterPoints ++;
			//�ֽŹ��� ��Ʋ �̻� �뿩�ϸ� ���ʽ� ����Ʈ ����
			if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
				each.get_daysRented() > 1) frequentRenterPoints++;
				*/
			
			//�̹��� �뿩�ϴ� ���� ������ �뿩�� ���
			result += "\t" + each.getMovie().getTitle()+ "\t"+ String.valueOf(each.getCharge()) + "\n";
			//������� ������ �� �뿩��
//			totalAmount += each.getCharge();
		}
		result += "���� �뿩�� : " + String.valueOf(getTotalCharge()) + '\n';
		result += "���� ����Ʈ : " + String.valueOf(getTotalFrequentRenterPoints());
		
		return result; 
	}
	
	
	/*
	private double amountFor(Rental aRental){
		double result = 0;
		//���� ������ �뿩�� ���
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
		String result = "<H1><EM>" + getName() + " ������ �뿩 ��� </EM></H1><P>\n";
		while (rentals.hasMoreElements()){
			Rental each = (Rental) rentals.nextElement();
			
			result += each.getMovie().getTitle()+ ": "+
			String.valueOf(each.getCharge()) +"<BR>\n";
			
		}
		
		result += "<P> ���� �뿩��: <EM>" + String.valueOf(getTotalCharge()) + "</EM></P>\n";
		result += "<P> ���� ����Ʈ: <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM></P>\n";
		return result;
	}
}
