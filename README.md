Alpha Test Cases

<h3>Test Case 1: Successful Login Check </h3>
<p><i>Goal: Ensure the user can successfully log in when entering correct data.</i></p>

<h4>Steps:</h4>
<ol>
<li> Open the application. </li>
<li> Ensure the header displays as "Вход to Alfa-Test." </li>
<li> Enter the correct username. </li>
<li> Enter the correct password. </li>
<li> Click the "Войти" button. </li>
</ol>

<h4>Expected Result:</h4> 
The screen transitions to "Вход в Alfa-Test выполнен"

<h3>Test Case 2: Character Limit and Invalid Character Check for Username </h3>
<p><i>Goal: Ensure that the login input is limited to 50 characters and valid characters, and an error message is displayed when this limit is exceeded</i></p>

<h4>Steps:</h4>
<ol>
<li> Open the application. </li>
<li> Enter a string longer than 50 characters containing invalid characters into the login field. </li>
</ol>


<h4>Expected Result:</h4>
The login is truncated to 50 characters, and invalid characters are not saved.
The message "Введены неверные данные" is displayed for the login field.

<h3>Test Case 3: Behavior of "Hide" Icon for Password Field </h3>
<p><i>Goal: Ensure that the "hide" icon correctly toggles the visibility of the entered characters. </i></p>

<h4>Steps:</h4>
<ol>
<li> Open the application. </li>
<li> Enter a password into the "Password" field." </li>
<li> Click the "hide" icon once. </li>
<li> Click the "hide" icon again. </li>
</ol>

<h4>Expected Result:</h4>
After the first click, the password characters become visible. After the second click, the password characters are hidden and marked with the '•' symbol.

<h3>Test Case 4: Character Limit Check for Password Field </h3>
<p><i>Goal:  Ensure that the password input is limited to 50 characters and that an error message is displayed when this limit is exceeded.</i></p>

<h4>Steps:</h4>
<ol>
<li> Open the application. </li>
<li> Enter a string longer than 50 characters into the "Password" field. </li>
</ol>

<h4>Expected Result:</h4>
The password is truncated to 50 characters. The message "InvalidValue" is displayed for the password field.

<h3>Test Case 5: Field Validation Check on "Войти" Button Click </h3>
<p><i>Goal: Ensure that the login and password fields are validated when the "Войти" button is clicked, and that appropriate error messages are displayed in case of invalid input.</i></p>

<h4>Steps:</h4>
<ol>
<li> Open the application. </li>
<li> Enter an incorrect username and password. </li>
<li> Click the "Войти" button. </li>
<li> Enter login and leave the password field empty. </li>
<li> Click the "Войти" button. </li>
<li> Enter password and leave the login field empty.</li>
<li> Click the "Войти" button. </li>
<li> Leave the login and password fields empty </li>
<li> Click the "Войти" button. </li>
</ol>

<h4>Expected Result:</h4>
The message "Введены неверные данные" is displayed for all entered data
