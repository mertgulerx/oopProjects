public class Data implements Comparable<Data>{
    private String countryName;
    private String gender;
    private int year;
    private float rate;

    public Data(String countryName, String gender, int year, float rate){
        this.countryName = countryName;
        this.gender = gender;
        this.year = year;
        this.rate = rate;
    }

    public float getRate(){
        return rate;
    }

    @Override
    public int compareTo(Data otherData){
        return Float.compare(rate, otherData.rate);
    }

    @Override
    public String toString(){
        return countryName + " (" + year + "), " + gender + ", " + rate;
    }
}
