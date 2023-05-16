import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();

            if(state.equals("leave")){
                set.remove(name);
            }else{
                set.add(name);
            }
        }

        List<String> list = new ArrayList<>();
        Iterator<String> iter = set.iterator();
        while(iter.hasNext()){
            list.add(iter.next());
        }
        Collections.sort(list, Collections.reverseOrder());

        for(String name:list){
           System.out.println(name);
        }
    }
}