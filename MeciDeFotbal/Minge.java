package MeciDeFotbal;

public class Minge {
    private int pozitiaX;
    private int pozitiaY;

    public Minge(int pozitiaX, int pozitiaY) {
        this.pozitiaX = pozitiaX;
        this.pozitiaY = pozitiaY;
    }

    public int getPozitiaX() {
        return pozitiaX;
    }

    public void setPozitiaX(int pozitiaX) {
        this.pozitiaX = pozitiaX;
    }

    public int getPozitiaY() {
        return pozitiaY;
    }

    public void setPozitiaY(int pozitiaY) {
        this.pozitiaY = pozitiaY;
    }

    public void suteaza() throws OutException, GolException, CornerException {
        CoordinateGenerator coordinateGenerator = new CoordinateGenerator();
        int newX = coordinateGenerator.generateX();
        int newY = coordinateGenerator.generateY();
        setPozitiaX(newX);
        setPozitiaY(newY);
        if (newY == 0 || newY == 50) {
            throw new OutException("Ai iesit de pe teren.");
        } else {
            if ((newX == 0 || newX == 100) && (newY >= 20 && newY <= 30)) {
                throw new GolException("Ai dat gol.");
            } else {
                if ((newX == 0 || newX == 100) && ((0 < newY && newY < 20) || (30 < newY && newY < 50))) {
                    throw new CornerException("Ai intrat in colt.");
                }
            }
        }
    }
}
