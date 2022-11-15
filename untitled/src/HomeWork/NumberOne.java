package HomeWork;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberOne {
    public static void main(String[] args) {


        //Телефон (до/после маскирования): 79991113344 / 7999***3344
        //Email (до/после маскирования): test@yandex.ru / tes*@******.ru, my_mail@gmail.com / my_mai*@*****.com
        //Фио (до/после маскирования): Иванов Иван Иванович / И****в Иван И.
        //String str = "79991113344;78881113333";
        String str = "test@yandex.ru;79991113344";
        int start, end;
        StringBuilder stringBuilder = new StringBuilder(str);
        String tel = "[0-9]{11}";
        //String email = "[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z]+";

       // String email = "\w*@\w*.[a-zA-Z]*";

        Pattern p = Pattern.compile(tel);
        Matcher m = p.matcher(str);

        while (m.find())
        {
            start = m.start();
            end = m.end();
            stringBuilder.replace(start + 4, end - 4, "***");
        }
        str = stringBuilder.toString();
        //Замена почты
        String firstMask, lastMask, emailMask, strReplace, newEmail;
        emailMask = "[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z]+";
        firstMask = "[a-zA-Z0-9]+@";

        p = Pattern.compile(emailMask);
        m = p.matcher(str);

        while (m.find())
        {
            start = m.start();
            end = m.end();

            String strEmil = stringBuilder.substring(start, end);

            ;

            System.out.println(strEmil);
            //System.out.println(strEmil.indexOf("@"));
           newEmail = strEmil.replace("@", "*@");
           start = strEmil.indexOf("@") + 1;
           end = strEmil.indexOf(".") - 1;
           //System.out.println();
            strReplace = "";
            for (int i = 0; i < end - start; i++) {
            strReplace = strReplace + "*";
            }
            System.out.println(strEmil + " sfsd" );
            newEmail = newEmail.replace(strEmil.substring(start, end), strReplace);
            System.out.println(strEmil + " sfsd" );
            str = str.replace(strEmil, newEmail);
        }



        System.out.println(str);
        //stringBuilder.replace()
    }
}
