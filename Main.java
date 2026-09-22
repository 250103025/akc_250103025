import java.util.List;

interface SmartDevice {
    void turnOn();
    void turnOff();
    boolean isOn();
    int getPowerPercent(); // Standard range: 0 to 100
}
class LegacyBulb {
    private int brightnessLevel = 0; // Raw range: 0 to 255
    private boolean filamentConnected = true;
    public void setBrightness(int level) {
        if (level < 0) this.brightnessLevel = 0;
        else if (level > 255) this.brightnessLevel = 255;
        else this.brightnessLevel = level;
    }
    public int readBrightness() {
        return this.brightnessLevel;
    }
    public void breakFilament() {
        this.filamentConnected = false;
    }
    public boolean hasPower() {
        return this.filamentConnected && (this.brightnessLevel > 0);
    }
}
class LegacyThermostat {
    // Valid dial states: "IDLE", "LOW", "MEDIUM", "MAX"
    private String dialPosition = "IDLE";
    public void rotateDial(String position) {
        this.dialPosition = position;
    }
    public String checkDial() {
        return this.dialPosition;
    }
}
class ModernHub {
    private final List<SmartDevice> devices;
    public ModernHub(List<SmartDevice> devices) {
        this.devices = devices;
    }
class BulbAdapter implements SmartDevice{
    private static final int K=4;
    private final LegacyBulb bulb;
    public BulbAdapter (LegacyBulb bulb) {
        if (bulb == null) {
            throw new IllegalArgumentException("LegacyBulb must not be null");
        }
        this.bulb = bulb;
    }
    @Override
    public void turnOn(){
        bulb.setBrightness(255);
    }
    @Override
    public void turnOff(){
        bulb.setBrightness(0);
    }
    @Override
    public boolean isOn(){
        if (!bulb.hasPower()) return False;
        return bulb.readBrightness() > 0;
    }
    @Override
    public int getPowerPercent() {
        int raw = bulb.readBrightness();
        if (raw == 0) return 0;
        if (!bulb.hasPower()) return 0;

        int rawPercent = (int) Math.floor((raw * 100.0) / 255.0);
        int calibrated = rawPercent + K;
        return Math.min(calibrated, 100);
}


public class Main {
public static void main(String[] args) {

        }
    }
}