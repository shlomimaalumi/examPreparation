//package functional_trip;
//
//import java.time.LocalTime;
//import java.util.TreeMap;
//
//class CalculateMyRideStrictlyUsingOOP {
//	public static void main(String[] args) {
//		MillageCost millageCost = new MillageCost();
//		TollRoadCost tollRodeCost = new TollRoadCost();
//		CongestionCost congestionCost = new CongestionCost();
//		ParkingCost parking = new ParkingCost();
//
//		SplitTripCost calculator = new SplitTripCost(millageCost, tollRodeCost, congestionCost, parking, 3);
//
//		System.out.printf("The total ride cost was: %.2f", calculator.getTotalCost());
//		System.out.printf("Each participant owes the driver: %.2f", calculator.getSingleParticipantCost());
//	}
//}
//
//class MillageCost implements PriceComponent {
//	double km;
//	double fuelPrice;
//	double fuelPerKm;
//
//	public double getCost() {
//		return fuelPerKm * km * fuelPrice;
//	}
//}
//
//
//class TollRoadCost implements PriceComponent {
//	double km;
//	double tollRoadFeePerKm;
//
//	public double getCost() {
//		return km * tollRoadFeePerKm;
//	}
//}
//
//
//class CongestionCost implements PriceComponent {
//	LocalTime time;
//	TreeMap<LocalTime, Double> costPerEntrance;
//
//	public double getCost() {
//		return costPerEntrance.floorEntry(time).getValue();
//	}
//}
//
//class ParkingCost implements PriceComponent {
//	double minutes;
//	double costPerMinute;
//	boolean free;
//
//	@Override
//	public double getCost() {
//		if (free) {
//			return PriceComponent.freeRide();
//		}
//		return minutes * costPerMinute;
//	}
//}
//
//
//
//
