import java.util.*;
public class MinSubstr {
    public String minimumWindow(String s,String t){
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length()){
            return "Invalid";
        }
        HashMap<Character,Integer> m = new HashMap<Character,Integer>();
        for(char ch : t.toCharArray()){
            m.put(ch,m.getOrDefault(ch,0)+1);
        }
        int i=0,j=0,count = t.length(),start = 0;
        int ans = Integer.MAX_VALUE;
        while(j < s.length()){
            char ch = s.charAt(j);
            if(m.containsKey(ch)){
                m.put(ch,m.get(ch)-1);
                if(m.get(ch) >=0){
                    count--;
                }
            }
            while(count == 0){
                if(ans > j-i+1){
                    ans = j-i+1;
                    start = i;
                }
                char ch1 = s.charAt(i);
                if(m.containsKey(ch1)){
                    m.put(ch1,m.get(ch1)+1);
                    if(m.get(ch1)>0)
                    count++;
                }
                i++;
            }
            j++;
        }
        if(ans == 0){
            return "No substring found";
        }else{
            return s.substring(start, start+ans);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string s:");
        String s = sc.nextLine();
        System.out.println("Enter the string t:");
        String t = sc.nextLine();
        MinSubstr obj = new MinSubstr();
        String result = obj.minimumWindow(s,t);
        System.out.println("Minimum substring: "+result);

    }
}
