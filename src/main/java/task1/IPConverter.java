package task1;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IPConverter {

    private static final String IPV4_REGEX = "^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$";

    public static void main(String[] args) {
        int actionCode = 0;
        try (Scanner in = new Scanner(System.in)) {
            while(true) {
                showMenu();
                try {
                    actionCode = in.nextInt();
                    switch (actionCode) {
                        case 0:
                            return;
                        case 1:
                            System.out.print("String IpV4:\t");
                            String stringIpv4 = in.next();
                            if (!stringIpv4.matches(IPV4_REGEX)) {
                                System.out.println("Wrong format!");
                                continue;
                            }
                            Integer int32 = stringToInt32(stringIpv4);
                            System.out.println("Int value (signed):\t" + int32);
                            System.out.println("Int32 value (unsigned):\t" + Integer.toUnsignedString(int32));
                            break;
                        case 2:
                            System.out.print("Int32 value:\t");
                            String int32StringValue = in.next();
                            Integer int32Value = Integer.parseUnsignedInt(int32StringValue);
                            System.out.println("String IpV4:\t" + int32ToString(int32Value));
                            break;
                        default:
                            System.out.println("No such action.");
                    }
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Invalid input!");
                    in.next();
                    continue;
                }
            }
        }
    }

    private static int stringToInt32(String stringIpv4) {
        String[] quarters = stringIpv4.split("\\.");
        if (quarters.length != 4) {
            throw new InputMismatchException(); //todo own exception
        }
        Integer[] ints = new Integer[4];
        ints[0] = Integer.parseUnsignedInt(quarters[0]);
        ints[1] = Integer.parseUnsignedInt(quarters[1]);
        ints[2] = Integer.parseUnsignedInt(quarters[2]);
        ints[3] = Integer.parseUnsignedInt(quarters[3]);
        if (ints[0] > 255 || ints[1] > 255 || ints[2] > 255 || ints[3] > 255) {
            throw new NumberFormatException(); //todo own exception
        }
        ints[0] <<= 24;
        ints[1] <<= 16;
        ints[2] <<= 8;

        int int32Value = ints[0] + ints[1] + ints[2] + ints[3];
        return int32Value;
    }

    private static String int32ToString(Integer int32Value) {
        String binaryIpv4 = Integer.toBinaryString(int32Value);
        while (binaryIpv4.length() < 32) {
            binaryIpv4 = '0' + binaryIpv4;
        }
        String[] binaryStrings = new String[4];
        binaryStrings[0] = binaryIpv4.substring(0, 8);
        binaryStrings[1] = binaryIpv4.substring(9, 16);
        binaryStrings[2] = binaryIpv4.substring(17, 24);
        binaryStrings[3] = binaryIpv4.substring(25, 32);
        System.out.println("Binary:\t" + binaryStrings[0]
                + '.' + binaryStrings[1]
                + '.' + binaryStrings[2]
                + '.' + binaryStrings[3]);

        Integer[] ints = new Integer[4];
        ints[0] = Integer.parseUnsignedInt(binaryStrings[0], 2);
        ints[1] = Integer.parseUnsignedInt(binaryStrings[1], 2);
        ints[2] = Integer.parseUnsignedInt(binaryStrings[2], 2);
        ints[3] = Integer.parseUnsignedInt(binaryStrings[3], 2);

        return "" + ints[0] + '.' + ints[1] + '.' + ints[2] + '.' + ints[3];
    }

    private static void showMenu() {
        System.out.println("\nChoose action:");
        System.out.println("1 - string IpV4 to int32");
        System.out.println("2 - int32 to string IpV4");
        System.out.println("0 - exit");
    }
}
