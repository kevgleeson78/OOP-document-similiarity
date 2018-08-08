package ie.gmit.sw;
/*App Name: Document Jaccard Index Api
 * @Autor Kevin Gleeson
 * Version: 1.0
 * Date: 11/01/2018
 * 
 */

//Class for storing the url of each file to inserted by the user
class GetDoc {
	private String path;

	public GetDoc() {
		this.path = "";
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = "./"+path;
	}
}
