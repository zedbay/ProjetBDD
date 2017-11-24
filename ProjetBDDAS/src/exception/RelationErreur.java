package exception;

public class RelationErreur extends Exception {

	private static final long serialVersionUID = 1L;

	public RelationErreur() {
		System.out.println("Relation non connue");
	}
}
