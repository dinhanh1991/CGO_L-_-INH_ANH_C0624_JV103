package add_excercise.management_powder_customer.model;

import java.time.LocalDate;

public class Invoice {
    private String idInvoice;
    private String idCustomer;
    private LocalDate invoiceDate;
    private int usage;
    private double unitPrice;
    private double amount;
    public Invoice(String idInvoice,String idCustomer,LocalDate invoiceDate,
                   int usage, double unitPrice, double amount) {
        this.idInvoice = idInvoice;
        this.idCustomer = idCustomer;
        this.invoiceDate = invoiceDate;
        this.usage = usage;
        this.unitPrice = unitPrice;
        this.amount = amount;
    }

    public String getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(String idInvoice) {
        this.idInvoice = idInvoice;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String toString() {
        return "Invoice{" +
                "idInvoice='" + idInvoice + '\'' +
                ", idCustomer='" + idCustomer + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", usage=" + usage +
                ", unitPrice=" + unitPrice +
                ", amount=" + amount +
                '}';
    }
}
