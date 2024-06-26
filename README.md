# LunaJavaSeleniumTestNGAllure 
[![Java CI with Maven](https://github.com/kgold2018/LunaJavaSeleniumTestNGAllure/actions/workflows/maven.yml/badge.svg)](https://github.com/kgold2018/LunaJavaSeleniumTestNGAllure/actions/workflows/maven.yml)
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LunaJavaSeleniumTestNGAllure</title>
</head>
<body>

<h1>LunaJavaSeleniumTestNGAllure</h1>

<h2>Project Description</h2>
<p>This project is a comprehensive test automation suite for the LUMA application, utilizing Java with Selenium WebDriver, TestNG for test management, and Allure for reporting. The suite is designed to provide robust and efficient end-to-end testing capabilities, ensuring the quality and reliability of the LUMA application.</p>

<h2>Features</h2>
<ul>
    <li><strong>Java</strong>: The core programming language used for writing test scripts.</li>
    <li><strong>Selenium WebDriver</strong>: Used for browser automation, enabling interaction with the LUMA application's web elements.</li>
    <li><strong>TestNG</strong>: Provides advanced test configuration, management, and execution capabilities.</li>
    <li><strong>Allure</strong>: Integrated for generating detailed and visually appealing test reports.</li>
    <li><strong>Maven</strong>: Used for project build and dependency management.</li>
</ul>

<h2>Getting Started</h2>

<h2>Prerequisites</h2>
<ul>
    <li><strong>Java Development Kit (JDK)</strong>: Version 8 or higher.</li>
    <li><strong>Maven</strong>: For managing project dependencies and build lifecycle.</li>
    <li><strong>Selenium WebDriver</strong>: Compatible version for your browser.</li>
    <li><strong>TestNG</strong>: Testing framework.</li>
    <li><strong>Allure</strong>: For generating test reports.</li>
</ul>

<h3>Installation</h3>
<ol>
    <li><strong>Clone the Repository</strong>
        <pre><code>git clone https://github.com/kgold2018/LunaJavaSeleniumTestNGAllure.git
cd LunaJavaSeleniumTestNGAllure
        </code></pre>
    </li>
   <li><strong>Install Dependencies</strong>
        <pre><code>mvn clean install
        </code></pre>
    </li>
</ol>

<h3>Configuration</h3>
<ol>
    <li>Update the <code>config.properties</code> file with the necessary configuration details, such as browser type, base URL, etc.</li>
    <li>Ensure the correct WebDriver is set up in the <code>drivers</code> folder (e.g., <code>chromedriver</code> for Chrome).</li>
</ol>

<li><strong>Run Tests</strong>
<ol>
    <li>To run tests, use the following Maven command:
        <pre><code>mvn test
        </code></pre>
    </li>
    <li><strong>Generate Allure Report</strong>
        <pre><code>allure serve target/allure-results
        </code></pre>
    </li>
</ol>

<h2>Project Structure</h2>
<pre>
<code>
LunaJavaSeleniumTestNGAllure/
├── src/
│   └── main/
│   │   └── java/
│   │   │   └── com/
│   │   │       └── lumatest/
│   │   │           └── pages/
│   │   │          
│   │   └── resources/
│   │       └── config.properties
│   ├── test/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── lumatest/
│   │   │           └── base/
│   │   │           └── data/
│   │   │           └── test/
                    └── utils/

│   │   └── resources/
├── drivers/
│   └── chromedriver
│   └── geckodriver
├── target/
│   └── allure-results/
├── .gitignore
├── pom.xml
├── README.md
└── testing.xml
    </code>
</pre>
<ul>
    <li><strong>src/main/java</strong>: Contains the Page Object Model code.</li>
    <li><strong>src/test/java</strong>: Contains the test cases.</li>
    <li><strong>pom.xml</strong>: Maven configuration file.</li>
</ul>

<h2>Usage</h2>
<ul>
    <li><strong>Writing Tests</strong>: Create your test classes in the <code>src/test/java/com/yourpackage/</code> directory.</li>
    <li><strong>Running Tests</strong>: Use TestNG annotations to configure and run your tests.</li>
    <li><strong>Viewing Reports</strong>: After running tests, generate and view reports using Allure commands.</li>
</ul>

<h2>License</h2>
<p>This project is licensed under the MIT License - see the <a href="LICENSE">LICENSE</a> file for details.</p>

<h2>Contact</h2>
<p>For any questions or issues,  contact klava.gold.ca@gmail.com </p>

</body>
</html>
