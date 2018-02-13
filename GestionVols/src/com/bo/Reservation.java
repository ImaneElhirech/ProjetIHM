package com.bo;

public class Reservation {
	
	int IdRes;
	String DateDepart;
	String DateArrivee;
	public int getIdRes() {
		return IdRes;
	}
	public void setIdRes(int idRes) {
		IdRes = idRes;
	}
	public String getDateDepart() {
		return DateDepart;
	}
	public void setDateDepart(String dateDepart) {
		DateDepart = dateDepart;
	}
	public String getDateArrivee() {
		return DateArrivee;
	}
	public void setDateArrivee(String dateArrivee) {
		DateArrivee = dateArrivee;
	}
	public String toString() {
		return "resrvation [IdRes=" + IdRes + ", DateDepart=" + DateDepart + ", DateArrivee=" + DateArrivee + "]";
	}
	

}


