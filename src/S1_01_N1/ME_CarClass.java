package S1_01_N1;

import java.io.Serializable;

public class ME_CarClass implements Serializable {
    private String nameCar;
    private int cv;

    public ME_CarClass(String nameCar, int cv) {
        this.nameCar = nameCar;
        this.cv = cv;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }
}
