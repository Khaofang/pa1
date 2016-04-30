/** 
 * Running Unit Converter GUI
 * @author Chayanin Punjakunaporn
 */
public class Application {
	public static void main(String[] args) {
		ConverterUI frame = new ConverterUI(new UnitConverter());
		frame.run();
	}
}
