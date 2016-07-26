package lintcode;

/**
 * Created by Nano on 2016/7/26.
 */
public class BinaryRepresentation {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public String binaryRepresentation(String n) {
        // write your code here
        if (n == null || n.length() == 0) return "";
        int dot = n.indexOf(".");
        if (dot == -1)
            return intToBinaryString(Integer.parseInt(n));
        int intPart = Integer.parseInt(n.substring(0, dot));
        double fractional = Double.parseDouble("0" + n.substring(dot));
        String fractionalString = fractionToBinaryString(fractional);
        if (fractionalString == null) return "ERROR";
        String intString = intToBinaryString(intPart);
        if (intString.equals("")) intString = "0";
        if (fractionalString.equals("")) return intString;
        return intString + "." + fractionalString;
    }

    private String intToBinaryString(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            if ((n & 1) == 1) sb.append(1);
            else sb.append(0);
            n >>= 1;
        }
        return sb.reverse().toString();
    }

    private String fractionToBinaryString(double n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            n *= 2;
            if (n >= 1) {
                sb.append(1);
                n -= 1;
            } else sb.append(0);
            if (sb.length() > 32) return null;
        }
        return sb.toString();
    }
}
