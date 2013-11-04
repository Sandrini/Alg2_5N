import java.io.Console;
import static java.lang.System.*;

public class Login {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Console console = console();
		String username, password;
		out.print("Username: ");
		
		username = console.readLine();
		out.print("Password: ");
		
		password = new String (console.readPassword());
		
		out.println(username + " - " + password);

	}

}
