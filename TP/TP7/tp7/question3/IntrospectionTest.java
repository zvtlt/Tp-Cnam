package question3;

import java.util.Set;
import java.lang.reflect.Method;


public class IntrospectionTest extends junit.framework.TestCase{
 

	public void test1(){
// 	  try{
//  // à compléter
//   // à compléter
//    // à compléter
//     // à compléter
//      // à compléter
//  
//     }catch(ClassNotFoundException e){
//       fail("exception innattendue !");
//     }
	}
	
	public void test_java_util_Object(){
	  try{
  		question3.Introspection intro = new question3.Introspection();
  		java.util.Set<Method> set = intro.getHeritees("java.lang.Object");
  		assertNotNull(set);
  	  assertEquals(true, set.isEmpty());
    }catch(ClassNotFoundException e){
      fail("exception innattendue !");
    }
	}
	

}

