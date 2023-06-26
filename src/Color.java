public class Color {
    private int red;
    private int green;
    private int blue;
    private String hexValue;

    public Color(int red, int green, int blue) {
        if (red > 255 || red < 0 || green > 255 || green < 0 || blue > 255 || blue < 0) {
            throw new IllegalArgumentException();
        }
        this.red = red;
        this.green = green;
        this.blue = blue;

        updateHexCode();
    }

    public Color(String hexValue) {
        if (!hexValue.matches("^#[0-9A-F]{6}$")){
            throw new IllegalArgumentException();
        }
        this.hexValue = hexValue;

        updateRGB();
    }

    @Override
    public String toString() {
        return String.format("[value=%s, r=%d, g=%d, b=%d]", hexValue, red, green, blue);
    }

    public String getHexValue() {
        return this.hexValue;
    }

    public void setHexValue(String hexValue) {
        if (hexValue == null || hexValue.length() == 0){
            throw new NullPointerException();
        }
        if (!hexValue.matches("^#[0-9A-F]{6}$")){
            throw new IllegalArgumentException();
        }
        this.hexValue = hexValue;
        updateRGB();
    }

    public int getRed() {
        return this.red;
    }

    public void setRed(int red) {
        if (red > 255 || red < 0) {
            throw new IllegalArgumentException();
        }
        this.red = red;
        updateHexCode();
    }

    public int getGreen() {
        return this.green;
    }

    public void setGreen(int green) {
        if (green > 255 || green < 0) {
            throw new IllegalArgumentException();
        }
        this.green = green;
        updateHexCode();
    }

    public int getBlue() {
        return this.blue;
    }

    public void setBlue(int blue) {
        if (blue > 255 || blue < 0) {
            throw new IllegalArgumentException();
        }
        this.blue = blue;
        updateHexCode();
    }

    private void updateHexCode() {
        String redHex = Integer.toHexString(this.red);
        String greenHex = Integer.toHexString(this.green);
        String blueHex = Integer.toHexString(this.blue);
        String hexValue = "#".concat(redHex).concat(greenHex).concat(blueHex);
        this.hexValue = hexValue.toUpperCase();
    }

    private void updateRGB() {
        String hexValueWithoutHash = hexValue.substring(1);
        String redHex = hexValueWithoutHash.substring(0,2);
        this.red = Integer.parseInt(redHex, 16);

        String greenHex = hexValueWithoutHash.substring(2,4);
        this.green = Integer.parseInt(greenHex, 16);

        String blueHex = hexValueWithoutHash.substring(4,6);
        this.blue = Integer.parseInt(blueHex, 16);
    }

}