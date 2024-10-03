package add_excercise.management_powder_customer.model;

import java.time.LocalDate;

public class Invoice {
    private String idInvoice;
    private String idCustomer;
    private LocalDate invoiceDate;
    private Customer customer;
    private int usage;
    private double unitPrice;
    private double amount;
    public Invoice() {}
    public Invoice(String idInvoice, String idCustomer, LocalDate invoiceDate,Customer customer, int usage, double unitPrice) {
        this.idInvoice = idInvoice;
        this.idCustomer = idCustomer;
        this.invoiceDate = invoiceDate;
        this.customer = customer;
        this.usage = usage;
        this.unitPrice = unitPrice;
        this.getAmount();
    }
    public void getAmount() {
        if(customer instanceof DomesticCustomer){
            DomesticCustomer domesticCustomer = (DomesticCustomer)customer;
            if(usage<=domesticCustomer.getConsumption()){
                amount=unitPrice*usage;
            }else {
                int remainder =usage-domesticCustomer.getConsumption();
                amount =domesticCustomer.getConsumption()*unitPrice+remainder*unitPrice*2.5;
            }
        }
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "idInvoice='" + idInvoice + '\'' +
                ", idCustomer='" + idCustomer + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", customer=" + customer +
                ", usage=" + usage +
                ", unitPrice=" + unitPrice +
                ", amount=" + amount +
                '}';
    }
}
