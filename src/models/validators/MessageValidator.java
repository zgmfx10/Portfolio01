package models.validators;
import java.util.ArrayList;
import java.util.List;

import models.Message;
/**
 * Servlet implementation class MessageValidator
 */
public class MessageValidator {

    //バリデーションを実行する
   public static List<String> validate(Message m){
       List<String> errors = new ArrayList<String>();

       String name_error = _validateName(m.getName());
       if(!name_error.equals("")) {
           errors.add(name_error);
       }

       String hurigana_error = _validateHurigana(m.getHurigana());
       if(!hurigana_error.equals("")) {
           errors.add(hurigana_error);
       }

       String phone_error = _validatePhone(m.getPhone());
       if(!phone_error.equals("")) {
           errors.add(phone_error);
       }

       String mail_error = _validateMail(m.getMail());
       if(!mail_error.equals("")) {
           errors.add(mail_error);
       }
       return errors;
   }

   //名前の必須入力チェック
   private static String _validateName(String name) {
       if(name == null || name.equals("")) {
           return "お名前が入力されていません";
       }
       return "";
   }

   //ふりがなの必須入力チェック
   private static String _validateHurigana(String hurigana) {
       if(hurigana == null || hurigana.equals("")) {
           return "ふりがなが入力されていません";
       }
       return "";
   }

   //電話番号の必須チェック
   private static String _validatePhone(String phone) {
       //boolean result = true;
       if(phone == null || phone.equals("")) {
           return "お電話番号が入力されていません";
       }
       //お電話番号の数字入力のチェック
       for(int i = 0; i < phone.length(); i++) {
           if(Character.isDigit(phone.charAt(i))) {
               continue;
           } else {
               return "お電話番号は数字で入力してください。";
           }
       }
       return "";
   }

   //メールの必須チェック
   private static String _validateMail(String mail) {
       if(mail == null || mail.equals("")) {
           return "メールアドレスが入力されていません";
       }
       return "";
   }
}
