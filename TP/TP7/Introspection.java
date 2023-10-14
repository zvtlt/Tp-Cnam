package question3;

import java.lang.reflect.*;
import java.util.*;

public class Introspection {

	public static Set<Method> getHeritees(String nomDeLaClasse) throws ClassNotFoundException {
		// à compléter
		Set<Method> setLocalMethod;
		Set<Method> setSuperMethod = new HashSet<Method>();
		Set<Method> setLocalPotentialHeritees = new HashSet<Method>();
		Set<Method> setHeriteesNotRedefined = new HashSet<Method>();

		try {

			Class Cl = Class.forName(nomDeLaClasse);
			setLocalMethod = new HashSet<Method>(Arrays.asList(Cl.getDeclaredMethods()));

			for (Method m : setLocalMethod) {
				if ((Modifier.isPublic(m.getModifiers()) && !Modifier.isAbstract(m.getModifiers()))
						|| Modifier.isProtected(m.getModifiers())) {
					setLocalPotentialHeritees.add(m);
				}
			}

			Class superCl = Cl.getSuperclass();
			while (superCl != null) {
				Set<Method> setTemMethod = new HashSet<Method>(Arrays.asList(superCl.getDeclaredMethods()));
				for (Method m : setTemMethod) {
					if ((!ContainMethod(setSuperMethod, m))) {
						if ((Modifier.isPublic(m.getModifiers()) && !Modifier.isAbstract(m.getModifiers()))
								|| Modifier.isProtected(m.getModifiers())) {
							setSuperMethod.add(m);
						}
					}
				}
				superCl = superCl.getSuperclass();
			}

			for (Method m : setSuperMethod) {
				if ((!ContainMethod(setLocalPotentialHeritees, m))) {
					setHeriteesNotRedefined.add(m);
				}
			}

		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException();
		}
		return setHeriteesNotRedefined;
	}

	private static boolean ContainMethod(Set<Method> l, Method m) {
		for (Method ms : l) {
			boolean test = true;
			// test &= (IsSameMethod(ms, m));
			test &= (IsSameMethodName(ms, m));
			test &= (IsSameParamType(ms, m));
			// test &= (IsSameReturnType(ms, m));
			// test &= (IsSameReturnTypeWithCovariance(ms, m));
			if (test) {
				return true;
			}
		}
		return false;
	}

	private static boolean IsSameMethod(Method m1, Method m2) { // throws Exception
		return (m1.equals(m2));
	}

	private static boolean IsSameMethodName(Method m1, Method m2) { // throws Exception
		return (m1.getName().equals(m2.getName()));
	}

	private static boolean IsSameParamType(Method m1, Method m2) { // throws Exception

		Class<?>[] p1 = m1.getParameterTypes();
		Class<?>[] p2 = m2.getParameterTypes();

		// même paramètre
		if ((p1.length != p2.length)) {
			return false;
		}
		for (int i = 0; i < p1.length; i++) {
			if ((p1[i] != p2[i])) {
				return false;
			}
		}
		return true;
	}

	private static boolean IsSameReturnTypeWithCovariance(Method ms, Method m) {
		// A COMPLETER
		Class<?> cl = m.getReturnType();
		Class<?> superCl = ms.getReturnType();
		if (superCl == cl)
			return true;
		while (cl != null) {
			cl = cl.getSuperclass();
			if (superCl == cl)
				return true;
		}
		return false;
	}

	private static boolean IsSameReturnType(Method m1, Method m2) { // throws Exception
		return (m1.getReturnType() == m2.getReturnType());
	}

	public static void main(String[] args) throws ClassNotFoundException {
		for (Method m : Introspection.getHeritees("java.util.AbstractCollection")) {
			System.out.println(m);
		}
	}

}