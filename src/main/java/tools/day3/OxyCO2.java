package tools.day3;

public class OxyCO2 {
    int Oxy;
    int CO2;

    public OxyCO2(String oxy, String co2) {
        setOxyCO2(oxy, co2);
    }


    public void setOxyCO2(String oxy, String co2) {
        Oxy = Integer.parseInt(oxy, 2);
        CO2 = Integer.parseInt(co2, 2);
    }

    public String toString() {
        return "Oxy : " + Oxy + " ,CO2 : " + CO2;
    }

    public int result() {
        return Oxy * CO2;
    }
}
