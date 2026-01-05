## 📖 Project Overview

This project is a **Test Automation framework** for the [SauceDemo](https://www.saucedemo.com/) website.  
It uses **Java**, **Selenium WebDriver**, **TestNG**, and **Gradle** with **Page Object Model (POM)** for maintainability and readability.  

The framework covers **end-to-end user flows** for multiple user types:

- **Locked Out User** → verifies login failure for locked accounts.  
- **Standard User** → verifies a complete purchase journey (add to cart → checkout → logout).  
- **Performance Glitch User** → verifies purchase journey under performance glitch conditions with extra steps like sorting products, adding/removing items, and verifying cart totals.

---
## 🛠 Technologies Used

- Java 17+  
- Selenium WebDriver 4+  
- TestNG 7+  
- Gradle  
- ChromeDriver / FirefoxDriver  
- WebDriverManager (optional, automatic driver management)  


## 🧪 Tests Included (Full Steps)

| Test Name                     | Description (Full Steps)                                                                                               | Class Path                                      |
|--------------------------------|------------------------------------------------------------------------------------------------------------------------|------------------------------------------------|
| **Locked Out User Test**       | 1. Opens homepage <br> 2. Attempts login with `locked_out_user` <br> 3. Verifies login fails <br> 4. Checks correct error message | `tests.LockedOutUserTest`                     |
| **Standard User Purchase Test**| 1. Logs in as `standard_user` <br> 2. Resets app state <br> 3. Adds products to cart <br> 4. Verifies cart badge <br> 5. Opens cart and scrolls <br> 6. Proceeds to checkout <br> 7. Enters checkout details <br> 8. Verifies item total <br> 9. Completes checkout <br> 10. Verifies success message <br> 11. Returns to products <br> 12. Logs out <br> 13. Confirms login button visible | `tests.StandardUserPurchaseTest`              |
| **Performance Glitch User Test**| 1. Logs in as `performance_glitch_user` <br> 2. Sorts products Z → A <br> 3. Adds products after sorting <br> 4. Verifies cart badge <br> 5. Removes Red Shirt <br> 6. Verifies updated cart badge <br> 7. Continues shopping and adds more <br> 8. Scrolls page <br> 9. Verifies updated cart badge <br> 10. Opens cart and checkout <br> 11. Enters checkout details <br> 12. Verifies item total <br> 13. Completes checkout <br> 14. Verifies success message <br> 15. Returns to products <br> 16. Logs out <br> 17. Confirms login button visible | `tests.PerformanceGlitchUserPurchaseTest`    |


## 🚀 How to Run the Project

### 1️⃣ Prerequisites
- **Java 17+** installed  
- **Gradle** installed (or use Gradle wrapper included)  
- **ChromeDriver / GeckoDriver** in system PATH (optional if using WebDriverManager)  
- IDE (IntelliJ IDEA / Eclipse / VS Code)  

### 🧪 Test Execution Report

You can view the TestNG execution report using the links below:
- **TestNG Report Screenshot:** [View Report](https://prnt.sc/FI8r2wQyvc-K)

---

## ⚙️ Project Structure

```text
SauceDemo-TestNG-Automation/
├── config/
│   └── Setup.java           # Browser setup & teardown, page initialization
│
├── pages/
│   ├── LoginPage.java
│   ├── HomePage.java
│   ├── CartPage.java
│   ├── CheckoutPage.java
│   └── ConfirmationPage.java
│
├── tests/
│   ├── LockedOutUserTest.java
│   ├── StandardUserPurchaseTest.java
│   └── PerformanceGlitchUserPurchaseTest.java
│
├── utils/
│   └── BrowserUtils.java    # Helper methods
│
├── resources/
│   └── suite.xml            # TestNG suite
│
├── build.gradle             # Gradle build configuration
├── gradlew / gradlew.bat    # Gradle wrapper
└── README.md



