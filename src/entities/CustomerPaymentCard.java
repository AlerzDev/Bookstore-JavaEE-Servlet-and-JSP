package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CustomerPaymentCard {

    @Id
    @GeneratedValue
    private long Id;
    @Column(length = 20)
    private long NumberCard;
    @Column(length = 45)
    private String DateExp;
    @Column(length = 11)
    private long CCV;
    private java.sql.Date RegDate;
    @Column(length = 11)
    private long Bank;
    @Column(length = 11)
    private long TypeCard;
    @Column(length = 11)
    private long CompanyCard;


    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }


    public long getNumberCard() {
        return NumberCard;
    }

    public void setNumberCard(long NumberCard) {
        this.NumberCard = NumberCard;
    }


    public String getDateExp() {
        return DateExp;
    }

    public void setDateExp(String DateExp) {
        this.DateExp = DateExp;
    }


    public long getCcv() {
        return CCV;
    }

    public void setCcv(long CCV) {
        this.CCV = CCV;
    }


    public java.sql.Date getRegDate() {
        return RegDate;
    }

    public void setRegDate(java.sql.Date RegDate) {
        this.RegDate = RegDate;
    }


    public long getBank() {
        return Bank;
    }

    public void setBank(long Bank) {
        this.Bank = Bank;
    }


    public long getTypeCard() {
        return TypeCard;
    }

    public void setTypeCard(long TypeCard) {
        this.TypeCard = TypeCard;
    }


    public long getCompanyCard() {
        return CompanyCard;
    }

    public void setCompanyCard(long CompanyCard) {
        this.CompanyCard = CompanyCard;
    }

}
