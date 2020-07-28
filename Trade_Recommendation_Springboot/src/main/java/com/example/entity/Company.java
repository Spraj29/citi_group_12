package com.example.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Company {
	@Id
	@GeneratedValue
	String symbol;
	Long marketCap;
	Double forwardPE;
	Double bookValue;
	Double priceToBook;
	Double trailingEps;
	Double forwardEps;
	Double pegRatio;
	Double lastDividendValue;
	String companyName;
	Double regularMarketPrice;
	public Company()
	{
		
	}
	public Company(String symbol, Long marketCap, Double forwardPE, Double bookValue, Double priceToBook,
			Double trailingEps, Double forwardEps, Double pegRatio, Double lastDividendValue, String companyName,
			Double regularMarketPrice) {
		super();
		this.symbol = symbol;
		this.marketCap = marketCap;
		this.forwardPE = forwardPE;
		this.bookValue = bookValue;
		this.priceToBook = priceToBook;
		this.trailingEps = trailingEps;
		this.forwardEps = forwardEps;
		this.pegRatio = pegRatio;
		this.lastDividendValue = lastDividendValue;
		this.companyName = companyName;
		this.regularMarketPrice = regularMarketPrice;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Long getMarketCap() {
		return marketCap;
	}
	public void setMarketCap(Long marketCap) {
		this.marketCap = marketCap;
	}
	public Double getForwardPE() {
		return forwardPE;
	}
	public void setForwardPE(Double forwardPE) {
		this.forwardPE = forwardPE;
	}
	public Double getBookValue() {
		return bookValue;
	}
	public void setBookValue(Double bookValue) {
		this.bookValue = bookValue;
	}
	public Double getPriceToBook() {
		return priceToBook;
	}
	public void setPriceToBook(Double priceToBook) {
		this.priceToBook = priceToBook;
	}
	public Double getTrailingEps() {
		return trailingEps;
	}
	public void setTrailingEps(Double trailingEps) {
		this.trailingEps = trailingEps;
	}
	public Double getForwardEps() {
		return forwardEps;
	}
	public void setForwardEps(Double forwardEps) {
		this.forwardEps = forwardEps;
	}
	public Double getPegRatio() {
		return pegRatio;
	}
	public void setPegRatio(Double pegRatio) {
		this.pegRatio = pegRatio;
	}
	public Double getLastDividendValue() {
		return lastDividendValue;
	}
	public void setLastDividendValue(Double lastDividendValue) {
		this.lastDividendValue = lastDividendValue;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Double getRegularMarketPrice() {
		return regularMarketPrice;
	}
	public void setRegularMarketPrice(Double regularMarketPrice) {
		this.regularMarketPrice = regularMarketPrice;
	}
	

}
