package MeciDeFotbal;

public class Joc {
    private String numeEchipa1;
    private String numeEchipa2;
    private int numarulDeGoluriCorespunzatorEchipei1;
    private int numarulDeGoluriCorespunzatorEchipei2;

    private int numarulTotalDeOutUriPeIntregulMeci;
    private int numarulTotalDeCornerePeIntregulMeci;

    public Joc(String numeEchipa1, String numeEchipa2) {
        this.numeEchipa1 = numeEchipa1;
        this.numeEchipa2 = numeEchipa2;
    }

    public String getNumeEchipa1() {
        return numeEchipa1;
    }

    public void setNumeEchipa1(String numeEchipa1) {
        this.numeEchipa1 = numeEchipa1;
    }

    public String getNumeEchipa2() {
        return numeEchipa2;
    }

    public void setNumeEchipa2(String numeEchipa2) {
        this.numeEchipa2 = numeEchipa2;
    }

    public int getNumarulDeGoluriCorespunzatorEchipei1() {
        return numarulDeGoluriCorespunzatorEchipei1;
    }

    public void setNumarulDeGoluriCorespunzatorEchipei1(int numarulDeGoluriCorespunzatorEchipei1) {
        this.numarulDeGoluriCorespunzatorEchipei1 = numarulDeGoluriCorespunzatorEchipei1;
    }

    public int getNumarulDeGoluriCorespunzatorEchipei2() {
        return numarulDeGoluriCorespunzatorEchipei2;
    }

    public void setNumarulDeGoluriCorespunzatorEchipei2(int numarulDeGoluriCorespunzatorEchipei2) {
        this.numarulDeGoluriCorespunzatorEchipei2 = numarulDeGoluriCorespunzatorEchipei2;
    }

    public int getNumarulTotalDeOutUriPeIntregulMeci() {
        return numarulTotalDeOutUriPeIntregulMeci;
    }

    public void setNumarulTotalDeOutUriPeIntregulMeci(int numarulTotalDeOutUriPeIntregulMeci) {
        this.numarulTotalDeOutUriPeIntregulMeci = numarulTotalDeOutUriPeIntregulMeci;
    }

    public int getNumarulTotalDeCornerePeIntregulMeci() {
        return numarulTotalDeCornerePeIntregulMeci;
    }

    public void setNumarulTotalDeCornerePeIntregulMeci(int numarulTotalDeCornerePeIntregulMeci) {
        this.numarulTotalDeCornerePeIntregulMeci = numarulTotalDeCornerePeIntregulMeci;
    }

    public void simuleaza() {
        Minge minge = new Minge(50, 25);
        System.out.println(numeEchipa1 + " - " + numeEchipa2 + ": Mingea se afla la coordonatele initiale ("
                + minge.getPozitiaX() + "," + minge.getPozitiaY() + ").");
        for (int i = 0; i < 1000; i++) {
            try {
                minge.suteaza();
                System.out.println(numeEchipa1 + " - " + numeEchipa2 + ": Mingea se afla la coordonaltele ("
                        + minge.getPozitiaX() + "," + minge.getPozitiaY() + ").");
            } catch (GolException e) {
                int oldX = minge.getPozitiaX();
                if (oldX == 0) {
                    numarulDeGoluriCorespunzatorEchipei1++;
                } else {
                    numarulDeGoluriCorespunzatorEchipei2++;
                }
                minge = new Minge(50, 25);
            } catch (OutException e) {
                numarulTotalDeOutUriPeIntregulMeci++;
                int oldX = minge.getPozitiaX();
                int oldY = minge.getPozitiaY();
                minge = new Minge(oldX, oldY);
            } catch (CornerException e) {
                numarulTotalDeCornerePeIntregulMeci++;
                int oldX = minge.getPozitiaX();
                int oldY = minge.getPozitiaY();
                int newY = 0;
                if (30 < oldY && oldY < 50) {
                    newY = 50;
                }
                minge = new Minge(oldX, newY);
            }
        }
    }

    @Override
    public String toString() {
        return "numele echipei 1: " + numeEchipa1 + "\nnumele echipei 2: " + numeEchipa2 + "\nscorul: "
                + numarulDeGoluriCorespunzatorEchipei1 + " la " + numarulDeGoluriCorespunzatorEchipei2
                + "\nstatisticile descrise: " + numarulTotalDeOutUriPeIntregulMeci + " outuri pe intregul meci si "
                + numarulTotalDeCornerePeIntregulMeci + " cornere pe intregul meci";
    }

}
