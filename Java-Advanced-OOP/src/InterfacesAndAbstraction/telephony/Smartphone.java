package telephony;

import telephony.Browsable;
import telephony.Callable;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    private boolean isValidURL(String url) {
        for (Character singleChar : url.toCharArray()) {
            if (Character.isDigit(singleChar)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidNumber(String number) {
        for (Character singleChar : number.toCharArray()) {
            if (!Character.isDigit(singleChar)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if (!isValidNumber(number)) {
                sb.append(String.format("Calling... %s%n", number));
            } else {
                sb.append(String.format("Invalid number!%n"));
            }
        }
            return sb.toString().trim();
        }


    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if (!isValidURL(url)) {
                sb.append(String.format("Browsing: %s!%n", url));
            } else {
                sb.append(String.format("Invalid URL!%n"));

            }
        }
            return sb.toString().trim();
        }
    }


