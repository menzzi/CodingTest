```java
import java.util.*;

class Solution {
    public String solution(String s) {
        s = s.toLowerCase(); // 일단 다 소문자로 !!
        StringTokenizer st = new StringTokenizer(s," ",true);
        
        StringBuilder sb = new StringBuilder();
        
        while(st.hasMoreTokens()){
            String word = st.nextToken();
            if(word.length()==0)sb.append(" ");
            else {
                sb.append(word.substring(0,1).toUpperCase());
                sb.append(word.substring(1));
            }
        }
        return sb.toString();
    }
}
```

- 처음에는 String 형에서 쓸 수 있던 함수를 char 형에 적용할려고 하여 진전이 없었다.   
- 쉽게 통과하는 줄 알았으나,,, 8번 테스트 케이스에서 실패가 떴다.  
  8번 테스트 케이스 -> 입력값 〉   "  for the what 1what  "  
                  기댓값 〉   "  For The What 1what  "   
 => 앞뒤 공백이 있는 경우...!!!심지어 공백이 하나씩이 아니라 두개씩  
  이 테스트 케이스에만 맞춰서 할 수 있지만 그걸 원하진 않을 것이다. 보통 이 테스트 케이스 값을 모를테니까     

💡 split() 대신 Tokenizer() 로 공백을 포함하여 분리하기 !   
💡 와 이건 생각 못 했다. 전체 모두 소문자로 변환하고 앞에만 대문자로 바꾸기 〰️〰️〰️  

---
** 새롭게 알게된 토커나이저로 문자열 자르기 **  
1. 띄어쓰기 기준으로 문자열을 분리 - StringTokenizer st = new StringTokenizer(문자열);    
2. 구분자를 기준으로 문자열을 분리 - StringTokenizer st = new StringTokenizer(문자열, 구분자);    
3. 구분자를 기준으로 문자열을 분리할 때 구분자도 토큰으로 넣는다.(true) / 구분자를 분리된 문자열 토큰에 포함 시키지 않는다. (false) * (디폴트 : false) - StringTokenizer st = new StringTokenizer(문자열 , 구분자 , true/false);
---

⭕️ 공백을 따로 추가해주지 않고 같이 체크해서 공백이 있으면 바로바로 넣어주기.  
❌ 이전에 생각(오답) : 단어별로 자른 후 단어 끼리 붙일때 공백 따로 추가 + 첫 글자 대문자 처리 + 나머지 단어 다 소문자 처리(반복문으로)  
😃 문자열 자를때 앞으로 토커나이저도 고려하기 너무 split() 만 애용하지 말자. 
