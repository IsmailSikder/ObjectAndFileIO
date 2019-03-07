package obecj.IO;

public class Property {
	int id;
	String address;
	double purchasePrice;
	double rehabCost;
	double priceSold;
	double totalCost;
	double NetIncome;
	double taxes;
	double profitLoss;
	double percentGainLoss;
	
	Property(int iD, String address, double purchasePrice, double rehabCost, double priceSold){
		id = iD;
		this.address = address;
		this.purchasePrice = purchasePrice;
		this.priceSold = priceSold;
		this.rehabCost = rehabCost;
	}
	
	public int getID() {
		return id;
	}
	public void setID(int id){
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice){
		this.purchasePrice = purchasePrice;
	}
	
	public double getRehabCost() {
		return rehabCost;
	}
	public void setRehabCost(double rehabCost){
		this.rehabCost = rehabCost;
	}
	
	public double getPriceSold() {
		return priceSold;
	}
	public void setPriceSold(double priceSold){
		this.priceSold = priceSold;
	}

	public double getTotalCost(){
		return totalCost = purchasePrice+rehabCost;	
	}
	public double getNetIncome() {
		return NetIncome = priceSold -totalCost ;
	}

	public double getTaxes() {
		if(NetIncome<=0){
			return 0;
		}
		taxes= NetIncome*0.3;
		return Math.round(taxes);
	}

	public double getProfitLoss() {
		return profitLoss = NetIncome - taxes;
	}

	public double getPercentGainLoss() {
		 percentGainLoss = priceSold/totalCost;
		return Math.round(percentGainLoss);
	}

}
