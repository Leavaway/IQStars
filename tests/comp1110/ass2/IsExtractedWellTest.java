package comp1110.ass2;

import org.junit.jupiter.api.*;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

//Authored by Jiayong Zhu.
@Timeout(value = 1000, unit = MILLISECONDS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IsExtractedWellTest {
    private void test(String in,String expect) {
        int b = in.indexOf("W");
        StringBuilder st = new StringBuilder();
        for(String s:IQStars.extractP(in,b)){
            st.append(s);
        }
        Assertions.assertEquals(expect,st.toString(),"Not extract well");
    }
    @Test
    public void testWell(){
        String[] test1 = {"b021W","o520W","y030b000W","o322p151W","r020b400i040W","r010y250i231W",
                "r242g540b010p041W","y521g110i040p020W",
                "r101y250g000b020i013W","r220y200g512b260p440W",
                "r250o011y322g262b100i010p340W","r201o222y040g330b121i000p151W",
                "r041o321y200g540b312i033p420Wo32g31p30"};
        for(String s : test1){
            int b = s.indexOf("W");
            test(s,s.substring(0,b));
        }
    }
}
