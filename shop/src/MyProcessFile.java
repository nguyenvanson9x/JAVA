import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyProcessFile {

	private static ObjectInputStream oIn;
	private static ObjectOutputStream oOut;

	public static void saveData(Object list, String fileName)

	{

		try

		{

			FileOutputStream fOut = new FileOutputStream(fileName);

			oOut = new ObjectOutputStream(fOut);

			oOut.writeObject(list);

		}

		catch (Exception ex)

		{

			ex.printStackTrace();

		}

	}

	public static Object openData(String fileName)

	{

		try

		{

			FileInputStream fIn = new FileInputStream(fileName);

			oIn = new ObjectInputStream(fIn);

			return oIn.readObject();

		}

		catch (Exception ex)

		{

			ex.printStackTrace();

		}

		return null;

	}

}