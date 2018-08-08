package ie.gmit.sw;
/*App Name: Document Jaccard Index Api
 * @Autor Kevin Gleeson
 * Version: 1.0
 * Date: 11/01/2018
 * 
 */

//Shingle class to hold hash code and doc id only
class Shingle {

	private final int docId;
	private final int hashCode;

	public Shingle(int docId, int hashCode) {
		super();
		this.docId = docId;
		this.hashCode = hashCode;
	}

	public int getDocId() {

		return docId;
	}

	public int getHashCode() {

		return hashCode;
	}
}
