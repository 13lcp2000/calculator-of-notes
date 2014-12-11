
package calculator_UNIAJC;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Calculator_of_notes {
    public static void main (String[] args){
        float TestCalification1, TestCalification2, FinalTestCalification, ProjecCalification, AditionalCalification;
        double DefinitiveCalification;
        int repetitionsControl;
        String UniversitySubjectName, VerbalCalification;
        
        do 
        {
                 do 
                 {
                     UniversitySubjectName = JOptionPane.showInputDialog("Type the NAME of the Subject: ");
                     if(validateWord(UniversitySubjectName))
                     {
                         repetitionsControl = 1; //to DON'T repeat the typing of the subject name.
                     }
                     else
                     {
                         repetitionsControl = 0; //to DO repeat the typing of the subject name.
                     }
                 } while (repetitionsControl == 0);
                 
                 TestCalification1 = getReal("Type the Calification of the Test #1: ");
                 TestCalification2 = getReal("Type the Calification of the Test #2: ");
                 FinalTestCalification = getReal("Type the Calification of the Final Test: ");
                 ProjecCalification = getReal("Type the Calification of the Course Project: ");
                 AditionalCalification = getReal("the Calification of the Aditional Ratings: ");
                 
                 DefinitiveCalification = toCalculate_DefinitiveCalification(TestCalification1, TestCalification2, FinalTestCalification, ProjecCalification, AditionalCalification);
                 VerbalCalification = (DefinitiveCalification > 2.95) ? "YOU APPROVED, Congratulations! :D" : "YOU FAILED, keep Trying..." ; //ternary operator LOL...
                 
                 JOptionPane.showMessageDialog(null, "The definitive Calification of the subject " + (UniversitySubjectName.toUpperCase()) + " is: " + (Math.round(DefinitiveCalification * 10.0)/10.0) + " \nSubject " + VerbalCalification);
                 
           repetitionsControl = JOptionPane.showConfirmDialog(null, "Would you like to repeat the Program?", "Input", JOptionPane.YES_NO_OPTION);
        } while(repetitionsControl == 0);
        
        JOptionPane.showMessageDialog(null, "APP ENDED");
        JOptionPane.showMessageDialog(null, "      =========================" +
                                           "\n      ¦¦--- Universitary Institution ---¦¦" + 
                                           "\n      ¦¦- ANTONIO JOSE CAMACHO -¦¦" +
                                          "\n      =========================" +
                                       "\n\n            Systems Engineering" +
                                          "\n            Program maded by: " + 
                                       "\n\n            Leonardo Collazos Paez"+
                                       "\n               E-MAIL CONTACT:"+
                                       "\n             leo011093@hotmail.com\n", "Creditos", 
                                       
                                       JOptionPane.INFORMATION_MESSAGE, 
                                       new ImageIcon("\\images\\leoface.png"));
}
     
//AUXILIARY METHODS CONTAINED ON THE MAIN METHOD "MAIN"...
    
    public static void errorInputMessage(){
      JOptionPane.showMessageDialog(null, "The last input Typed is Incorrect!");
   }
    public static float getReal(String cadena){//method that evaluates if the inputs of the numbers are correct and repeat the loop as many times as necessary to avoid having to write Checkout many times if not, the method is repeated as many times as necessary.
       float num;   
            try
            {
                do {                    
                    num = Float.parseFloat(JOptionPane.showInputDialog(cadena));
                    if(num < 0.0)
                    {
                        JOptionPane.showMessageDialog(null,"the last number is an error \ntype a number bigger than cero");
                    }
                    else if(num > 5.0)
                    {
                        JOptionPane.showMessageDialog(null,"the last number is an error \\ntype a number smaller than five");
                    }
                } while (num<0.0 || num>5.0); //to validate that the number you enter is only in the range of 0-5 the valid number
            }catch(NumberFormatException e)
            {
                num = getReal(cadena);
            }
        return num; //retorna la variable la nota.
    }
     public static boolean validateWord(String word) {  
         for (int i = 0; i < word.length(); i++) 
            {
                if(!((word.charAt(i) > 64 && word.charAt(i) < 91)||//java ASCII code for the letter de la: A-Z (Capital Letters)
                      (word.charAt(i) > 96 && word.charAt(i) < 123)|| //java ASCII code for the letter: a-z (NO Capital Letters)
                      (word.charAt(i) == 193)|| //java ASCII code for the letter: Á
                      (word.charAt(i) == 201)|| //java ASCII code for the letter: É 
                      (word.charAt(i) == 205)|| //java ASCII code for the letter: Í
                      (word.charAt(i) == 209)|| //java ASCII code for the letter: Ñ
                      (word.charAt(i) == 211)|| //java ASCII code for the letter: Ó
                      (word.charAt(i) == 218)|| //java ASCII code for the letter: Ú
                      (word.charAt(i) == 225)|| //java ASCII code for the letter: á
                      (word.charAt(i) == 233)|| //java ASCII code for the letter: é
                      (word.charAt(i) == 237)|| //java ASCII code for the letter: í
                      (word.charAt(i) == 241)|| //java ASCII code for the letter: ñ
                      (word.charAt(i) == 243)|| //java ASCII code for the letter: ó
                      (word.charAt(i) == 250)))  //java ASCII code for the letter: ú
                {
                    return false;
                }
            }
            return true;
        }
    public static double toCalculate_DefinitiveCalification(float NoPar1, float NoPar2, float NoParFi, float NoProy, float NoAdi){
        return ((NoPar1*0.2) + (NoPar2*0.2) + (NoParFi*0.25) + (NoProy*0.20) + (NoAdi*0.15));
    }

}
