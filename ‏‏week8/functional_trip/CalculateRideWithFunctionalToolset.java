//package functional_trip;
//
//import java.time.LocalTime;
//import java.util.TreeMap;
//
//class CalculateRideWithFunctionalToolset {
//	static final TreeMap<LocalTime, Double> congestionPricing = new TreeMap<>();
//
//	private static void initializeCongestionPricing() {
//		congestionPricing.put(LocalTime.of(6, 0), 4.);
//		congestionPricing.put(LocalTime.of(7, 30), 14.);
//		congestionPricing.put(LocalTime.of(9, 0), 10.);
//		congestionPricing.put(LocalTime.of(12, 0), 0.);
//		congestionPricing.put(LocalTime.of(15, 0), 16.);
//		congestionPricing.put(LocalTime.of(18, 0), 0.);
//	}
//
//	public static void main(String[] args) {
//		initializeCongestionPricing();
//
//		double literPerKm = 0.06, km = 37, shekelPerLiter = 8;
//		PriceComponent millageCost = () -> literPerKm * km * shekelPerLiter;
//
//		double kmOnToll = 4, shekelPerKm = 6;
//		PriceComponent tollRoadCost = () -> kmOnToll * shekelPerKm;
//
//		LocalTime time = LocalTime.of(9, 4);
//		PriceComponent congestionCost = () -> congestionPricing.floorEntry(time).getValue();
//
//		boolean free = true;
//		double minutes = 186, costPerMinute = 0.2;
//		PriceComponent parking = () -> free ? PriceComponent.freeRide() : minutes * costPerMinute;
//
//		SplitTripCost calc = new SplitTripCost(millageCost, tollRoadCost, congestionCost, parking, 3);
//
//		System.out.printf("The total Ride cost was: %.2f", calc.getTotalCost());
//		System.out.printf("Each participant ows he driver: %.2f", calc.getSingleParticipantCost());
//	}
//}
//
//
//final class CongestionPricing {
//}