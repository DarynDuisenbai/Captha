# Captha

This project is a simple Java application that demonstrates a basic login system using Swing for the graphical user interface (GUI) and PostgreSQL for the database. The application allows users to log in either with a username and password or an individual identification number (IIN) and password.

## Prerequisites
- Java Development Kit (JDK) installed
- PostgreSQL database installed
- PostgresSQL JDBC driver

## Setting Up the Database
1. Create a PostgreSQL database named "Login".
2. Create a table named "test1" with the following columns:
    - `Login_user` (text)
    - `Password_user` (text)
    - `IIN_user` (text)
3. Insert some sample data into the "test1" table for testing purposes.

## Running the Application
1. Clone the project to your local machine.
2. Open the project in your preferred Java IDE.
3. Add the PostgreSQL JDBC driver to the project's dependencies.
4. Build the project to compile the source code.
5. Run the `Menu` class as the main entry point for the application.
6. The menu form will be displayed.
7. Click on the "Login" button to log in with a username and password.
8. Click on the "IIN" button to log in with an IIN and password.
9. Enter the login credentials and click the "Submit" button.
10. If the credentials are correct, a welcome message will be displayed, and a new Captcha form will be shown.
11. If the credentials are incorrect, an error message will be displayed.

## Project Structure
- The project consists of several Java classes representing different components of the application.
- The `Menu` class is the main form that acts as the entry point of the application.
- The `LoginPassword` class represents the login form for username and password authentication.
- The `IINpassword` class represents the login form for IIN and password authentication.
- The `Login` class handles the logic for checking username and password credentials in the database.
- The `IIN` class handles the logic for checking IIN and password credentials in the database.
- The `SlackNotifier` class provides functionality for sending messages to a Slack channel.
- The `Captcha` class represents a form for displaying a Captcha.
- The project also includes the necessary Swing components for building the GUI.

## Additional Notes
- This is a basic demonstration and should not be used as a production-ready authentication system.
- The application uses MD5 hashing for password storage, which is considered weak. In a real-world scenario, stronger encryption methods should be used.
- The SlackNotifier class is used to send notifications to a Slack channel. You may need to modify the `webHooksUrl` and `slackChannel` variables to match your Slack configuration.
- The project includes some hardcoded database connection credentials (`"jdbc:postgresql://localhost:5432/Login", "postgres", "mother1978"`). Make sure to update these values with your own database credentials.

Feel free to explore and modify the code to suit your needs.