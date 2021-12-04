package tools.day3;

public class GammaEpsilon {
    public GammaEpsilon(String gamma, String epsilon) {
        setGammaEpsilon(gamma, epsilon);
    }

    int Gamma;
    int Epsilon;

    public void setGammaEpsilon(String gamma, String epsilon){
        Gamma = Integer.parseInt(gamma);
        Epsilon = Integer.parseInt(epsilon);
    }
    @Override
    public String toString() {
        return "Gamma : " + Gamma + " ,Epsilon : " + Epsilon;
    }

    public int result() {
        return Gamma * Epsilon;
    }

}