import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public interface Dominos {
	
	public static void main (String [] args) {
		Path path = toPath("D:\\dominos.csv");
		List<String> csv = importData(path);
		
		String [] dominoVal = new String [csv.size()];
		String [] crown1 = new String [csv.size()];
		String [] crown2 = new String [csv.size()];
		String [] color1 = new String [csv.size()];
		String [] color2 = new String [csv.size()];
		
		for (int i = 1; i<csv.size(); i++) {
			String [] separate;
			separate = csv.get(i).split(",");
			crown1[i] = separate[0];
			color1[i] = separate[1];
			crown2[i] = separate[2];
			color2[i] = separate[3];
			dominoVal[i] = separate[4];
			
			}
		for (int i = 0; i<dominoVal.length; i++) {
			System.out.println("Nombre de couronnes sur la 1e case : " + crown1[i]);
			System.out.println("Nombre de couronnes sur la 2e case : " + crown2[i]);
			System.out.println("Terrain sur la 1e case : "+ color1[i]);
			System.out.println("Terrain sur la 2e case : "+ color2[i]);
			System.out.println("Numero du domino : "+ dominoVal[i]);
			}
		}
		
	
	public static Path toPath(String FilePath) {
		System.out.println("On vous renvoie le chemin de votre fichier");
		Path Path = Paths.get(FilePath);
		return Path;
		}
	
	public static List<String> importData(Path File) {
		List<String> lines = null;
		try {
		lines = Files.readAllLines(File);
		System.out.println("SUCCES");
		} catch (IOException e) {
			System.out.println("Impossible de lire le fichier");
		} if (lines.size() < 2) {
			System.out.println("Il n'y a pas de dominos dans le fichier");
			return null;
		}
		else {
			return lines;
		}
	}
}
