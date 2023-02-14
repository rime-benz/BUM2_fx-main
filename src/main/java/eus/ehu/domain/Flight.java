package eus.ehu.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Flight
 *
 * An object of this class represents an actual air link between two cities
 * The objects of the complementary class "Concrete Flight" represent actual
 * flights scheduled for this air link
 */
public class Flight {

	private String flightCode;
	private String departureCity;
	private String arrivalCity;
	private List<ConcreteFlight> concreteFlights;

	public Flight(String flightCode, String departureCity, String arrivalCity) {
		super();
		this.flightCode = flightCode;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.concreteFlights = new ArrayList<ConcreteFlight>();
	}


	public String getFlightCode() {
		return flightCode;
	}


	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}


	public String getDepartureCity() {
		return departureCity;
	}


	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}


	public String getArrivalCity() {
		return arrivalCity;
	}


	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}


	public void addConcreteFlight(ConcreteFlight conFl) {
		concreteFlights.add(conFl);
	}


	public ArrayList<ConcreteFlight> getConcreteFlights(Date date, String fare, int numSeats) {
		ArrayList<ConcreteFlight> lInDate = new ArrayList<ConcreteFlight>();
		for (ConcreteFlight cfl : concreteFlights) {
			if (date.equals(cfl.getDate()))
			switch (fare)
			{
				case "First":
					if (cfl.getFreeFirstSeatNo()>=numSeats){
						lInDate.add(cfl);
					}
					break;
				case "Economy":
					if (cfl.getFreeEconomySeatNo()>=numSeats){
						lInDate.add(cfl);
					}
					break;

				default:
					if (cfl.getFreeBusinessSeatNo()>=numSeats){
						lInDate.add(cfl);
					}

			}
		}

		return lInDate;
	}


	public void setConcreteFlights(List<ConcreteFlight> concreteFlights) {
		this.concreteFlights = concreteFlights;
	}


	public String toString() {
		return flightCode + ": " + departureCity + " -> " + arrivalCity;
	}

}
