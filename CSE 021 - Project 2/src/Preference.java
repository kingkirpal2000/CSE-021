
public class Preference {

	public int quietTime;
	public int music;
	public int reading;
	public int chatting;

	public Preference (int qT, int m, int r, int c) {

		if (qT <= 10) {
			quietTime = qT;
		}
		if (m <= 10) {
			music = m;
		}
		if (r <= 10) {
			reading = r;
		}
		if (c <= 10) {
			chatting = c;
		}
	}

	public int getqT() {
		return quietTime;
	}
	public int getMusic() {
		return music;
	}
	public int getReading() {
		return reading;
	}
	public int getChatting() {
		return chatting;
	}

	public int compare(Preference pref) {
		int difQT = Math.abs(quietTime - pref.quietTime);
		int difM = Math.abs(music - pref.music);
		int difR = Math.abs(reading - pref.reading);
		int difC = Math.abs(chatting - pref.chatting);
		return difQT + difM + difR + difC;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
