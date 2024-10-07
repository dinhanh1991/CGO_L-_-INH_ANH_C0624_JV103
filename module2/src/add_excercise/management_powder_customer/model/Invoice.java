package add_excercise.management_powder_customer.model;

import java.time.LocalDate;

public class Invoice {
    private String idInvoice;
    private LocalDate invoiceDate;
    private Customer customer;
    private int usage;
    private double unitPrice;
    private double amount;
    public Invoice() {}
    public Invoice(String idInvoice, Customer customer, LocalDate invoiceDate, int usage, double unitPrice) {
        this.idInvoice = idInvoice;
        this.customer = customer;
        this.invoiceDate = invoiceDate;
        this.usage = usage;
        this.unitPrice = unitPrice;
        this.getAmount();
    }
    public double getAmount() {
        if(customer instanceof DomesticCustomer){
            DomesticCustomer domesticCustomer = (DomesticCustomer)customer;
            if(usage<=domesticCustomer.getConsumption()){
                amount=unitPrice*usage;
            }else {
                int remainder =usage-domesticCustomer.getConsumption();
                amount =domesticCustomer.getConsumption()*unitPrice+remainder*unitPrice*2.5;
            }
        } else if (customer instanceof InternationalCustomer) {
            amount=unitPrice*usage;
        }
        return amount;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "idInvoice='" + idInvoice + '\'' +
                ", idCustomer='" + customer.getId() + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", customer=" + customer +
                ", usage=" + usage +
                ", unitPrice=" + unitPrice +
                ", amount=" + amount +
                '}';
    }
}
