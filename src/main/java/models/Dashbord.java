package models;

public class Dashbord {
  private   int years;
  private  int month;
    private  int total_amount;
    public Dashbord(){}

    public Dashbord(int years, int month, int total_amount) {
        this.years = years;
        this.month = month;
        this.total_amount = total_amount;
    }

    @Override
    public String toString() {
        return "Dashbord{" +
                "years=" + years +
                ", month=" + month +
                ", total_amount=" + total_amount +
                '}';
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }
}
