package strings;
import java.util.Scanner;
import java.text.DecimalFormat;
public class ConvertToUnits {
    static double[] kbUnit = {1000, 1024};
    static DecimalFormat formatInt = new DecimalFormat("###,##0");
    static DecimalFormat formatFloat = new DecimalFormat("###,##0.000");
    static String[][] units = {{"kB", "KiB"}, {"MB", "MiB"}, {"GB", "GiB"}, {"TB", "TiB"}, {"PB", "PiB"}, {"EB", "EiB"}};
    public static void main(String []args){
        System.out.println("Value to convert - ");
        Scanner sc=new Scanner(System.in);
        double value = sc.nextDouble();
        String unit = sc.next();
        double vByte = getByte(value, unit);
        System.out.println(String.format("\n%.3f ", value) + unit + " is " + formatInt.format(vByte) + " bytes\n");
        printAllUnit(vByte);
    }
    public static double getByte(double value, String unit) {
        unit = unit.toLowerCase();
        for(int j=0; j < 6; j++) {
            for(int i=0; i < 2; i++) {
                if(unit.equals(units[j][i].toLowerCase())) {
                    return value * Math.pow(kbUnit[i], j+1);
                }
            }
        }
        return value;
    }
    public static void printAllUnit(double vByte) {
        double vKB = vByte / kbUnit[0];
        String sKB = formatFloat.format(vKB);
        double vKiB = vByte / kbUnit[1];
        String sKiB = formatFloat.format(vKiB);
        int maxLeft = sKB.length();
        int maxRight = sKiB.length();
        System.out.println(getSpace(maxLeft-6) + "Metric" + getSpace(maxRight+2) + "IEC");
        System.out.println(getSpace(maxLeft-6) + "======" + getSpace(maxRight+2) + "===");
        System.out.println(sKB + " kB " + sKiB + " KiB");
        for(int j=1; j < 6; j++) {
            double vMB = vByte / Math.pow(kbUnit[0], j+1);
            String sMB = formatFloat.format(vMB);
            double vMiB = vByte / Math.pow(kbUnit[1], j+1);
            String sMiB = formatFloat.format(vMiB);
            System.out.println(getSpace(maxLeft-sMB.length()) + sMB + " " + units[j][0] + " " + getSpace(maxRight-sMiB.length()) + sMiB + " " + units[j][1]);
        }
    }
    public static String getSpace(int count) {
        String spaces = "";
        for(int i=0; i < count; i++) {
            spaces += " ";
        }
        return spaces;
    }
}
