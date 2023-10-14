package question3;
 
 import java.util.*;
 import java.lang.reflect.*;
 import java.util.Map;
 import java.util.HashMap;
 import java.util.List;
 import java.util.ArrayList;
 
 public class Z_ParIntrospectionTest extends junit.framework.TestCase{
  
 
  private static String VERSION;
  static{
    VERSION = System.getProperties().getProperty("java.version");
  }
  
  private static class Verif{
 //   public static Set<Method> getHeritees(String nomDeLaClasse) throws ClassNotFoundException{
 //     Class classe = Class.forName(nomDeLaClasse);
 //     Set<Method> set=new HashSet<Method>();     
 //     for(Method m : classe.getMethods())   set.add(m);            // toutes les methodes publiques
 //     for(Method m : classe.getDeclaredMethods())   set.remove(m); // retrait de toutes celles definies localement
 //     return set;
 //   }

		public static Map<Method, Set<Class>> getRedefinies(String nomDeLaClasse) throws ClassNotFoundException {
			Class cl = Class.forName(nomDeLaClasse);
			Map<Method, Set<Class>> map = new HashMap<Method, Set<Class>>();

			for (Method m : cl.getDeclaredMethods()) {
				Set<Class> l = new HashSet<Class>();
				Class superClass = cl.getSuperclass();
				while (superClass != null) {
					try {
						superClass.getDeclaredMethod(m.getName(), m.getParameterTypes());
						l.add(superClass);
					} catch (NoSuchMethodException e) {
					}
					superClass = superClass.getSuperclass();
				}
				map.put(m, l);
			}
			return map;
		}

		public static Set<Method> getHeritees(String nomDeLaClasse) throws ClassNotFoundException {
			Class cl = Class.forName(nomDeLaClasse);
			Set<String> locales = new HashSet<String>();
			for (Method m : cl.getDeclaredMethods()) {
				int modifier = m.getModifiers();
				if ((Modifier.isPublic(modifier) && !Modifier.isAbstract(modifier)) || Modifier.isProtected(modifier)) {
					// System.out.println(toString(m));
					locales.add(toString(m));
				}
			}
//System.out.println("locales : " + locales);
			Set<Method> heritees = new HashSet<Method>();
			Set<String> signatures = new HashSet<String>();
			Class superClass = cl.getSuperclass();
			while (superClass != null) {
				for (Method m : superClass.getDeclaredMethods()) {
					int modifier = m.getModifiers();
					if ((Modifier.isPublic(modifier) && !Modifier.isAbstract(modifier))
							|| Modifier.isProtected(modifier)) {
						String signature = toString(m);
						if (!locales.contains(signature))
							if (!signatures.contains(signature)) { // afin d'eliminer les redefinitions eventuelles
								heritees.add(m);
								signatures.add(signature);
							} else {
								// System.out.println( m + " redefinie");
							}
					}
				}
				superClass = superClass.getSuperclass();
			}
			;

//System.out.println("heritees : " + heritees);
//System.out.println("locales : " + locales);
			return heritees;
		}

		public static String toString(Method m) {
			String name = m.getName() + "(";
			for (int i = 0; i < m.getParameterTypes().length; i++) {
				name = name + m.getParameterTypes()[i].getName();
				if (i < m.getParameterTypes().length - 1)
					name = name + ",";
			}
			return name + ")";
		}

	}

	public void test_java_util_Vector() {
		try {
			question3.Introspection intro = new question3.Introspection();
			java.util.Set<Method> set = intro.getHeritees("java.util.Vector");
			assertNotNull(set);
			assertEquals("l'ensemble des methodes heritees ne peut être vide ???", false, set.isEmpty());
			assertEquals("en " + VERSION + ", nombre de methodes heritees errone ???",
					Verif.getHeritees("java.util.Vector").size(), set.size());
			assertEquals("le contenu obtenu par getHeritees(), est-il errone ???",
					Verif.getHeritees("java.util.Vector"), set);
			// System.out.println(Verif.getHeritees("java.util.Vector").size());
		} catch (ClassNotFoundException e) {
			fail("ClassNotFoundException inattendue !");
		} catch (Exception e) {
			fail("Exception inattendue !" + e.getMessage());
		}
	}

	public void test_java_util_une_classe_au_hasard() {
		try {
			question3.Introspection intro = new question3.Introspection();
			java.util.Set<Method> set = intro.getHeritees("java.util.Properties");
			assertNotNull(set);
			assertEquals("l'ensemble des methodes heritees ne peut être vide ???", false, set.isEmpty());
			assertEquals("en " + VERSION + ", nombre de methodes heritees errone ???",
					Verif.getHeritees("java.util.Properties").size(), set.size());
			assertEquals("le contenu obtenu par getHeritees(), est-il errone ???",
					Verif.getHeritees("java.util.Properties"), set);
		} catch (ClassNotFoundException e) {
			fail("ClassNotFoundException inattendue !");
		} catch (Exception e) {
			fail("Exception inattendue !" + e.getMessage());
		}
	}

	public void test_java_util_AbstractCollection() {
		try {
			question3.Introspection intro = new question3.Introspection();
			java.util.Set<Method> set = intro.getHeritees("java.util.AbstractCollection");
			assertNotNull(set);
			assertEquals("l'ensemble des methodes heritees ne peut être vide ???", false, set.isEmpty());
			assertEquals(" nombre de methodes heritees errone ???",
					Verif.getHeritees("java.util.AbstractCollection").size(), set.size());
			assertEquals("le contenu obtenu par getHeritees(), est-il errone ???",
					Verif.getHeritees("java.util.AbstractCollection"), set);
		} catch (ClassNotFoundException e) {
			fail("ClassNotFoundException inattendue !");
		} catch (Exception e) {
			fail("Exception inattendue !" + e.getMessage());
		}
	}

	public void test_java_util_AbstractSet() {
		try {
			question3.Introspection intro = new question3.Introspection();
			java.util.Set<Method> set = intro.getHeritees("java.util.AbstractSet");
			assertNotNull(set);
			assertEquals("l'ensemble des methodes heritees ne peut être vide ???", false, set.isEmpty());
			assertEquals(" nombre de methodes heritees errone ???", Verif.getHeritees("java.util.AbstractSet").size(),
					set.size());
			assertEquals("le contenu obtenu par getHeritees(), est-il errone ???",
					Verif.getHeritees("java.util.AbstractSet"), set);
		} catch (ClassNotFoundException e) {
			fail("ClassNotFoundException inattendue !");
		} catch (Exception e) {
			fail("Exception inattendue !" + e.getMessage());
		}
	}

	public void test_java_util_HashSet() {
		try {
			question3.Introspection intro = new question3.Introspection();
			java.util.Set<Method> set = intro.getHeritees("java.util.HashSet");
			assertNotNull(set);
			assertEquals("l'ensemble des methodes heritees ne peut être vide ???", false, set.isEmpty());
			System.out.println("Introspection");
			for (Method m : set) {
				System.out.println(m);
			}
			System.out.println("Verif");
			for (Method m : Verif.getHeritees("java.util.HashSet")) {
				System.out.println(m);
			}
			assertEquals(" nombre de methodes heritees errone ???", Verif.getHeritees("java.util.HashSet").size(),
					set.size());
			assertEquals("le contenu obtenu par getHeritees(), est-il errone ???",
					Verif.getHeritees("java.util.HashSet"), set);
		} catch (ClassNotFoundException e) {
			fail("ClassNotFoundException inattendue !");
		} catch (Exception e) {
			fail("Exception inattendue !" + e.getMessage());
		}
	}

	public void test_java_util_WeakHashMap() {
		try {
			question3.Introspection intro = new question3.Introspection();
			java.util.Set<Method> set = intro.getHeritees("java.util.WeakHashMap");
			assertNotNull(set);
			assertEquals("l'ensemble des methodes heritees ne peut être vide ???", false, set.isEmpty());
			assertEquals(" nombre de methodes heritees errone ???", Verif.getHeritees("java.util.WeakHashMap").size(),
					set.size());
			assertEquals("le contenu obtenu par getHeritees(), est-il errone ???",
					Verif.getHeritees("java.util.WeakHashMap"), set);
		} catch (ClassNotFoundException e) {
			fail("ClassNotFoundException inattendue !");
		} catch (Exception e) {
			fail("Exception inattendue !" + e.getMessage());
		}
	}

	public void test_java_util_Stack() {
		try {
			question3.Introspection intro = new question3.Introspection();
			java.util.Set<Method> set = intro.getHeritees("java.util.Stack");
			assertNotNull(set);
			assertEquals("l'ensemble des methodes heritees ne peut être vide ???", false, set.isEmpty());
			assertEquals(" nombre de methodes heritees errone ???", Verif.getHeritees("java.util.Stack").size(),
					set.size());
			assertEquals("le contenu obtenu par getHeritees(), est-il errone ???", Verif.getHeritees("java.util.Stack"),
					set);

		} catch (ClassNotFoundException e) {
			fail("ClassNotFoundException inattendue !");
		} catch (Exception e) {
			fail("Exception inattendue !" + e.getMessage());
		}
	}

	public void test_java_util_Object() {
		try {
			question3.Introspection intro = new question3.Introspection();
			java.util.Set<Method> set = intro.getHeritees("java.lang.Object");
			assertNotNull(set);
			assertEquals("l'ensemble des methodes heritees doit être vide ???", true, set.isEmpty());
			assertEquals(" nombre de methodes heritees errone ???", Verif.getHeritees("java.lang.Object").size(),
					set.size());
			assertEquals("le contenu obtenu par getHeritees(), est-il errone ???",
					Verif.getHeritees("java.lang.Object"), set);
		} catch (ClassNotFoundException e) {
			fail("ClassNotFoundException inattendue !");
		} catch (Exception e) {
			fail("Exception inattendue !" + e.getMessage());
		}
	}

	public void test_question3_Introspection() {
		try {
			question3.Introspection intro = new question3.Introspection();
			java.util.Set<Method> set = intro.getHeritees("question3.Introspection");
			assertNotNull(set);
			assertEquals("l'ensemble des methodes heritees ne peut être vide ???", false, set.isEmpty());
			assertEquals(" nombre de methodes heritees errone ???", Verif.getHeritees("question3.Introspection").size(),
					set.size());
			assertEquals("le contenu obtenu par getHeritees(), est-il errone ???",
					Verif.getHeritees("question3.Introspection"), set);
		} catch (ClassNotFoundException e) {
			fail("ClassNotFoundException inattendue !");
		} catch (Exception e) {
			fail("Exception inattendue !" + e.getMessage());
		}
	}

	public void test_javax_swing_JApplet() {
		try {
			question3.Introspection intro = new question3.Introspection();
			java.util.Set<Method> set = intro.getHeritees("javax.swing.JApplet");
			assertNotNull(set);
			assertEquals("l'ensemble des methodes heritees ne peut être vide ???", false, set.isEmpty());
			assertEquals(" nombre de methodes heritees errone ???", Verif.getHeritees("javax.swing.JApplet").size(),
					set.size());
			assertEquals("le contenu obtenu par getHeritees(), est-il errone ???",
					Verif.getHeritees("javax.swing.JApplet"), set);

		} catch (ClassNotFoundException e) {
			fail("ClassNotFoundException inattendue !");
		} catch (Exception e) {
			fail("Exception inattendue !" + e.getMessage());
		}
	}

	public void test_javax_swing_JButton() {
		try {
			question3.Introspection intro = new question3.Introspection();
			java.util.Set<Method> set = intro.getHeritees("javax.swing.JButton");
			assertNotNull(set);
			assertEquals("l'ensemble des methodes heritees ne peut être vide ???", false, set.isEmpty());
			assertEquals(" nombre de methodes heritees errone ???", Verif.getHeritees("javax.swing.JButton").size(),
					set.size());
			assertEquals("le contenu obtenu par getHeritees(), est-il errone ???",
					Verif.getHeritees("javax.swing.JButton"), set);

		} catch (ClassNotFoundException e) {
			fail("ClassNotFoundException inattendue !");
		} catch (Exception e) {
			fail("Exception inattendue !" + e.getMessage());
		}
	}

	public void test_junit_framework_TestCase(){
         	  try{
           		question3.Introspection intro = new question3.Introspection();
           		java.util.Set<Method> set = intro.getHeritees("junit.framework.TestCase");
           		assertNotNull(set);
           	  assertEquals("l'ensemble des methodes heritees ne peut être vide ???",false, set.isEmpty());
           	  //System.out.println(" set : " + set);
           		assertEquals(" nombre de methodes heritees errone ???", Verif.getHeritees("junit.framework.TestCase").size(), set.size());
           		assertEquals("le contenu obtenu par getHeritees(), est-il errone ???", Verif.getHeritees("junit.framework.TestCase"), set);
             }catch(ClassNotFoundException e){
               fail("ClassNotFoundException inattendue !");
             }catch(Exception e){
               fail("Exception inattendue !" + e.getMessage());
             }
	}

	public void test_classe_inexistante() {
		try {
			question3.Introspection intro = new question3.Introspection();
			java.util.Set<Method> set = intro.getHeritees("java.util.Vecteur");
			fail(" une exception est attendue !");
		} catch (Exception e) {
			assertTrue(" est-ce la bonne exception ???,  ClassNotFoundException est attendu ",
					e instanceof ClassNotFoundException);
		}
	}

	public void test_classe_au_clone_public() {
		try {
			question3.Introspection intro = new question3.Introspection();
			java.util.Set<Method> set = intro.getHeritees("question3.Z_B");
			assertNotNull(set);
			assertEquals("l'ensemble des methodes heritees ici, ne peut être vide ???", false, set.isEmpty());
			assertEquals(" clone devient public dans la sous-classe ???", Verif.getHeritees("question3.Z_B").size(),
					set.size());
			assertEquals("le contenu obtenu par getHeritees(), est-il errone ???", Verif.getHeritees("question3.Z_B"),
					set);

		} catch (Exception e) {
			assertTrue(" est-ce la bonne exception ???,  ClassNotFoundException est attendu ",
					e instanceof ClassNotFoundException);
		}
	}
	// public void test_en_local
	//
	// for(Method m : Verif.getHeritees("junit.framework.TestCase")){
	// System.out.println(m);
//         	     }
}
