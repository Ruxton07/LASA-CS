
1. Declare an integer variable **x** and on a separate line assign (or set) it to the integer **27**. Then print out the variable and its value using **`System.out.println("x = " + x);`**
2. After the print statement, add a statement that assigns **x** to  **x** + 1 (aka increments x by **1**) and then print the new value of **x**.
3. In the last print statement add a  **+ 1** after the **x**. Do you understand why it prints 281? Add a couple of characters so your program prints 29. See [https://mathbits.com/MathBits/Java/DataBasics/Printing.htm](https://mathbits.com/MathBits/Java/DataBasics/Printing.htm) 
4. Add a print statement that is just like the first print statement. Do you understand why it prints 28 and not 29 (Hint: what was the last value _assigned_ to x)?
5. Duplicate the code you already have, except for the declaration of x, and in the new lines change the value of **x** from 27 to the largest valid integer value.  When entering large numbers, are commas allowed every 3rd digit? Note what happened when you added 1 this time. See what happens if you add a bigger number. 
6. Print out  Integer.MAX_VALUE and then print  Integer.MIN_VALUE. Compare to the x values.
7. On a single line, declare a variable **y** of type double and set it to **6.2**. Then print it.
8. Assign the double variable **y** to the  integer 27 and then print it.  Check to see what would happen if you set your integer variable **x** earlier in the program to a double value like 6.2 or 27.0. 
9. Declare and assign a variable **a** of type char to the character **$**. Then print it. 
10. Set the variable **a**  to the single quote character **'** and print it.
11. Declare the variable **b** and then assign it to the string **"Hello"**, declare and set the variable **c** to **"World"**, then print out using a single print statement (not a println).

**Hello**

**\\**

**World.**

12. Declare and assign an integer constant called **DAYS_PER_WEEK** (be sure to use **final static int** ) to the integer value **7**. Assign the value **212** to the integer variable **days**. Then print **212 days is 30.2857143 weeks**. - your print statement can not contain any digits. NOTE: see if casting to a float or a double gets you the expected value. 

13. Declare and set the variable **e** to **6** and declare and set  the variable **f** to **27**. Then print  **6 + 27 = 33 (not 627)**  - your print statement can not contain any digits.

14. Declare and set the variable g to **5.8 * 2** and declare and set  the variable h to **2.5**. Then print   **integer part of g / h = 4**  - your print statement can not contain any digits. 

 

**Correct Output of your program should match the below exactly**

```
x = 27
```

```
x = 29
```

```
x = 28
```

```
x = 2147483647
```

```
x = -2147483647
```

```
x = -2147483648
```

```
x = 2147483647
```

```
x = -2147483648
```

```
y = 6.2
```

```
y = 27.0
```

```
a = $
```

```
a = '
```

```
Hello
```

```
\
```

```
World
```

```
212 days is 30.2857143 weeks.
```

```
6 + 27 = 33 (not 627)
```

```
integer part of g / h = 4
```