package bits.navalassault.model;

public class SoundPlayer {
	
	private static Boolean soundEnabled = true;
	
	public static Boolean getSoundEnabled() {
		return soundEnabled;
	}
	
	public static void setSoundEnabled(Boolean value) {
		soundEnabled = value;
		}
}