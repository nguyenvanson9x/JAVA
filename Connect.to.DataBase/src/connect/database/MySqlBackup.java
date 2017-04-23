package connect.database;

public class MySqlBackup {

	public void restoreDB(String path) {

		String executeCmd = "mysqldump -u root -proot -B smartparkingsystem -r " + path;

		System.out.println(executeCmd);

		Process runtimeProcess;

		try {
			runtimeProcess = Runtime.getRuntime().exec(new String[] { "cmd.exe", "/c", executeCmd });

			int processComplete = runtimeProcess.waitFor();

			System.out.println(processComplete);

			if (processComplete == 0) {
				System.out.println("Backup Created Successfully !");
			} else {
				System.out.println("Couldn't Create the backup !");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void main(String[] args) {

		new MySqlBackup().restoreDB("D:/File.sql");
	}
	
	/*
	 
	 */

}