package question1;

import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

/**
 * D�crivez votre classe ConcreteObserver ici.
 * 
 * @author (votre nom)
 * @version (un num�ro de version ou une date)
 */
public class ConcreteObserver implements Observer {

	private Stack<Observable> senders;
	private Stack<Object> arguments;

	public ConcreteObserver() {
		senders = new Stack<Observable>();
		arguments = new Stack<Object>();
	}

	/**
	 * impl�mentation de la seule m�thode de l'interface java.util.Observer �
	 * chaque ex�cution de cette m�thode, celle-ci se contente d'empiler les
	 * param�tres transmis observable et arg respectivement dans 2 piles senders
	 * et arguments
	 */
	public void update(Observable observable, Object arg) {
		senders.push(observable);
		arguments.push(arg);
	}

	public Stack<Observable> senders() {
		return senders;
	}

	public Stack<Object> arguments() {
		return arguments;
	}
	
}
