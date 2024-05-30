import java.util.*;
class ReverseString{
    public String reverseStr(String str){
        StringBuilder sb = new StringBuilder(str);
        for(int i=0;i<sb.length()/2;i++){
            char temp = sb.charAt(i);
            sb.setCharAt(i,sb.charAt(sb.length()-1-i));
            sb.setCharAt(sb.length()-1-i,temp);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String inputString = sc.nextLine();
        ReverseString obj = new ReverseString();
        String reverseString = obj.reverseStr(inputString);
        System.out.println("Reversed String: "+reverseString);
    }
}