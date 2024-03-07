package functional_trip;

/**
 * Represents a calculator for splitting the expenses on gas and parking
 */
class SplitTripCost {
	private final PriceComponent[] components;
	int participants;


	public SplitTripCost(PriceComponent millageCost, PriceComponent tollRoadCost, PriceComponent congestionCost,
						 PriceComponent parkingCost, int participants) {
		components = new PriceComponent[]{millageCost, tollRoadCost, congestionCost, parkingCost};
		this.participants = participants;
	}

	public double getTotalCost() {
		double cost = 0;
		for (PriceComponent component : components) {
			cost += component.getCost();
		}
		return cost;
	}

	public double getSingleParticipantCost() {
		return getTotalCost() / participants;
	}
}


