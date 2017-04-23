package course.algo.exos.compression;

/**
 * @author Phuong LE-HONG
 *         <p>
 *         Jan 25, 2015, 2:58:23 PM
 *         <p>
 *         The RLE algorithm to compress data.
 *
 */
public class RLE {

	/**
	 * Computes the length of the compression array.
	 * 
	 * @param t
	 *            a binary array
	 * @return an integer.
	 */
	public static int length(int[] t) {
		int l = 0;
		for (int i = 0; i < t.length - 1; i++) {
			if (t[i] != t[i + 1])
				l++;
		}
		return (l + 1) * 2;
	}

	/**
	 * Compresses an array in RLE format and return the result.
	 * 
	 * @param t
	 * @return compressed array.
	 */
	public static int[] compress(int[] t) {
		int[] c = new int[t.length];
		int i = 0;
		int k = 1;
		c[i] = t[0];
		for (int j = 0; j < t.length - 1; j++) {
			if (t[j] != t[j+1]) {
				c[++i] = k;
				c[++i] = t[j+1];
				k = 1;
			} else {
				k++;
			}
		}
		c[++i] = k;
		
		return c;
	}

	/**
	 * Computes the length of the decompressed array.
	 * 
	 * @param t
	 * @return an integer.
	 */
	public static int lengthInverse(int[] t) {
		if (t== null)
			return 0;
		int l = 0;
		for (int i = 0; i < t.length/2; i++) {
			l += t[2*i+1];
			return l;
		}
		return 0;
	}

	/**
	 * Decompresses the array.
	 * 
	 * @param t
	 * @return an array
	 */
	public static int[] decompress(int[] t) {
		if (t == null)
			return null;
		int i = 0;
		int[] d = new int[lengthInverse(t)];
		
		for (int j = 0; j < t.length/2; j++) {
			for (int k = 0; k < t[2*j+1]; k++) {
				d[i++] = t[2*j];
			}
		}
		
		return d;
	}
}
