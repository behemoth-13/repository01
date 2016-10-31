package com.javarush.test.level34.lesson02.home01;

import java.text.DecimalFormat;
import java.util.Locale;

/* Рекурсия для мат.выражения
На вход подается строка - математическое выражение.
Выражение включает целые и дробные числа, скобки (), пробелы, знак отрицания -, возведение в степень ^, sin(x), cos(x), tan(x)
Для sin(x), cos(x), tan(x) выражение внутри скобок считать градусами, например, cos(3 + 19*3)=0.5
Степень задается так: a^(1+3) и так a^4, что эквивалентно a*a*a*a.
С помощью рекурсии вычислить выражение и количество математических операций. Вывести через пробел результат в консоль.
Результат выводить с точностью до двух знаков, для 0.33333 вывести 0.33, использовать стандартный принцип округления.
Не создавайте статические переменные и поля класса.
Не пишите косвенную рекурсию.
Пример, состоящий из операций sin * - + * +:
sin(2*(-5+1.5*4)+28)
Результат:
0.5 6
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recursion("-(-2^(-2))+2+(-(-2^(-2)))", 0);
        solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
        String s = "sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output 0.5 6 actually ");
        solution.recursion(s, 0);
        s = "tan(45)";
        System.out.print(s + " expected output 1 1 actually ");
        solution.recursion(s, 0);
        s = "tan(-45)";
        System.out.print(s + " expected output -1 2 actually ");
        solution.recursion(s, 0);
        s = "0.305";
        System.out.print(s + " expected output 0.3 0 actually ");
        solution.recursion(s, 0);
        s = "0.3051";
        System.out.print(s + " expected output 0.31 0 actually ");
        solution.recursion(s, 0);
        s = "(0.3051)";
        System.out.print(s + " expected output 0.31 0 actually ");
        solution.recursion(s, 0);
        s = "1+(1+(1+1)*(1+1))*(1+1)+1";
        System.out.print(s + " expected output 12 8 actually ");
        solution.recursion(s, 0);
        s = "tan(44+sin(89-cos(180)^2))";
        System.out.print(s + " expected output 1 6 actually ");
        solution.recursion(s, 0);
        s = "-2+(-2+(-2)-2*(2+2))";
        System.out.print(s + " expected output -14 8 actually ");
        solution.recursion(s, 0);
        s = "sin(80+(2+(1+1))*(1+1)+2)";
        System.out.print(s + " expected output 1 7 actually ");
        solution.recursion(s, 0);
        s = "1+4/2/2+2^2+2*2-2^(2-1+1)";
        System.out.print(s + " expected output 6 11 actually ");
        solution.recursion(s, 0);
        s = "2^10+2^(5+5)";
        System.out.print(s + " expected output 2048 4 actually ");
        solution.recursion(s, 0);
        s = "1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1";
        System.out.print(s + " expected output 72.96 8 actually ");
        solution.recursion(s, 0);
        s = "0.000025+0.000012";
        System.out.print(s + " expected output 0 1 actually ");
        solution.recursion(s, 0);
        s = "-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)";
        System.out.print(s + " expected output -3 16 actually ");
        solution.recursion(s, 0);
        s = "cos(3 + 19*3)";
        System.out.print(s + " expected output 0.5 3 actually ");
        solution.recursion(s, 0);
        s = "2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)";
        System.out.print(s + " expected output 8302231.36 14 actually ");
        solution.recursion(s, 0);
        s = "(-1 + (-2))";
        System.out.print(s + " expected output -3 3 actually ");
        solution.recursion(s, 0);
        s = "-sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output -0.5 7 actually ");
        solution.recursion(s, 0);
        s = "sin(100)-sin(100)";
        System.out.print(s + " expected output 0 3 actually ");
        solution.recursion(s, 0);
        s = "-(-22+22*2)";
        System.out.print(s + " expected output -22 4 actually ");
        solution.recursion(s, 0);
        s = "-2^(-2)";
        System.out.print(s + " expected output -0.25 3 actually ");
        solution.recursion(s, 0);
        s = "-(-2^(-2))+2+(-(-2^(-2)))";
        System.out.print(s + " expected output 2.5 10 actually ");
        solution.recursion(s, 0);
        s = "(-2)*(-2)";
        System.out.print(s + " expected output 4 3 actually ");
        solution.recursion(s, 0);
        s = "(-2)/(-2)";
        System.out.print(s + " expected output 1 3 actually ");
        solution.recursion(s, 0);
        s = "sin(-30)";
        System.out.print(s + " expected output -0.5 2 actually ");
        solution.recursion(s, 0);
        s = "cos(-30)";
        System.out.print(s + " expected output 0.87 2 actually ");
        solution.recursion(s, 0);
        s = "tan(-30)";
        System.out.print(s + " expected output -0.58 2 actually ");
        solution.recursion(s, 0);
        s = "2+8*(9/4-1.5)^(1+1)";
        System.out.print(s + " expected output 6.5 6 actually ");
        solution.recursion(s, 0);
        s = "0.005 ";
        System.out.print(s + " expected output 0.01 0 actually ");
        solution.recursion(s, 0);
        s = "0.0049 ";
        System.out.print(s + " expected output 0 0 actually ");
        solution.recursion(s, 0);
        s = "0+0.304";
        System.out.print(s + " expected output 0.3 1 actually ");
        solution.recursion(s, 0);
    }

    public void recursion(final String expression, int countOperation) {
        //implement
        Locale.setDefault(Locale.ENGLISH);
        if (countOperation == 0) {
            char ch;
            for (int i = 0; i < expression.length(); i++) {
                ch = expression.charAt(i);
                switch (ch) {
                    case '+':
                        countOperation++;
                        break;
                    case '-':
                        countOperation++;
                        break;
                    case '*':
                        countOperation++;
                        break;
                    case '/':
                        countOperation++;
                        break;
                    case '^':
                        countOperation++;
                        break;
                    case 'n':
                        countOperation++;
                        break;
                    case 'o':
                        countOperation++;
                        break;
                }
            }
        }
        String value = expression.replaceAll(" ", "").toLowerCase();
        value = value.replaceAll("--", "+");
        value = value.replaceAll("\\(\\+", "\\(");
        if (value.charAt(0) == '+') {
            value = value.substring(1);
        }
        if (isOneNumber(expression)) {
            String s = expression;
            s = s.replaceAll("\\)", "").replaceAll("\\(", "");
            double d = Double.parseDouble(s);
            DecimalFormat df = new DecimalFormat("#.##");
            String s2 = df.format(d);
            System.out.println(s2 + " " + countOperation);
            return;
        }

        if (!value.contains("(")) {
            value = calculateStringWithoutBracket(value);
        } else {
            int maxBracket = 0;
            int currentOpenBracket = 0;
            for (int i = 0; i < value.length(); i++) {
                char ch = value.charAt(i);
                if (ch == '(') {
                    currentOpenBracket++;
                    if (currentOpenBracket > maxBracket) {
                        maxBracket = currentOpenBracket;
                    }
                } else if (ch == ')') {
                    currentOpenBracket--;
                }
            }
            value = calculateStringWithBracket(value, maxBracket);
        }
        if (isOneNumber(value)) {
            value = value.replaceAll("\\)", "");
            value = value.replaceAll("\\(", "");
        }
        recursion(value, countOperation);
    }

    private String calculateStringWithBracket(String value, int maxBracket) {

        int beginIndex = 0;
        int endIndex;
        for (int j = maxBracket; j >= 0; j--) {
            int currentOpenBracket = 0;
            for (int i = 0; i < value.length(); i++) {
                char ch = value.charAt(i);
                if (ch == '(') {
                    currentOpenBracket++;
                    if (currentOpenBracket == j) {
                        beginIndex = i + 1;
                    }
                } else if (ch == ')') {
                    currentOpenBracket--;
                    if (currentOpenBracket == j - 1) {
                        endIndex = i;
                        if (!isOneNumber(value.substring(beginIndex, endIndex))) {
                            String in = calculateStringWithoutBracket(value.substring(beginIndex, endIndex));     //в метод идёт то что в скобках и не одно число
                            if (value.charAt(beginIndex - 1) == '(' && value.charAt(endIndex) == ')' && isOneNumber(in)) {
                                return (value.substring(0, beginIndex - 1) + in + value.substring(endIndex + 1));
                            }
                            return (value.substring(0, beginIndex) + in + value.substring(endIndex));
                        }
                    }
                }
            }
        }
        return calculateStringWithoutBracket(value);
    }

    private String calculateStringWithoutBracket(String value) {
        DecimalFormat df = new DecimalFormat("#.##");
        if (!isOneNumber(value)) {
            if (value.contains("sin") || value.contains("cos") || value.contains("tan")) {
                for (int i = 0; i < value.length(); i++) {
                    char ch = value.charAt(i);
                    switch (ch) {
                        case 's':
                            return getTrigonomResult(value, "sin", i);
                        case 'c':
                            return getTrigonomResult(value, "cos", i);
                        case 't':
                            return getTrigonomResult(value, "tan", i);
                    }
                }
                System.out.println("Неизвестная ошибка в calculateStringWithoutBracket: sin, cos, tan");
                return null;
            } else if (value.contains("^")) {
                int i = value.indexOf("^");
                double before = findBeforeForPow(value, i);
                double after = findAfter(value, i);
                int beginReplace = findBeginReplaceForPow(value, i);
                int endReplace = findEndReplace(value, i);
                String in = df.format(Math.pow(before, after));
                if (in.startsWith("-")) {
                    in = "(" + in + ")";
                }
                if (beginReplace > 0 && value.charAt(beginReplace - 1) == ')') {
                    in = in.replaceAll("\\(", "").replaceAll("\\)", "");
                }
                return (value.substring(0, beginReplace) + in + value.substring(endReplace));
            } else if (value.contains("*") || value.contains("/")) {
                int i;
                int indMulti;
                int indDiv;
                if (value.indexOf("*") != -1) {
                    indMulti = value.indexOf("*");
                } else {
                    indMulti = value.length();
                }
                if (value.indexOf("/") != -1) {
                    indDiv = value.indexOf("/");
                } else {
                    indDiv = value.length();
                }
                if (indMulti < indDiv) {
                    i = indMulti;
                } else {
                    i = indDiv;
                }
                double before = findBeforeForPow(value, i); //forPow
                double after = findAfter(value, i);
                int beginReplace = findBeginReplaceForPow(value, i);//forPow
                int endReplace = findEndReplace(value, i);
                String in;
                if (value.charAt(i) == '*') {
                    in = df.format(before * after);
                } else {
                    in = df.format(before / after);
                }
                if (in.startsWith("-")) {
                    in = "(" + in + ")";
                }
                if (beginReplace > 0 && value.charAt(beginReplace - 1) == ')') {
                    in = in.replaceAll("\\(", "").replaceAll("\\)", "");
                }
                return (value.substring(0, beginReplace) + in + value.substring(endReplace));
            } else {//if (value.contains("+") || value.contains("-"))
                int i;
                int indAdd;
                int indSub = value.length();
                if (value.indexOf("+") != -1) {
                    indAdd = value.indexOf("+");
                } else {
                    indAdd = value.length();
                }
                for (int j = 1; j < value.length(); j++) {
                    if (value.charAt(j) == '-' && value.charAt(j - 1) != '(') {
                        indSub = j;
                        break;
                    }
                }
                if (indAdd < indSub) {
                    i = indAdd;
                } else {
                    i = indSub;
                }
                double before = findBefore(value, i);
                double after = findAfter(value, i);
                int beginReplace = findBeginReplace(value, i);
                int endReplace = findEndReplace(value, i);
                String in;
                if (value.charAt(i) == '+') {
                    in = df.format(before + after);
                } else {
                    in = df.format(before - after);
                }
                if (in.startsWith("-")) {
                    in = "(" + in + ")";
                }
                if (beginReplace > 0 && value.charAt(beginReplace - 1) == ')') {
                    in = in.replaceAll("\\(", "").replaceAll("\\)", "");
                }
                return (value.substring(0, beginReplace) + in + value.substring(endReplace));
            }
        } else
            return value;
    }

    private int findEndReplace(String value, int indexOfSign) {
        int endReplace = 0;
        if (value.charAt(indexOfSign + 1) == '(') {
            endReplace = value.length() - 1;
            for (int j = indexOfSign + 1; j < value.length(); j++) {
                if (value.charAt(j) == ')') {
                    endReplace = j + 1;// 1
                    break;
                }
            }
        } else {
            endReplace = value.length();
            for (int j = indexOfSign + 1; j < value.length(); j++) {
                if (!Character.isDigit(value.charAt(j)) && value.charAt(j) != '.') {
                    endReplace = j;
                    break;
                }
            }
        }
        return endReplace;
    }

    private int findBeginReplace(String value, int indexOfSign) {
        int beginReplace = 0;
        if (value.charAt(indexOfSign - 1) == ')') {
            for (int j = indexOfSign - 2; j >= 0; j--) {
                if (value.charAt(j) == '(') {
                    beginReplace = j;
                    break;
                }
            }
        } else {
            for (int j = indexOfSign - 2; j >= 0; j--) {  //for (int j = indexOfSign - 2; j >= 0; j--){
                if (!Character.isDigit(value.charAt(j)) && (value.charAt(j) != '.')) {
                    beginReplace = j + 1;
                    if (beginReplace != 0 && value.charAt(beginReplace - 1) == '-' && (beginReplace - 1 == 0 /*|| value.charAt(beginReplace - 2) == ')'*/)) {
                        beginReplace = j;
                    }
                    break;
                }
            }
        }
        return beginReplace;
    }

    private int findBeginReplaceForPow(String value, int indexOfSign) {
        int beginReplace = 0;
        if (value.charAt(indexOfSign - 1) == ')') {
            for (int j = indexOfSign - 2; j >= 0; j--) {
                if (value.charAt(j) == '(') {
                    beginReplace = j;
                    break;
                }
            }
        } else {
            for (int j = indexOfSign - 1; j >= 0; j--) {
                if (!Character.isDigit(value.charAt(j)) && (value.charAt(j) != '.')) {
                    beginReplace = j + 1;
                    break;
                }
            }
        }
        return beginReplace;
    }

    private double findAfter(String value, int indexOfSign) {
        if (value.charAt(indexOfSign + 1) == '(') {
            int endOfNumber = value.length() - 1;
            for (int i = indexOfSign + 1; i < value.length(); i++) {
                if (value.charAt(i) == ')') {
                    endOfNumber = i;
                    break;
                }
            }
            return Double.parseDouble(value.substring(indexOfSign + 2, endOfNumber));
        } else {
            int endOfNumber = value.length();
            for (int i = indexOfSign + 1; i < value.length(); i++) {
                if (!Character.isDigit(value.charAt(i)) && value.charAt(i) != '.') {
                    endOfNumber = i;
                    break;
                }
            }
            return Double.parseDouble(value.substring(indexOfSign + 1, endOfNumber));
        }
    }

    private double findBefore(String value, int indexOfSign) {
        if (value.charAt(indexOfSign - 1) == ')') {
            int beginIOfNumber = 0;
            for (int i = indexOfSign - 1; i >= 0; i--) {
                if (value.charAt(i) == '(') {
                    beginIOfNumber = i + 1;
                    break;
                }
            }
            return Double.parseDouble(value.substring(beginIOfNumber, indexOfSign - 1));
        } else {
            int beginIOfNumber = 0;
            for (int i = indexOfSign - 1; i > 0; i--) {
                if (value.charAt(i) == '-') {
                    beginIOfNumber = i + 1;
                }
                if (!Character.isDigit(value.charAt(i)) && value.charAt(i) != '.') { //if (!Character.isDigit(value.charAt(i)) && value.charAt(i) != '.' && value.charAt(i) != '-'){
                    beginIOfNumber = i + 1;
                    break;
                }
            }
            return Double.parseDouble(value.substring(beginIOfNumber, indexOfSign));
        }
    }

    private double findBeforeForPow(String value, int indexOfSign) {
        if (value.charAt(indexOfSign - 1) == ')') {
            int beginIOfNumber = 0;
            for (int i = indexOfSign - 1; i >= 0; i--) {
                if (value.charAt(i) == '(') {
                    beginIOfNumber = i + 1;
                    break;
                }
            }
            return Double.parseDouble(value.substring(beginIOfNumber, indexOfSign - 1));
        } else {
            int beginIOfNumber = 0;
            for (int i = indexOfSign - 1; i >= 0; i--) {
                if (!Character.isDigit(value.charAt(i)) && value.charAt(i) != '.') { //if (!Character.isDigit(value.charAt(i)) && value.charAt(i) != '.' && value.charAt(i) != '-'){
                    beginIOfNumber = i + 1;
                    break;
                }
            }
            return Double.parseDouble(value.substring(beginIOfNumber, indexOfSign));
        }
    }

    private boolean isOneNumber(String value) {
        value = value.replaceAll("\\(", "");
        value = value.replaceAll("\\)", "");
        try {
            //noinspection ResultOfMethodCallIgnored
            Double.parseDouble(value);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    private String getTrigonomResult(String value, String func, int indexBeginFunc) {
        DecimalFormat df = new DecimalFormat("#.##");
        int beginIndex = 0;
        int endIndex = value.length();

        String s = "";
        if (value.charAt(indexBeginFunc + 3) == '(') {
            beginIndex = indexBeginFunc + 4;
            for (int j = indexBeginFunc + 4; j < value.length(); j++) {
                if (value.charAt(j) == ')') {
                    endIndex = j; //не менять! на
                    break;
                }
            }
        } else {
            beginIndex = indexBeginFunc + 3;
            for (int j = indexBeginFunc + 3; j < value.length(); j++) {
                if (!Character.isDigit(value.charAt(j)) && value.charAt(j) != '.') {
                    endIndex = j;
                    break;
                }
            }
        }

        switch (func) {
            case "sin": {
                s = df.format(Math.sin(Math.toRadians(Double.parseDouble(value.substring(beginIndex, endIndex)))));
                if (s.contains("-")) {
                    s = "(" + s + ")";
                }
                return value.substring(0, indexBeginFunc) + s + value.substring(endIndex);
            }
            case "cos": {
                s = df.format(Math.cos(Math.toRadians(Double.parseDouble(value.substring(beginIndex, endIndex)))));
                if (s.contains("-")) {
                    s = "(" + s + ")";
                }
                return value.substring(0, indexBeginFunc) + s + value.substring(endIndex);
            }

            case "tan": {
                s = df.format(Math.tan(Math.toRadians(Double.parseDouble(value.substring(beginIndex, endIndex)))));
                if (s.contains("-")) {
                    s = "(" + s + ")";
                }
                return value.substring(0, indexBeginFunc) + s + value.substring(endIndex);
            }
            default:
                System.out.println("Неизвестная ошибка в getTrigonomResult");
                return null;
        }
    }

    public Solution() {
        //don't delete
    }
}
//System.out.println(maxBracket);

/*int inside = 0;
    int p1 = -1, p2 = -1, p3 = -1;
    char[] s = value.toCharArray();
for (int i = s.length - 1; i >= 0; i--) {
        switch (s[i]) {
        case '^':
        if (inside == 0 && p3 == -1) p3 = i;
        break;
        case '*':
        case '/':
        if (inside == 0 && p2 == -1) p2 = i;
        break;
        case '+':
        case '-':
        if (inside == 0 && p1 == -1) p1 = i;
        break;
        case '(':
        inside++;
        break;
        case ')':
        inside--;
        break;
        }
        }
        if (p1 != -1) p2 = p1;
        if (p2 != -1) p3 = p2;
        if (p3 != -1) {
        PrintStream oldStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(outputStream);
        System.setOut(newStream);
        recursion(value.substring(0, p3), currentCountOperation);
        String[] part1 = outputStream.toString().split("\\s");
        currentCountOperation = currentCountOperation < Integer.parseInt(part1[1]) ? Integer.parseInt(part1[1]) : currentCountOperation;
        outputStream.reset();
        recursion(value.substring(p3 + 1), currentCountOperation);
        String[] part2 = outputStream.toString().split("\\s");
        currentCountOperation = currentCountOperation < Integer.parseInt(part2[1]) ? Integer.parseInt(part2[1]) : currentCountOperation;
        System.setOut(oldStream);
        switch (s[p3]) {
        case '^':
        customPrint(df, Math.pow(Double.parseDouble(part1[0]), Double.parseDouble(part2[0])), countOperation, currentCountOperation);
        return;
        case '*':
        customPrint(df, Double.parseDouble(part1[0]) * Double.parseDouble(part2[0]), countOperation, currentCountOperation);
        return;
        case '/':
        customPrint(df, Double.parseDouble(part1[0]) / Double.parseDouble(part2[0]), countOperation, currentCountOperation);
        return;
        case '+':
        customPrint(df, Double.parseDouble(part1[0]) + Double.parseDouble(part2[0]), countOperation, currentCountOperation);
        return;
        case '-':
        customPrint(df, Double.parseDouble(part1[0]) - Double.parseDouble(part2[0]), countOperation, currentCountOperation);
        return;
        }
        }
        if (s.length > 0 && s[0] == '(' && s[s.length - 1] == ')') {
        recursion(value.substring(1, s.length - 1), countOperation);
        return;
        }
        if (s.length > 5 && Character.isAlphabetic(s[0]) && s[3] == '(' && s[s.length - 1] == ')') {
        String funcName = value.substring(0, 3);
        PrintStream oldStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(outputStream);
        System.setOut(newStream);
        recursion(value.substring(4, s.length - 1), currentCountOperation);
        String[] part = outputStream.toString().split("\\s");
        currentCountOperation = currentCountOperation < Integer.parseInt(part[1]) ? Integer.parseInt(part[1]) : currentCountOperation;
        System.setOut(oldStream);
        if ("sin".equals(funcName)) {
        customPrint(df, Math.sin(Math.toRadians(Double.parseDouble(part[0]))), countOperation, currentCountOperation);
        return;
        }
        if ("cos".equals(funcName)) {
        customPrint(df, Math.cos(Math.toRadians(Double.parseDouble(part[0]))), countOperation, currentCountOperation);
        return;
        }
        if ("tan".equals(funcName)) {
        customPrint(df, Math.tan(Math.toRadians(Double.parseDouble(part[0]))), countOperation, currentCountOperation);
        return;
        }
        }
        double n = 0d;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length && (Character.isDigit(s[i]) || s[i] == '.'); i++) {
        sb.append(s[i]);
        }
        if (sb.length() > 0) {
        n = Double.parseDouble(sb.toString());
        }
        customPrint(df, n, countOperation, countOperation);
        }
private void customPrint(DecimalFormat df, double v, int countOperation, int currentCountOperation) {
        if (countOperation == 0) {
        System.out.println(df.format(v) + " " + currentCountOperation);
        } else {
        System.out.println(String.valueOf(v) + " " + currentCountOperation);
        }
        }*/