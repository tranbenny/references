public class jsonFileRead {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {
			// reading in file and convert file to json object or array of json objects
			Object object = parser.parse(new FileReader('path to file here'));
			JSONObject jsonObject = (JSONObject) object;
			JSONArray jsonArray = (JSONArray) object;

			// extracting properties
			String property = (String) jsonObject.get("INSERT PROPERTY NAME HERE");
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		} catch(IOException ex) {
			ex.printStackTrace();
		} catch(ParseException ex) {
			ex.printStackTrace();
		} catch(NullPointerException ex) {
			ex.printStackTrace();
		}
	}
}