package org.jogl.dem.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.vividsolutions.jts.geom.Coordinate;

public class FileReader {

	public List<Coordinate> readFile(String path) {
		
		List<Coordinate> tabCoordinate =  new ArrayList<Coordinate>();
				
		// lecture du fichier texte
		try {
			InputStream input = new FileInputStream(path);
			InputStreamReader inputReader = new InputStreamReader(input);
			BufferedReader br = new BufferedReader(inputReader);
			String ligne;
			String[] temp;
			while ((ligne = br.readLine()) != null) {
				Coordinate coordinate = new Coordinate();
				temp = ligne.split("\\s+");
				coordinate.x = Double.parseDouble(temp[0]);
				coordinate.y = Double.parseDouble(temp[1]);
				coordinate.z = Double.parseDouble(temp[2]);
				tabCoordinate.add(coordinate);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println(tabCoordinate.size());
		return tabCoordinate;
	}
}
