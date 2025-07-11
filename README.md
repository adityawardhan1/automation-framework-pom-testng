# automation-framework-pom-testng
# 🚀 Automation Framework - TestNG + Selenium + POM

This is a Test Automation Framework built using Java, Maven, Selenium WebDriver, and TestNG. It follows the **Page Object Model (POM)** design pattern and includes configuration management and custom TestNG listeners for enhanced reporting (e.g., capturing screenshots on test failure).

---

## 📁 Project Structure

automation-framework-pom-testng/
│
├── pom.xml # Maven config
├── config.properties # Test configuration (browser, URL, credentials)
├── testng.xml # TestNG suite file
│
├── src/
│ ├── main/
│ │ └── java/
│ │ └── com.aditya.utils/ # ConfigReader, utilities, listeners
│ │
│ └── test/
│ └── java/
│ ├── com.aditya.base/ # BaseTest.java (browser setup/teardown)
│ ├── com.aditya.pages/ # Page classes (LoginPage, DashboardPage, etc.)
│ └── com.aditya.tests/ # Test classes (LoginTest, DashboardTest, etc.)
│
└── screenshots/ # Captured on test failures (auto-created)

yaml
Copy
Edit

---

## ✅ Features

- 📦 **Maven** for dependency management
- 🧪 **TestNG** framework with suite file (`testng.xml`)
- 🌐 **Selenium WebDriver** for browser automation
- 🧱 **Page Object Model (POM)** for maintainable code
- ⚙️ **ConfigReader** to manage dynamic test data
- 📸 **Custom Listener** to take screenshots on test failure
- 🧹 Auto browser management via `BaseTest`

---

## ⚙️ How to Run

1. **Clone the repo**
   ```bash
   git clone https://github.com/your-username/automation-framework-pom-testng.git
   cd automation-framework-pom-testng
Update configuration
Edit config.properties as needed:

properties
Copy
Edit
baseUrl=https://www.saucedemo.com/
browser=chrome
username=standard_user
password=secret_sauce
Run tests

bash
Copy
Edit
mvn clean test
🧪 Test Example
java
Copy
Edit
@Test
public void validLoginTest() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(username, password);

    Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), 
        "Login failed or did not redirect correctly.");
}
📸 Screenshot on Failure
If a test fails, a screenshot is automatically saved in the /screenshots/ directory. This is handled by TestListener.java.

🧩 Dependencies (from pom.xml)
selenium-java

testng

webdrivermanager (recommended)

maven-surefire-plugin

🧠 Author
Aditya Wardhan
Computer Science Engineer | Automation Enthusiast

