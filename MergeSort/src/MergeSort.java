
import java.util.Arrays;

/**
 * @author stpaulifan
 * @version 1.00, 30.11.2018
 * 
 *          MergeSort
 */

public class MergeSort {

	/**
	 * Der Sort Prozess mit Divide Am Ende Aufruf des Merge Prozesses
	 * 
	 * @param Arr
	 * @param links
	 * @param rechts
	 */
	public static void sort(int Array[], int links, int rechts) {
		// Divide and sort Array in zwei Hälften

		// wenn l nicht kleiner r --> nur ein Wert --> Ende
		if (links < rechts) {
			// Ermittlung der Mitte des Arrays
			int mitte = (links + rechts) / 2;

			// Sortierung der beiden Hälften
			sort(Array, links, mitte);
			sort(Array, mitte + 1, rechts);

			// Aufruf Merge
			merge(Array, links, mitte, rechts);
		}
	}

	/**
	 * Der Merge Prozess mit dem Hilfsarray Beide TeilArrays des HilfArrays
	 * durchindexen und prüfen welcher Wert größer
	 * 
	 * @param array
	 * @param links
	 * @param mitte
	 * @param rechts
	 */

	public static void merge(int array[], int links, int mitte, int rechts) {

		// Erstellen HilfsArrays
		int[] HilfsArray = new int[array.length];

		// Sortierte Teilarrays in Hilfsarray übergeben
		for (int i = links; i <= rechts; ++i)
			HilfsArray[i] = array[i];

		// Index der Subarrays und Array auf ersten Wert setzten
		int indexLinkesArray = links;
		int indexRechtesArray = mitte + 1;
		int arrayIndex = links;

		// Solange bis Indexwert der SubArrays kleiner als Länge ist
		while (indexLinkesArray <= mitte && indexRechtesArray <= rechts) {

			// Werte beider Arrays vergleichen und den kleineren in Array einsetzen
			if (HilfsArray[indexLinkesArray] <= HilfsArray[indexRechtesArray]) {
				array[arrayIndex] = HilfsArray[indexLinkesArray];
				indexLinkesArray++;

				// Wert rechtes Array ist kleiner -> Wert in Array einsetzen
			} else {
				array[arrayIndex] = HilfsArray[indexRechtesArray];
				indexRechtesArray++;

			}
			// ArrayIndex hochzählen
			arrayIndex++;
		}

		// Falls noch weitere Werte übrig sind
		int werteUebrig = mitte - indexLinkesArray;
		for (int i = 0; i <= werteUebrig; i++) {

			array[arrayIndex + i] = HilfsArray[indexLinkesArray + i];

		}

	}

	/**
	 * Testen des MergSort mit statischem Array
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] Arr1 = { 19, 23, 14, 7, 21, 20, 6, 1, 17, 13, 12, 9, 3 };
		System.out.println(Arrays.toString(Arr1));
		MergeSort.sort(Arr1, 0, Arr1.length - 1);
		// MergeSort.sort(Arr1, 0, Arr1.length - 1);
		System.out.println("Sortiert:" + Arrays.toString(Arr1));
		System.out.println("\n");
	}
}
