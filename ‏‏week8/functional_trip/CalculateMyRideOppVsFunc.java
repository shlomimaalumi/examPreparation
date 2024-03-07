package functional_trip;

import java.time.LocalTime;
import java.util.TreeMap;
@FunctionalInterface
interface PriceComponent {
	double getCost();

	static double freeRide() {
		return 0;
	}
}

class CalculateMyRideOppVsFunc {

	public static void main(String[] args) {
		initializeCongestionPricing();

		double km = 37,  fuelPrice = 8,fuelPerKm = 0.06;
		PriceComponent millageCost = ()->km*fuelPrice*fuelPerKm;

		double kmOnToll = 4, tollRoadFeePerKm = 6;
		PriceComponent tollRodeCost = ()->kmOnToll*tollRoadFeePerKm;

		LocalTime time = LocalTime.of(9, 4);
		PriceComponent congestionCost = ()->congestionPricing.floorEntry(time).getValue();

		double minutes = 186, costPerMinute = 0.2;
		boolean free = true;
		PriceComponent parking = ()-> free? PriceComponent.freeRide():minutes*costPerMinute;

		SplitTripCost calculator = new SplitTripCost(millageCost, tollRodeCost, congestionCost, parking, 3);

		System.out.printf("The total ride cost was: %.2f", calculator.getTotalCost());
		System.out.printf("Each participant owes the driver: %.2f", calculator.getSingleParticipantCost());
	}

	static final TreeMap<LocalTime, Double> congestionPricing = new TreeMap<>();
	private static void initializeCongestionPricing() {
		congestionPricing.put(LocalTime.of(6, 0), 4.);
		congestionPricing.put(LocalTime.of(7, 30), 14.);
		congestionPricing.put(LocalTime.of(9, 0), 10.);
		congestionPricing.put(LocalTime.of(12, 0), 0.);
		congestionPricing.put(LocalTime.of(15, 0), 16.);
		congestionPricing.put(LocalTime.of(18, 0), 0.);
	}

}





