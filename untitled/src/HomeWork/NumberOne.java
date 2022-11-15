package HomeWork;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberOne {
    public static String retZveda(int kol) {
        String str;
        str = "";
        while (kol >= 1) {
            --kol;
            str = str + "*";
        }
        return str;
    }

    public static void main(String[] args) {
        //Телефон (до/после маскирования): 79991113344 / 7999***3344
        //Email (до/после маскирования): test@yandex.ru / tes*@******.ru, my_mail@gmail.com / my_mai*@*****.com
        //Фио (до/после маскирования): Иванов Иван Иванович / И****в Иван И.
        String str, fioMask, regTel;
        str = "Иванов Иван Иванович;test@yandex.ru;79991113344";
        int start, end;

        //Телефон
        regTel = "([0-9]{4})([0-9]{3})([0-9]{4})";
        str = str.replaceAll(regTel, "$1" + "***" + "$3");

        //Замена почты
        String firstMask, lastMask, emailMask, strReplace, newEmail;
        emailMask = "([a-zA-Z0-9]+)[^.]@([a-zA-Z0-9]+)(.[a-zA-Z]+)";
        str = str.replaceAll(emailMask, "$1" + "*@" + "***" + "$3");

        //ФИО
        fioMask = "([А-Я][а-я]*)\s([А-Я][а-я]*)\s([А-Я][а-я]*)";

        Pattern p = Pattern.compile(regTel);
        Matcher m = p.matcher(str);

        p = Pattern.compile(fioMask);
        m = p.matcher(str);
        StringBuilder stringBuilder = new StringBuilder(str);

        while (m.find()) {
            start = m.start(1);
            end = m.end(1);

            stringBuilder.replace(start + 1, end - 1, retZveda(end - 2 + start));

            start = m.start(3);
            end = m.end(3);

            stringBuilder.replace(start, end, m.group(3).charAt(0) + ".");
        }

        System.out.println(stringBuilder);
    }
}

