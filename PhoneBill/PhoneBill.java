package Shapes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PhoneBill {

    String billString;
    private final int FIVE_MINUTES = 300;

    public PhoneBill(String billString) {
        this.billString = billString;
    }

    public int calculateBill() {
        String[] billArray = billString.split("\n");
        String longestCallNum = findLongestCall(billArray);
        return addUpBill(billArray, longestCallNum);
    }

    private int addUpBill(String[] billArray, String longestCallNum) {
        int billTotal = 0;

        for(String billString : billArray) {
            String[] oneLine = billString.split(",");
            if(!oneLine[1].equals(longestCallNum)) {
                int totalSeconds = getCallLenSec(oneLine[0]);
                if(totalSeconds < FIVE_MINUTES) {
                    billTotal += (totalSeconds * 3);
                } else {
                    billTotal += ((totalSeconds/60) * 150);
                    if(totalSeconds%60 > 0) {
                        billTotal += 150;
                    }
                }
            }
        }

        return billTotal;
    }

    public String findLongestCall(String[] billArray) {
        HashMap<String, Integer> callMap = new HashMap<String, Integer>();
        String maxPhoneNum = "999-999-9999";
        int longestCall = 0;

        for(String billLine : billArray) {
            String[] oneLine = billLine.split(",");
            Integer tempCallLen = getCallLenSec(oneLine[0]);

            callMap.putIfAbsent(oneLine[1], 0);
            callMap.replace(oneLine[1], callMap.get(oneLine[1]) + tempCallLen);
        }

        for(String phoneNumber : callMap.keySet()) {
            int tempLongestCall = callMap.get(phoneNumber);
            if(tempLongestCall > longestCall || (tempLongestCall == longestCall && (phoneNumber.compareTo(maxPhoneNum) < 0))) {
                maxPhoneNum = phoneNumber;
                longestCall = tempLongestCall;
            }
        }

        return(maxPhoneNum);
    }

    private Integer getCallLenSec(String s) {
        String[] callLenArray = s.split(":");
        return (Integer.parseInt(callLenArray[0]) * 3600) + (Integer.parseInt(callLenArray[1]) * 60) + (Integer.parseInt(callLenArray[2]));
    }
}
